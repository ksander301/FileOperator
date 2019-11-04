package ru.test.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.test.controller.HomeDirRest;
import ru.test.logic.HomeDirService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


@RestController
@RequestMapping(value = "/files")
public class HomeDirRestImpl implements HomeDirRest {

    @Autowired
    public HomeDirService homeDirService;

    @Override
    @RequestMapping(value = "/directory", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getHomeDirContent() {
        return this.homeDirService.getHomeDirContent();
    }

    @Override
    @RequestMapping(value = "/get", headers = "content-type=text/plain")
    public @ResponseBody List<String> getFileContent(@RequestParam("fileName") String fileName) {

        return this.homeDirService.getFileContent(fileName);
    }

    @Override
    @RequestMapping(value="/get/{filename:.+}",method = RequestMethod.GET , produces = "text/plain")
    public Resource getFileByName(@PathVariable String filename, HttpServletResponse response) throws FileNotFoundException {
        File file= this.homeDirService.getFile(filename);
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        Resource resource = new FileSystemResource(file);
        return resource;
    }
}
