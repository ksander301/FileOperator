package ru.test.dao;


import org.springframework.web.multipart.MultipartFile;
import ru.test.controller.exception.FileStoreException;
import ru.test.model.HomeDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HomeDirDAO {
    List<String> getHomeDirContent() throws IOException;

    File getFile (String fileName) throws FileNotFoundException;
    String storeFile (MultipartFile multipartFile) throws FileStoreException;
}
