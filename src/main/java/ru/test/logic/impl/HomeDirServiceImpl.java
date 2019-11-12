package ru.test.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.test.controller.entity.UploadFileResponse;
import ru.test.dao.HomeDirDAO;
import ru.test.logic.HomeDirService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class HomeDirServiceImpl implements HomeDirService {

    @Autowired
    public HomeDirDAO homeDirDAO;

    @Override
    public List<String> getHomeDirContent() throws IOException {
        return this.homeDirDAO.getHomeDirContent();

    }

    @Override
    public File getFile(String fileName) throws FileNotFoundException {
        return this.homeDirDAO.getFile(fileName);
    }

    @Override
    public UploadFileResponse storeFile( MultipartFile file) throws IOException {
        String fileName=this.homeDirDAO.storeFile(file);

        if (!fileName.equals("") || !fileName.equals(null)) {
            String fileURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/files/get/")
                    .path(fileName)
                    .toUriString();
            System.out.println("Service call is OK");
            return new UploadFileResponse(fileName,fileURI,file.getContentType(),file.getSize());
        }
            else
                throw new IOException("IO Exception from Service!"); //TODO Change descrption or Create UploadException
    }
}
