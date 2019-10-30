package ru.test.controller;

import java.util.List;

public interface HomeDirRest {
    List<String> getHomeDirContent();

    List<String> getFileContent(String fileName);
}
