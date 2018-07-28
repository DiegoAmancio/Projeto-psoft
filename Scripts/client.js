import GoogleAuth from 'vue-google-auth';
import Vue from 'vue';


Vue.use(GoogleAuth, { clientID: '415663373552-3foebghlgeuglmmaan8p0j0id0oi6vlq.apps.googleusercontent.com' });
Vue.googleAuth().load();


Vue.googleAuth().onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
};

Vue.googleAuth().signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
};

new Vue({
    el: '#usuario',
    data: {
        tipo: ""
    },
})

new Vue({
    el: '#cadastro_disc',
    data: {
        nome: "",
        codigo: "",
        creditos: 0,
        carga: 0,
        grade: ""
    }
})

disc = new Vue({
    el: 'disciplinas',
    data:{
        disciplinas:[]
    }
})

function cadastra_disciplina(nome, codigo, credito, carga, grade){

    console.log("Cadastrado");
}

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
    disciplina.credito = credito;
    disciplina.carga = carga;
    disciplina.grade = grade;
}

function atualizacarga(){
    creditos = document.getElementById('creditos').value;
    carga = creditos*15;
    document.getElementById('carga').value = carga;
}

function valida_cadastro_disciplina(){

    nome = document.getElementById('nome').value;
    codigo = document.getElementById('codigo').value;
    creditos = document.getElementById('creditos').value;
    carga = document.getElementById('carga').value;
    grade =  document.querySelector('input[name=grade]:checked').value;
    atualizar = existe_nome_disc(nome, grade) || existe_codigo_disc(codigo, grade);
    if(atualizar){
        alert("Nome da disciplina ou código ja existe nessa grade, deseja atualizar?");
        yesno = true;
        //yesno = yes/no
        if(yesno){
            valido = true;
        }        
        else{
            valido = false;
        }
    }    
    if(valido){
        cadastra_disciplina(nome, codigo, credito, carga, grade);
        alert('Disciplina cadastrada');

    }
    else{
        alert('Disciplina não cadastrada');
    }
}

function valida_login(){
    email = document.getElementById('email').value;
    tipo = document.getElementsByName('tipo')[0].value;
    split = email.split('@');
    tamanho = split.length;
    nome = split[0];
    site = split[1];
    if(tamanho == 2 && site == 'ccc.ufcg.edu.br'){
        //Valida
        alert(tipo);
    }
    else{
        alert('Login invalido');
    }
}

console.log("Teste");
