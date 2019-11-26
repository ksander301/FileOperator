<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Available files for download:</title>
</head>
<body>

<h2>Available files for download</h2>
<a href="${pageContext.request.contextPath}/index">Home Page</a>
<br>
<div align="left">
    <table border="0">
        <tr>
            <th>File URL</th>
        </tr>
        <c:forEach items="${files}" var="file" varStatus="i">
            <tr>
                <td><a href="${pageContext.request.contextPath}${path}${file}">${file}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
