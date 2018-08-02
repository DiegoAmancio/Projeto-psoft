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