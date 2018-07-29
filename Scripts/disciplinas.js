new Vue({
    el: '#cadastro_disc',
    data: {
        nome: "",
        codigo: "",
        creditos: 0,
        carga: 0,
        grade: ""
    },
    methods:{
        atualizacarga: function(){
            creditos = document.getElementById('creditos').value;
            carga = creditos*15;
            document.getElementById('carga').value = carga;
        }
    }
})

disc = new Vue({
    el: '#disciplinas',
    data:{
        disciplinas:[]
    },
    methods: {
        getDisc: function(){
            return disciplinas;
        }
    }
})

function existe_nome_disc(nome, grade){
    return false;
}

function existe_codigo_disc(codigo, grade){
    return false;
}

function cadastra_disciplina(nome, codigo, credito, carga, grade){
    disciplina = {};
    disciplina.nome = nome;
    disciplina.codigo = codigo;
    disciplina.creditos = credito;
    disciplina.carga = carga;
    disciplina.grade = grade;
    disc.disciplinas.push(disciplina);

}

function valida_cadastro_disciplina(){

    nome = document.getElementById('nome').value;
    codigo = document.getElementById('codigo').value;
    creditos = document.getElementById('creditos').value;
    carga = document.getElementById('carga').value;
    grade =  document.querySelector('input[name=grade]:checked').value;
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

cadastra_disciplina('EDA', '03-02', 4, 60, 'Ambas');
