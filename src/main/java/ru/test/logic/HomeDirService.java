package ru.test.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HomeDirService {
    List<String> getHomeDirContent() throws IOException;

    List<String> getFileContent(String fileName);
    File getFile(String fileName) throws FileNotFoundException;
}
