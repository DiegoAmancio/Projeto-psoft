var alunos = [];
fetch('https://backend-matricula.herokuapp.com/alunos/').then(response => response.json()).then(promise => alunos = promise);
function onSuccess(googleUser) {
    email = googleUser.getBasicProfile().getEmail();
    possui = temAluno(email);
    if (email.includes('@ccc.ufcg.edu.br')) {
        if (email.includes('projsw')) {
            window.location = '/Coordenador'; 
        } else if(possui){
            window.location = '/Aluno';
        }
        else{
            window.location = '/Aluno/matricula_cadastro.html'
        }
    } else {
        onFailure('Conta Invalida');
    }
}
function onFailure(error) {
    alert(error);
}
function renderButton() {
    gapi.signin2.render('my-signin2', {
        'scope': 'profile email',
        'width': 230,
        'height': 40,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
    });
}
function temAluno(email){
    possui = alunos.filter(e => e.email == email);
    if(possui.length == 0){
        return false;
    }
    return true;
}