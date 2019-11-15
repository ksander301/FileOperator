package ru.test.controller;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import ru.test.model.entity.UploadFileResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HomeDirRest {
    List<String> getHomeDirContent() throws IOException;
    Resource getFileByName(String fileName, HttpServletResponse response) throws FileNotFoundException;
    UploadFileResponse storeFileNested (MultipartFile file) throws IOException, RuntimeException;
    List<UploadFileResponse> storeMultiFilesNested( MultipartFile[] files) throws RuntimeException;
}
