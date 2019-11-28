<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Download files</title>
</head>
<body>
<h2>Download files</h2>
<table>
    <tr>
        <td><a href="${pageContext.request.contextPath}/index">Start Page</a></td>
        <td><a href="${pageContext.request.contextPath}/fileUpload">Upload</a>
        <td>
    </tr>
</table>
<br>
<div align="left">
    <table border="0">
        <tr>
            <td><b>File URL</b></td>
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
