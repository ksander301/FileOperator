package ru.test.dao;


import ru.test.model.HomeDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HomeDirDAO {
    List<String> getHomeDirContent() throws IOException;

    File getFile (String fileName) throws FileNotFoundException;
}
