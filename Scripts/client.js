new Vue({
    el: '#usuario',
    data: {
        message: "",
        senha: "",
        tipo: ""
    },
})

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