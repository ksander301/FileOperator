package ru.test.controller;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface HomeDirRest {
    List<String> getHomeDirContent();

    List<String> getFileContent(String fileName);

    Resource getFileByName(String fileName, HttpServletResponse responce) throws FileNotFoundException;
}
