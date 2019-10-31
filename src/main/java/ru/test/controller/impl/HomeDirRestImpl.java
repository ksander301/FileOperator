package ru.test.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.controller.HomeDirRest;
import ru.test.logic.HomeDirService;
import java.util.List;


@RestController
@RequestMapping(value = "/files")
public class HomeDirRestImpl implements HomeDirRest{

    @Autowired
    public HomeDirService homeDirService;

    @Override
    @RequestMapping(value = "/Directory", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getHomeDirContent() {
        return this.homeDirService.getHomeDirContent();
    }
//headers = {"content-type=text/plain"}
    @Override
    @RequestMapping(value = "/get" , produces={MediaType.TEXT_PLAIN_VALUE})
    public List<String> getFileContent(@RequestParam("fileName") String fileName) {
        return this.homeDirService.getFileContent(fileName);
    }
}
