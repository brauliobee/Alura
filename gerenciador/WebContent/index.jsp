<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao meu gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
    Você está logado como ${usuarioLogado.email}<br/><br/>
</c:if>

<form action="executa?tarefa=NovaEmpresa" method="POST">
Nova empresa: <input type="text" name="empresa">
<input type="submit" value="Enviar">
</form>

<form action="executa?tarefa=Login" method="POST">
    Email: <input type="text" name="email" /><br/>
    Senha: <input type="password" name="senha" /><br/>
    <input type="submit" value="Login" />
</form>

<form action="executa?tarefa=BuscaEmpresa" method="post">
Buscar empresas cadastradas: <input type="submit" value="Buscar" />
</form>

<form action="executa?tarefa=Logout" method="post">
    <input type="submit" value="Logout" />
</form>
</body>
</html>