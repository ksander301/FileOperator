package ru.test.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.test.dao.HomeDirDAO;
import ru.test.model.HomeDir;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class HomeDirDAOImpl implements HomeDirDAO {

    @Value("${file.homedir.path}")
    private String pathString;

    private HomeDir homeDir;

    @PostConstruct
    public void initHomeDir() {
        this.homeDir = new HomeDir(this.pathString);
    }

    @Override
    public List<String> getHomeDirContent() throws IOException {
        List<String> resultList = null;
        if (Files.exists(this.homeDir.getPath()) && Files.isDirectory(this.homeDir.getPath())) {
            try (Stream<Path> walk = Files.walk(this.homeDir.getPath())) {
                resultList = walk.filter(Files::isRegularFile)
                        .map(x -> x.getFileName().toString())
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException("IO Error by reading home directory:" + this.pathString);
            }
            //resultList.forEach(System.out::println);
            return resultList;
        } else
            throw new NotDirectoryException("Path Value of property is not a valid irectory: " + this.pathString);
    }

    @Override
    public List<String> getFileContent(String fileName) {
        List<String> listLines = null;

        Path filePath = Paths.get(this.homeDir.getPath().toString().concat('\\' + fileName));
        Charset cs = Charset.forName("CP1251");

        try {
            listLines = Files.readAllLines(filePath, cs);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLines;
    }

    @Override
    public File getFile(String fileName) throws FileNotFoundException {
        File file = new File(this.homeDir.getPath().toString().concat('\\' + fileName));
        if (file.exists())
            return file;
        else
            throw new FileNotFoundException("Not found file by path:" + file.getPath());

    }
}
