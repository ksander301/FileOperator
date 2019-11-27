<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Files</title>
</head>
<body>
<h2> Upload file to server</h2>
<a href="${pageContext.request.contextPath}/index">Home Page</a>
<br>
<form enctype="multipart/form-data" action="/resultUpload" method="post">
    <p>Select your file</p>

    <div>
        <input type="file" name="files" size="400" value="fileupload" id="fileupload" accept="*/*" multiple="true">
        <input type="submit" value="Upload" id="Upload">
    </div>

    <div class="preview">
        <p>No files currently selected for upload...</p>
    </div>
</form>

<script>

    var input = document.querySelector('input');
    var preview = document.querySelector('.preview');
    input.style.opacity = 1;
    input.addEventListener('change', this.updateItemList);

    function updateItemList() {
        while (preview.firstChild) {
            preview.removeChild(preview.firstChild);
        }
        var curFiles = input.files;
        if (curFiles.length == 0) {
            var pInfo = document.createElement('p')
            pInfo.textContent = 'No file selected';
            preview.appendChild(pInfo);
        } else {
            var list = document.createElement('ol');
            preview.appendChild(list);
            for (var i = 0; i < curFiles.length; i++) {
                var listItem = document.createElement('li');
                var pItem = document.createElement('p');
                pItem.textContent = 'File name: ' + curFiles[i].name + '\tSize: ' + getFileSize(curFiles.item(i).size);
                listItem.appendChild(pItem);
                list.appendChild(listItem);
            }
        }
    }

    function getFileSize(number) {
        if (number < 1024) {
            return number + 'bytes';
        } else if (number > 1024 && number < 1048576) {
            return (number / 1024).toFixed(1) + 'KB';
        } else if (number > 1048576) {
            return (number / 1048576).toFixed(1) + 'MB';
        }
    }

</script>
</body>
</html>
