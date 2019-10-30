package ru.test.dao;


import ru.test.model.HomeDir;

import java.util.List;

public interface HomeDirDAO {
    List<String> getHomeDirContent();

    List<String> getFileContent(String inputName);
}
