package ru.test.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
