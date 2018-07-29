function OpenWindow() {


    var choice = document.getElementById("form");
    choice = choice.comando.value;

    if (choice == 'AlunoLogin') {
        window.open('/Aluno');
    }
    else if (choice == 'CoordenacaoLogin') {
        window.open('/Coordenador');
    }
}

function bindHelpTrigger(triggerId, helpFile, visivel) {
    var trigger = $('#' + triggerId);
    var referencePoint;

    if (trigger.parent().is("body")) {
        referencePoint = trigger;
    }
    else {
        referencePoint = trigger.parent();
    }

    trigger.click(function () {
        if (!$("#helpContainer").is("div")) {
            referencePoint.after("<div id='helpContainer'></div>");
            $("#helpContainer")
                .hide()
                .load("ajuda/" + helpFile + ".jsp")
                .addClass("alert alert-info")
                .toggle();
        }
        else {
            $("#helpContainer").toggle();
        }
    });

    if (visivel) {
        trigger.click();
    }
}

function sessionKeeper(selectors, tMinutes) {
    var interagiu = false;
    $(document).on(
        "click change keydown",
        selectors,
        function () {
            interagiu = true;
        }
    );

    setInterval(function () {
        if (interagiu) {
            $.get("Controlador?command=Ping&p=" + (new Date()).getTime());
            interagiu = false;
        }
    }, Math.round(tMinutes * 60 * 1000));
}