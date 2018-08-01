//import axios
new Vue({
    el: '#cadastroAluno',
    data: {
        nome: "",
        cadastrado: false,
        matricula: "",
        periodo: "",
        grade: "",
        disciplinas: []
    },
    methods: {
        geraPeriodo: function(){
            x = matricula.substring(1,4);
            periodo = x[0] + x[1] + "." + x[3];
        },
        validaCadastro: function(){
            if(grade == "" || matricula == ""){
                alert("Cadastro não concluido");
            }
            else{
                //cadastraAluno()
                cadastrado = true;
                alert("Cadastro concluido");
            }
        },
        alunoCadastrado: function(){
            return cadastrado;
        }
    }
})

alunos = new Vue({
    el: '#alunos',
    data:{
        alunos: []
    },
    methods: {
        getAlunos: function(){
            //getAllAlunos
            return alunos;
        }
    }

})

new Vue({
    el: '#cadastro_disc',
    data: {
        nome: "",
        codigo: "",
        creditos: 0,
        carga: 0,
        grade: "",
        periodo: ""

    },
    methods:{
        atualizacarga: function(){
            creditos = document.getElementById('creditos').value;
            carga = creditos*15;
            document.getElementById('carga').value = carga;
        },
        validaCadastro: function(){
            if(nome == "" || codigo == "" || grade == "" || periodo == ""){
                alert("Cadastro inválido");
            }
            else{
                atualizar = existe_nome_disc(nome, grade) || existe_codigo_disc(codigo, grade);
                if(atualizar){
                    yesno = confirm("Nome da disciplina ou código ja existe nessa grade, deseja atualizar?");
                    if(yesno){
                        cadastra_disciplina(nome, codigo, creditos, carga, grade); //atualiza_disciplina
                        alert('Disciplina cadastrada');
                    }        
                    else{
                        alert('Disciplina não cadastrada');
                    }
                }    
                else{
                    cadastra_disciplina(nome, codigo, creditos, carga, grade);
                    alert('Disciplina cadastrada');
                }
            }
        },
    }
})

disc = new Vue({
    el: '#disciplinas',
    data:{
        selecionadas: [],
        disciplinas:[] //Precisa pegar do banco de dados
    },
    methods: {
        getDisc: function(){
            //getAllDisciplinas
            return disciplinas;
        },
        validaCreditos: function(){
            creditos = selecionadas.map(e => e.creditos).reduce((e,a) => e+a);
            dependencia = false;
            if(creditos < 16){
                alert("Créditos insuficientes, coloque mais disciplinas");
            }
            else if(creditos > 24){
                alert("Créditos excedentes, coloque menos disciplinas");
            }
            else if(dependencia){
                alert("Combinação inválida");
            }
            else{
//                cadastraPreMatricula();
                alert("Pré-matricula executada com sucesso");
            }
        }
    }
})

disc2 = new Vue({
    el: '#disciplinasCoord',
    data:{
        disciplinas:[] //Precisa pegar do banco de dados
    },
    methods: {
        getDisc: function(){
            return disciplinas;
        },
        deletaDisciplina: function(codigo){
            //deleta no banco de dados axios.delete('/api/disciplinas/'+codigo);
        }
    }
})

function existe_nome_disc(nome, grade){
    return false;
}

function existe_codigo_disc(codigo, grade){
    return false;
}

function cadastra_disciplina(periodo, nome, codigo, credito, carga, grade){
    disciplina = {};
    disciplina.periodo = periodo;
    disciplina.nome = nome;
    disciplina.codigo = codigo;
    disciplina.creditos = credito;
    disciplina.carga = carga;
    disciplina.grade = grade;
//    postaDisciplina(disciplina);
    disc.disciplinas.push(disciplina);
    disc2.disciplinas.push(disciplina);

}

function postaDisciplina(disciplina){
    axios.post( '/api/disciplinas', disc).then(function(){
        console.log('SUCCESS!!');
        })
        .catch(function(){
        console.log('FAILURE!!');
        });
}

function cadastra(discs){
    semOptativas = discs.filter(e => e.disciplina.substring(0,8) != "Optativa");
    semOptativas.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Nova'));
}

function cadastra2(discs){
    semOptativas = discs.filter(e => e.disciplina.substring(0,8) != "Optativa");
    novas = disc.getDisc();
    novasNome = novas.map(e => e.nome)
    repetidas = semOptativas.filter(e => e.nome in novasNome);
    naoRepetidas = semOptativas.filter(e => !(e.nome in novasNome));
    novasFitler = novas.filter(e => !(e in repetidas) && !(e in naoRepetidas));
    novaFilter.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Nova'));
    repetidas.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Ambas'));
    naoRepetidas.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Antiga'));
}

function get_disciplinas(){
    axios.get('/api/disciplinas').then(e => disc.disciplinas.push(e));
}

function get_alunos(){
    axios.get('/api/alunos').then(e => alunos.alunos.push(e));
}

//get_disciplinas()
fetch('http://analytics.ufcg.edu.br/pre/ciencia_da_computacao_i_cg/disciplinas').then(response => response.json()).then(promise => cadastra(promise));
fetch('http://analytics.ufcg.edu.br/pre/ciencia_da_computacao_d_cg/disciplinas').then(response => response.json()).then(promise => cadastra2(promise));
/*cadastra_disciplina('OAC', '0401', 4, 60, 'Ambas');
cadastra_disciplina('LOAC', '0402', 4, 60, 'Ambas');
cadastra_disciplina('PLP', '0403', 4, 60, 'Ambas');
cadastra_disciplina('PSoft', '0404', 4, 60, 'Ambas');
cadastra_disciplina('BD', '0405', 4, 60, 'Ambas');
cadastra_disciplina('EDA', '0301', 4, 60, 'Ambas');
cadastra_disciplina('LEDA', '0302', 4, 60, 'Ambas');*/