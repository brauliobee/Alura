<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><body>
Resultado da busca:<br/>
<ul>
<c:forEach var="empresa" items="${empresas }">
    <li>${empresa.id }: ${empresa.nome }</li>
</c:forEach>
</ul>
<br/><br/>

<form action="/gerenciador" method="post">
    <input type="submit" value="Voltar" />
</form>
</body></html>