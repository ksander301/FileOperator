package ru.test.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.controller.HomeDirRest;
import ru.test.logic.HomeDirService;
import java.util.List;


@RestController
@RequestMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeDirRestImpl implements HomeDirRest{

    @Autowired
    public HomeDirService homeDirService;

    @Override
    public List<String> getHomeDirContent() {
        return null;
    }

    @Override
    public List<String> getFileContent(String fileName) {
        return null;
    }
}
