package ru.test.logic;

import org.springframework.web.multipart.MultipartFile;
import ru.test.controller.entity.UploadFileResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HomeDirService {
    List<String> getHomeDirContent() throws IOException;

    File getFile(String fileName) throws FileNotFoundException;
    UploadFileResponse storeFile (MultipartFile file) throws IOException;
    List<UploadFileResponse> storeMultiFiles(MultipartFile[] files) throws RuntimeException;

}
