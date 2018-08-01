
new Vue({
    el: '#cadastroAluno',
    data: {
        nome: "",
        cadastrado: false,
        matricula: "",
        periodo: "",
        grade: "",
        disciplinas: [],
        email: "",
        senha:""
    },
    methods: {
        geraPeriodo: function(){
            x = matricula.substring(1,4);
            this.periodo = x[0] + x[1] + "." + x[3];
        },
        validaCadastro: function(){
            if(this.matricula.length != 9 || this.grade == ""){
                alert("Cadastro não concluido");
            }
            else{
                //cadastraAluno()
                this.geraPeriodo();
                this.email = googleUser.getBasicProfile().getEmail();
                this.nome = googleUser.getBasicProfile().getName();
                cadastrado = true;
                cadastra_aluno(this.matricula, this.nome, this.grade, this.senha, this.email);
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
        alunos: getAluno()
    },
    methods: {
        getAlunos: function(){
            //getAllAlunos
            return this.alunos;
        }
    }

})

function cadastra_aluno(matricula,nome,grade,senha,email){
    aluno = {};
    aluno.matricula = matricula;
    aluno.nome = nome;
    aluno.grade = grade;
    aluno.senha = "";
    aluno.email = email;
    postAluno(aluno);
}

function postAluno(aluno){
    fetch('http://localhost:8088/aluno/', {
        headers: {
              'Content-Type': 'application/json'
        },
        method: "POST", body: JSON.stringify(aluno)})
        .then(response => response.json());
}

function pega_aluno(email){
    existe = existe_aluno(email);
    if(existe){
        return  alunos.getAlunos().filter(e => e.email == email)[0];
    }
}

function existe_aluno(email){
    element = alunos.getAlunos().filter(e => e.email == email);
    if(element.length == 0){
        return false;
    }
    return true;
}

function getAluno(){
    fetch('http://localhost:8088/aluno/')
    .then(response => response.json())
     .then(function(promise){
        alunos.alunos = promise;
     })
}


function nomeGoogle(googleuser){
    return googleUser.getBasicProfile().getName();
}

function emailGoogle(googleuser){
    return googleUser.getBasicProfile().getEmail();
}
