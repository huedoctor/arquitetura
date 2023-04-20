<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Aula de AS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/menu.css">
    </head>
    <body>
        <header>
            <h1>Senac</h1>
            <p style=" margin-right: 10px">${m} ${mc}</p>
        </header>
        <nav>
            <p>
            <div class="topnav" id="myTopnav">
                <a href="#home" class="active">Home</a>
                <div class="dropdown">
                    <button class="dropbtn">Departamento 
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="cadastroDepartamento.html" target="conteudo">Incluir</a>
                        <a href="alterarDepartamento.html" target="conteudo">Alterar</a>
                        <a href="excluirDepartamento.html" target="conteudo">Excluir</a>
                        <a href="consultarDepartamento.html" target="conteudo">Consultar</a>
                        <a href="Controle?flag=listarDepartamentos" target="conteudo">Relatorios</a>
                    </div>
                </div> 
                <div class="dropdown">
                    <button class="dropbtn">Funcionario 
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="cadastroFuncionario.html" target="conteudo">Incluir</a>
                        <a href="alterarFuncionario.html" target="conteudo">Alterar</a>
                        <a href="excluirFuncionario.html" target="conteudo">Excluir</a>
                        <a href="consultarFuncionario.html" target="conteudo">Consultar</a>
                        <a href="listarFuncionario.html" target="conteudo">Relatorios</a>
                    </div>
                </div> 
                <div class="dropdown">
                    <button class="dropbtn">Acesso 
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="cadastroAcesso.html" target="conteudo">Incluir</a>
                        <a href="alterarAcesso.html" target="conteudo">Alterar</a>
                        <a href="excluirAcesso.html" target="conteudo">Excluir</a>
                        <a href="consultarAcesso.html" target="conteudo">Consultar</a>
                        <a href="listarAcesso.html" target="conteudo">Relatorios</a>
                    </div>
                </div> 
                <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
            </div>
        </p>
    </nav>
    <main>
        <p>
            <iframe src="abertura.html" name="conteudo"></iframe>
        </p>
    </main>
    <footer>
        <p>
            FOOTER
        </p>
    </footer>

    <script src="script/menu.js"></script>
</body>
</html>
