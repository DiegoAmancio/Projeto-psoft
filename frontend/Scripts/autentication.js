var alunos = [];
fetch('https://backend-matricula.herokuapp.com/alunos/').then(response => response.json()).then(promise => alunos = promise);

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    }).catch(response => alert(response));
}
function onLoad() {
    gapi.load('auth2', function() {
        gapi.auth2.init().then(() => verifica_login(window.location.href));
    });
}

function verifica_login(url){
    if(url.includes("/Coordenador")){
        verifica_login_coordenador();
    }
    else if(url.includes("/Aluno")){
        if(url.includes("/Aluno/matricula_cadastro.html")){
            verifica_login_aluno(false);
        }
        else{
            verifica_login_aluno(true);
        }
    }
}


function verifica_login_aluno(precisa_cadastro){
    var user = gapi.auth2.getAuthInstance().currentUser.Ab.w3;
    if(user == undefined){
        window.location = '/';
    }
    email = user.U3;
    nome = user.ig;
    tem = temAluno(email);
    if(!email.includes("@ccc.ufcg.edu.br")){
        window.location = '/'; 
    }
    else if(precisa_cadastro && !tem && !(email == "projsw@ccc.ufcg.edu.br")){
        window.location = "/Aluno/matricula_cadastro.html"
    }
    else if(!precisa_cadastro && tem && !(email == "projsw@ccc.ufcg.edu.br")){
        window.location = "/Aluno"
    }
    else if(email == "projsw@ccc.ufcg.edu.br"){
        window.location = "/Coordenador"
    }
}

function verifica_login_coordenador(){
    var user = gapi.auth2.getAuthInstance().currentUser.Ab.w3;
    if(user == undefined){
        window.location = '/';
    }
    email = user.U3;
    if(email != "projsw@ccc.ufcg.edu.br"){
        window.location = "/"
    }
}

function temAluno(email){
    possui = alunos.filter(e => e.email == email);
    if(possui.length == 0){
        return false;
    }
    return true;
}