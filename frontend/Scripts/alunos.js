
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
            x = this.matricula.substring(1,4);
            this.periodo = x[0] + x[1] + "." + x[3];
        },
        validaCadastro: function(){
            if(this.grade == "" || this.matricula == ""){
                alert("Cadastro não concluido");
            }
            else{
                cadastraAluno(this.grade, this.matricula);
                this.cadastrado = true;
                alert("Cadastro concluido");
            }
        },
        alunoCadastrado: function(){
            return cadastrado;
        }
    }
})

new Vue({
    el: '#alunos',
    data:{
        alunos: []
    },
    methods: {
        getAlunos: function(){
            //getAllAlunos
            return this.alunos;
        }
    }

})

function cadastraAluno(grade, matricula){
    aluno = {};
    aluno.grade = grade;
    aluno.matricula = matricula;
    var user = gapi.auth2.getAuthInstance().currentUser.Ab.w3;
    email = user.U3;
    nome = user.ig;
}