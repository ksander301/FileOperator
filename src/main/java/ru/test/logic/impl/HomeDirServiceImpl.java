package ru.test.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.dao.HomeDirDAO;
import ru.test.logic.HomeDirService;
import java.util.List;

@Service
public class HomeDirServiceImpl implements HomeDirService {

    @Autowired
    public HomeDirDAO homeDirDAO;

    @Override
    public List<String> getHomeDirContent() {
        return this.homeDirDAO.getHomeDirContent();

    }

    @Override
    public List<String> getFileContent(String fileName) {
        return this.homeDirDAO.getFileContent(fileName);
    }
}
