package ru.test.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface HomeDirService {
    List<String> getHomeDirContent();

    List<String> getFileContent(String fileName);
    File getFile(String fileName) throws FileNotFoundException;
}
