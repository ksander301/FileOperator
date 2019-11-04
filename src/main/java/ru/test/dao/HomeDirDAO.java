package ru.test.dao;


import ru.test.model.HomeDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface HomeDirDAO {
    List<String> getHomeDirContent();

    List<String> getFileContent(String fileName);

    File getFile (String fileName) throws FileNotFoundException;
}
