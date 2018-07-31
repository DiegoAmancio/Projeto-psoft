Vue.component('my-top', {
    template: `    
    <div class="container panel panel-primary text-center" id="header" role="banner">
        <div class="row">
            <div class="col-sm-2 col-xs-3">
                <img class="brasao" src="/Imagens/ufcg.png" alt="Universidade Federal de Campina Grande">
            </div>
            <div class="col-sm-8 col-xs-8">
                <h1>
                    <a href="/">Sistema de Pré-Matricula Online</a>
                </h1>
            </div>
        </div>
    </div>
    `
});

Vue.component('my-navbar-aluno', {
    template:     
   `<div class="container panel panel-primary hidden-print" id="menu" role="navigation">
    <ul class="nav nav-pills">
        <li><a href="/Aluno"><span class="glyphicon glyphicon-home"></span><span class="sr-only">Página Inicial</span></a></li>
        <li class="dropdown">
        <a id="alunoMatriculas" role="button" data-toggle="dropdown" href="#">Pré-Matrículas<b class="caret"></b></a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="alunoMatriculas">
            <li role="presentation">
            <a role="menuitem" tabindex="-1" href="/Aluno/Cadastro/">Realizar Pré-Matricula</a>
            </li>
            <li role="presentation">
            <a role="menuitem" tabindex="-1" href="/Aluno/Disciplinas/">Turmas ofertadas</a>
            </li>
        </ul>
        </li>
        <li class="dropdown">
        <a id="alunoUsuario" role="button" data-toggle="dropdown" href="#">Usuário<b class="caret"></b></a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="alunoUsuario">
            <li role="presentation">
                <a role="menuitem" tabindex="-1" href="https://myaccount.google.com/u/1/signinoptions/password">Alterar senha</a>
            </li>
        </ul>
        </li>
        <li>
        <a onclick="signOut();" href= "/" >Sair</a>
        </li>
    </ul>
    </div>`
});

Vue.component('my-navbar-coordenador', {
    template:
    `<div class="container panel panel-primary hidden-print" id="menu" role="navigation">
    <ul class="nav nav-pills">
        <li><a href="/Coordenador/"><span class="glyphicon glyphicon-home"></span><span class="sr-only">Página Inicial</span></a></li>
        <li class="dropdown">
            <a id="coordMatriculas" role="button" data-toggle="dropdown" href="#">Pré-Matrículas<b class="caret"></b></a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="coordMatriculas">
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="/Coordenador/Cadastro/">Cadastro de Disciplina</a>
                </li>
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="/Coordenador/Turmas/">Listagem de Pré-Matriculas</a>
                </li>
                <li role="presentation">
                        <a role="menuitem" tabindex="-1" href="/Coordenador/Disciplinas/">Disciplinas ofertadas</a>
                    </li>
            </ul>
        </li>
        <li class="dropdown">
            <a id="usuario" role="button" data-toggle="dropdown" href="#">Usuário<b class="caret"></b></a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="usuario">
                <li role="presentation">
                    <a role="menuitem" tabindex="-1" href="https://myaccount.google.com/u/1/signinoptions/password">Alterar senha</a>
                </li>
            </ul>
        </li>
        <li><a onclick="signOut();" href='/'>Sair</a></li>
    </ul>
    </div>`

});

new Vue({
    el: '#app'
});