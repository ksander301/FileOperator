package ru.test.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.test.controller.entity.UploadFileResponse;
import ru.test.controller.exception.FileStoreException;
import ru.test.dao.HomeDirDAO;
import ru.test.logic.HomeDirService;
import ru.test.logic.wrapif.FunctionWithException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class HomeDirServiceImpl implements HomeDirService {

    @Autowired
    public HomeDirDAO homeDirDAO;


    private <T, R, E extends Exception>
    Function<T, R> storeFileWrapper(FunctionWithException<T, R, E> fe) {
        return arg -> {
            try {
                return fe.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }


    @Override
    public List<String> getHomeDirContent() throws IOException {
        return this.homeDirDAO.getHomeDirContent();

    }

    @Override
    public File getFile(String fileName) throws FileNotFoundException {
        return this.homeDirDAO.getFile(fileName);
    }

    @Override
    public UploadFileResponse storeFile(MultipartFile file) throws FileStoreException {

        String fileName = this.homeDirDAO.storeFile(file);

        if (!fileName.equals("") || !fileName.equals(null)) {
            String fileURI = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/files/get/")
                    .path(fileName)
                    .toUriString();
            System.out.println("Service call  OK");
            return new UploadFileResponse(fileName, fileURI, file.getContentType(), file.getSize());
        } else
            throw new FileStoreException("IO Exception from Service!"); //TODO Change descrption or Create UploadException

    }

    @Override
    public List<UploadFileResponse> storeMultiFiles(MultipartFile[] files) throws RuntimeException {
        /*return Arrays.stream(files)
                .map(file -> {
                    try {                               // TODO Add Interface Wrapper for lambda exception
                        return this.storeFile(file);     // TODO Implementation are below....
                    } catch (IOException e) {
                        throw  new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());*/

        return Arrays.stream(files)
                .map(storeFileWrapper(file -> this.storeFile(file)))
                .collect(Collectors.toList());
    }
}
