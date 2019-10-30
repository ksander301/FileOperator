package ru.test.logic;

import java.util.List;

public interface HomeDirService {
    List<String> getHomeDirContent();

    List<String> getFileContent(String inputName);
}
