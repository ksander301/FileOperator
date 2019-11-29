<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Upload Summary</title>
    <link href="css/style.css"
          rel="stylesheet">
</head>
<body>
<h2> Upload Summary</h2>
<p> Files has been upload successfuly...</p>
<table class="tabResult">
    <tr>
        <th>Name</th>
        <th>FileURL</th>
        <th>Type</th>
        <th>Size</th>
    </tr>
    <c:forEach items="${updList}" var="updateResponse">
        <tr>
            <td>${updateResponse.fileName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/files/get/${updateResponse.fileName}">${updateResponse.fileName}</a>
            </td>
            <td>${updateResponse.fileType}</td>
            <td>${updateResponse.fileSize}</td>
        </tr>
    </c:forEach>
</table>
<br>
<table>
    <tr>
        <td><a href="${pageContext.request.contextPath}/index">Start Page</a></td>
        <td><a href="${pageContext.request.contextPath}/fileList">Download</a>
        <td>
        <td><a href="${pageContext.request.contextPath}/fileUpload">Upload</a>
        <td>
    </tr>
</table>


</body>
</html>
