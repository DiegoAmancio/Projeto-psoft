lista_de_alunos = []
aluno = new Vue({
    el: '#cadastroAluno',
    data: {
        nome: "",
        matricula: "",
        periodo: "",
        grade: "",
        email: "",
        disciplinas: []
    },
    methods: {
        validaCadastro: function(){
            if(this.grade == "" || this.matricula == ""){
                alert("Cadastro não concluido");
            }
            else{
                cadastraAluno(this.grade, this.matricula);
                alert("Cadastro concluido");
            }
        }
    }
})

var alunos = new Vue({
    el: '#alunos',
    data:{
        aux: [],
        alunos: getAlunos()
    },
    methods: {
        getCadeiras: function(cadeiras){
            x = cadeiras.map(e => e.disciplina);
            console.log(x);
            return x;
        }
    }

})

function getAlunoAtual(){
    var user = gapi.auth2.getAuthInstance().currentUser.Ab.w3;
    email = user.U3;
    getAluno(email);
}

function getAluno(email){
    fetch('https://backend-matricula.herokuapp.com/alunos/').then(response => response.json()).then(promise => carregaAluno(promise, email));
}
    
function aluno_matricula(email){
    return aluno.matricula;
}

function carregaAluno(todos, email){
    alunoAtual = todos.filter(e => e.email == email)[0];
    aluno.nome = alunoAtual.nome;
    aluno.email = email;
    aluno.matricula = alunoAtual.matricula;
    aluno.periodo = "20" + alunoAtual.matricula[1] + alunoAtual.matricula[2] + "." + alunoAtual.matricula[3];
    aluno.grade = alunoAtual.grade;
}

function cadastraAluno(grade, matricula){
    aluno = {};
    aluno.grade = grade;
    aluno.matricula = matricula;
    var user = gapi.auth2.getAuthInstance().currentUser.Ab.w3;
    email = user.U3;
    nome = user.ig;
    aluno.nome = nome;
    aluno.email = email;
    postaAluno(aluno);
}

function carregaAlunos(todos){
    alunos.alunos = todos;
    console.log(alunos)
}
function getAlunos(){
    fetch('https://backend-matricula.herokuapp.com/alunos/').then(response => response.json()).then(function(promise){
    alunos.alunos = promise;    
    console.log(alunos);
    }).catch(() => getAlunos())
}
function postaAluno(aluno){
    fetch('https://backend-matricula.herokuapp.com/alunos/', {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "POST", body: JSON.stringify(aluno)})
        .then(response => response.json()).then(response => console.log(response));
}
fetch('https://backend-matricula.herokuapp.com/alunos/').then(response => response.json()).then(function(promise){
    console.log(promise);    
    console.log(alunos);
    })