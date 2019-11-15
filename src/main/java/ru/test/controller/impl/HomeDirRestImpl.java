package ru.test.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.test.controller.HomeDirRest;
import ru.test.model.entity.UploadFileResponse;
import ru.test.logic.HomeDirService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/files")
public class HomeDirRestImpl implements HomeDirRest {

    @Autowired
    public HomeDirService homeDirService;

    @Override
    @RequestMapping(value = "/directory", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getHomeDirContent() throws IOException {
        return this.homeDirService.getHomeDirContent();
    }

    @Override
    @RequestMapping(value = "/get/{filename:.+}", method = RequestMethod.GET, produces = "text/plain")
    public Resource getFileByName(@PathVariable String filename, HttpServletResponse response) throws FileNotFoundException {
        File file = this.homeDirService.getFile(filename);
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        return new FileSystemResource(file);

    }

    @Override
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public UploadFileResponse storeFileNested(@RequestParam("file") MultipartFile file) throws IOException, RuntimeException {
        System.out.println("Rest call is OK");
        if (file.equals(null) || file.getName().isEmpty())
            throw new RuntimeException("Request file param is empty. Nothing to store!");
        return this.homeDirService.storeFile(file);
    }

    @Override
    @RequestMapping(value = "/uploadMultiFiles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UploadFileResponse> storeMultiFilesNested(@RequestParam("files") MultipartFile[] files) throws RuntimeException {
        if (files.length == 0)
            throw new RuntimeException("Request files array is empty. Nothing to store!");
        return this.homeDirService.storeMultiFiles(files);
    }
}
