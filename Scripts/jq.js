$(document).ready(function(){

    $("#usuario").on('change', function(){
        tipo = document.querySelector('input[name=tipo]:checked').value;
        if(tipo == 'aluno' || tipo == 'coord'){
            document.getElementById('salvar').removeAttribute('disabled');
        }
    })

    $("#cadastro_disc").on('change', function(){
        grade = document.querySelector('input[name=grade]:checked').value;
        nome = document.getElementById('nome').value;
        codigo = document.getElementById('codigo').value;
        creditos = document.getElementById('creditos').value;
        carga = document.getElementById('carga').value;
        if(grade == "Antiga" || grade == "Nova" || grade == "Ambas" || nome == "" || codigo == "" || creditos == "" || carga == ""){
            document.getElementById('cadastrar_disc').removeAttribute('disabled');
        }
        else{
            document.getElementById('cadastrar_disc').removeAttribute('disabled');
        }
    })
})