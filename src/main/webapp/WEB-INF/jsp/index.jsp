<%@ page import="java.util.Enumeration" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Welcome</title>

</head>
<body>
<h1>File Operator Start Page</h1>
<b>${message}</b>
<br>
<br>
<table>
    <tr>
        <td><a href="${pageContext.request.contextPath}/fileList">Download</a>
        <td>
        <td><a href="${pageContext.request.contextPath}/fileUpload">Upload</a>
        <td>
    </tr>
</table>
</body>

</html>