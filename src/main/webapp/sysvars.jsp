<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP Table of Environmental variables</title>
</head>
<body>
<jsp:useBean id="SEVBean" class="beans.SysEnvVarsBean"/>
<c:set var="vars" value="${SEVBean.vars}"/>
<style>
    table.data-table {
        border-collapse: collapse;
        border: 1px solid black;
    }

    .data-table td {
        text-align: left;
        border: 1px solid black;
    }

    .data-table th {
        text-align: center;
        border: 1px solid black;
    }
</style>
<table class="data-table">
    <tbody>
    <c:forEach items="${vars}" var="var">
        <tr>
            <td>${var.name}</td>
            <td>${var.value}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
