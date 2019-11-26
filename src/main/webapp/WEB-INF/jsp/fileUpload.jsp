<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Files</title>
</head>
<body>
<h2> Upload file to server</h2>
<a href="${pageContext.request.contextPath}/index">Home Page</a>
<br>
<form enctype="multipart/form-data" method="post">
    <p>Select your file</p>

    <div>
        <input type="file" name="file" size="400" value="fileupload" id="fileupload" accept="*/*">
        <input type="submit" value="Upload" id="Upload">
    </div>

    <div class="preview">
        <p>No files currently selected for upload</p>
    </div>
</form>

<script>

    var input = document.querySelector('input');
    var preview = document.querySelector('.preview');
    input.style.opacity = 1;
    input.addEventListener('change', updateItemList);

    function updateItemList() {
        while (preview.firstChild) {
            preview.removeChild(preview.firstChild);
        }
        var curFiles = input.files;
        if (curFiles.length == 0) {
            var pInfo= document.createElement('p')
            pInfo.textContent="No file selected"
            preview.appendChild(pInfo)
            alert("What the fuck!")
        } else {
            alert("Not WTF!")
        }
    }

</script>
</body>
</html>
