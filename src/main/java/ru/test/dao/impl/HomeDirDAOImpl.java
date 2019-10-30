package ru.test.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.test.dao.HomeDirDAO;
import ru.test.model.HomeDir;

import java.util.List;

@Repository
public class HomeDirDAOImpl implements HomeDirDAO {

    @Value("${file.homedir.path}")
    private String pathString;

    private HomeDir homeDir;

    public void postConstruct() {
        this.homeDir=new HomeDir(this.pathString);
    }

    @Override
    public List<String> getHomeDirContent() {
        return null;
    }

    @Override
    public List<String> getFileContent(String inputName) {
        return null;
    }
}
