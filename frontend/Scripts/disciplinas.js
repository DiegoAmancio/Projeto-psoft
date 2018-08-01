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
        disciplina: "",
        codigo_disciplina: "",
        creditos: 0,
        horas: 0,
        grade: "",
        semestre: ""

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
            return this.disciplinas;
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
            return this.disciplinas;
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
    disciplina.semestre = periodo;
    disciplina.disciplina = nome;
    disciplina.codigo_disciplina = codigo;
    disciplina.creditos = credito;
    disciplina.horas = carga;
    disciplina.grade = grade;
    postaDisciplina(disciplina);
    disc.disciplinas.push(disciplina);    

}

function altera_disciplina(periodo, nome, codigo, credito, carga, grade){
    disciplina = {};
    disciplina.semestre = periodo;
    disciplina.disciplina = nome;
    disciplina.codigo_disciplina = codigo;
    disciplina.creditos = credito;
    disciplina.horas = carga;
    disciplina.grade = grade;
    putDisciplina(disciplina);
    disc.disciplinas.push(disciplina);
}

function putDisciplina(disciplina){
    fetch('http://localhost:8088/disciplinas/', {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "PUT", body: JSON.stringify(disciplina)})
        .then(response => response.json()).then(e => console.log("" + e));
}

function putDisciplina(disciplina){
    conosle.log("Chegou");
    fetch('http://localhost:8088/disciplinas/', {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "PUT", body: JSON.stringify(disciplina)})
        .then(response => response.json()).then(e => console.log("" + e));
}

function postaDisciplina(disciplina){
    fetch('http://localhost:8088/disciplinas/', {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "POST", body: JSON.stringify(disciplina)})
        .then(response => response.json());
}

function cadastra2(discs){
    semOptativas = discs.filter(e => e.disciplina.substring(0,8) != "Optativa");
    novas = disc.getDisc();
    novasNome = novas.map(e => e.nome)
    repetidas = semOptativas.filter(e => e.nome in novasNome);
    naoRepetidas = semOptativas.filter(e => !(e.nome in novasNome));

    repetidas.map(e => altera_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Ambas'));
    naoRepetidas.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Antiga'));
}

function cadastra(discs){
    semOptativas = discs.filter(e => e.disciplina.substring(0,8) != "Optativa");
    semOptativas.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Nova'));
}

function cadastra2(discs){
    semOptativas = discs.filter(e => e.disciplina.substring(0,8) != "Optativa");
    novas = disc.getDisc();
    novasNome = novas.map(e => e.nome);
    repetidas = semOptativas.filter(e => e.nome in novasNome);
    naoRepetidas = semOptativas.filter(e => !(e.nome in novasNome));

    repetidas.map(e => altera_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Ambas'));
    naoRepetidas.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, 'Antiga'));
}



function cadastraD(discs){
    discs.map(e => disc.disciplinas.push(e));
}
/*
function get_alunos(){
    axios.get('/api/alunos').then(e => alunos.alunos.push(e));

}
*/

//fetch('http://analytics.ufcg.edu.br/pre/ciencia_da_computacao_i_cg/disciplinas').then(response => response.json()).then(promise => cadastra(promise));
fetch('http://localhost:8088/disciplinas/').then(response => response.json()).then(promise => cadastraD(promise));
//fetch('http://analytics.ufcg.edu.br/pre/ciencia_da_computacao_d_cg/disciplinas').then(response => response.json()).then(promise => cadastra2(promise));
