$(document).ready(function(){

    $("#usuario").on('change', function(){
        tipo = document.getElementsByName('tipo')[0].value;
        if(tipo == 'aluno' || tipo == 'coord'){
            document.getElementById('salvar').removeAttribute('disabled');
        }
    })
})