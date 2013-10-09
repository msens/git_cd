<%--
  Created by IntelliJ IDEA.
  User: michielsens
  Date: 09/10/2013
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<sql:query var="rs" dataSource="jdbc/MySQLTest">
    select kolom1, kolom2 from test.test
</sql:query>


<html>
<head>
    <title>DB Test</title>
</head>


<body>

<h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">

    <c:out value="${row.kolom1}"/>
    <c:out value="${row.kolom2}"/>


</c:forEach>

</body>
</html>
