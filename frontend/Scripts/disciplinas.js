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
            this.horas = this.creditos*15;
        },
        validaCadastro: function(){
            if(this.disciplina == "" || this.codigo_disciplina == "" || this.grade == "" || this.semestre == ""){
                alert("Cadastro inválido");
            }
            else{
                atualizar = this.existe_disc(this.codigo_disciplina);
                console.log(this.codigo_disciplina);
                if(atualizar){
                    yesno = confirm("Código ja existe, deseja atualizar a disciplina?");
                    if(yesno){
                        altera_disciplina(this.semestre, this.disciplina, this.codigo_disciplina, this.creditos, this.cresitos*4, this.grade);
                        alert('Disciplina cadastrada');
                    }        
                    else{
                        alert('Disciplina não cadastrada');
                    }
                }    
                else{
                    if(this.grade == "Ambas"){
                        cadastra_disciplina(this.semestre, this.disciplina, this.codigo_disciplina, this.creditos, this.horas, "Nova");
                        cadastra_disciplina(this.semestre, this.disciplina, this.codigo_disciplina, this.creditos, this.horas, "Antiga");

                    }
                    else{
                        cadastra_disciplina(this.semestre, this.disciplina, this.codigo_disciplina, this.creditos, this.horas, this.grade);
                    }
                    alert('Disciplina cadastrada');
                    
                }
            }
        },
        existe_disc: function(codigo){
                disciplina = disciplinas.get_disciplina(codigo);
                if(disciplina.length == 0){
                    return false;
                }
                else{
                    return true;
                }
        }
    }
})

disciplinas = new Vue({
    el: '#disciplinas',
    data:{
        selecionadas: [],
        disciplinas: get_disciplinas() //Precisa pegar do banco de dados
    },
    methods: {
        getDisc: function(){
            //getAllDisciplinas
            return this.disciplinas;
        },
        validaCreditos: function(){
            creditos = this.selecionadas.map(e => e.creditos).reduce((e,a) => e+a);
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
                cadastra_pre_matricula(this.selecionadas);
                alert("Pré-matricula executada com sucesso");
            }
        },
        deletaDisciplina: function(codigo){
            disciplina = this.get_disciplina(codigo)[0];
            this.apaga_disciplina(disciplina);
        },
        get_disciplina: function(codigo){
            element = this.disciplinas.filter(e => e.codigo_disciplina == codigo);
            if(element.length == 0){
                return [];
            }
            return element;
        },
        apaga_disciplina: function(disciplina){
            console.log(JSON.stringify(disciplina));
            fetch('https://backend-matricula.herokuapp.com/disciplinas/', {
                headers: {
                    'Content-Type': 'application/json'
                },
                method: "DELETE", 
                body: JSON.stringify(disciplina.codigo_disciplina)
            })
        .then(response => response.json()).then(e => console.log(e));
        }, 
    }
})

function cadastra_pre_matricula(discs){
    disciplinasInteresse = discs.map(e => e = e.codigo_disciplina);
    matr = matricula;
    disciplinasInteresse.map(e => cadastra_interesse(e, matr));
}

function cadastra_interesse(disc, matr){
    fetch('https://backend-matricula.herokuapp.com/alunos/' + matr, {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "POST", body: JSON.stringify(disc)})
        .then(response => response.json()).then(response => console.log(response));
}

function carrega_aluno_cadastro(){
    var user = gapi.auth2.getAuthInstance().currentUser.Ab.w3;
    email = user.U3;
    fetch('https://backend-matricula.herokuapp.com/alunos/').then(response => response.json()).then(promise => carregaMatricula(promise, email));
}

var matricula = ""

function carregaMatricula(todos, email){
    alunoAtual = todos.filter(e => e.email == email)[0];
    matricula = alunoAtual.matricula;
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
}

function putDisciplina(disciplina){
    fetch('https://backend-matricula.herokuapp.com/disciplinas/', {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "PUT", body: JSON.stringify(disciplina)})
        .then(response => response.json());
}


function postaDisciplina(disciplina){
    fetch('https://backend-matricula.herokuapp.com/disciplinas/', {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "POST", body: JSON.stringify(disciplina)})
        .then(response => response.json()).then(response => console.log(response));
}

function cadastra(discs, grade){
    semOptativas = discs.filter(e => e.disciplina.substring(0,8) != "Optativa");
    semOptativas.map(e => cadastra_disciplina(e.semestre, e.disciplina, e.codigo_disciplina, e.creditos, e.horas, grade));
}

function get_disciplinas(){
    fetch('https://backend-matricula.herokuapp.com/disciplinas/')
    .then(response => response.json())
     .then(function(promise){
        disciplinas.disciplinas = promise;
     })
}

function importa_disciplinas_api_analytics(){
    fetch('http://analytics.ufcg.edu.br/pre/ciencia_da_computacao_i_cg/disciplinas').then(response => response.json()).then(promise => cadastra(promise, "Nova")).catch(alert("API do analytics fora do ar"));
    fetch('http://analytics.ufcg.edu.br/pre/ciencia_da_computacao_d_cg/disciplinas').then(response => response.json()).then(promise => cadastra(promise, "Antiga")).catch(console.log("API do analytics fora do ar"));
}

function apagar_todas_disciplinas(){
    discs = disciplinas.getDisc();
    yesno = confirm("Deseja realmente apagar todas as disciplinas?");
    if(yesno){
        discs.map(e => disciplinas.apaga_disciplina(e));        
        alert('Disciplinas apagadas');
    }        
    else{
        alert('Nenhuma disciplina foi deletada');
    }
}

