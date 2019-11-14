package ru.test.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.test.controller.exception.FileStoreException;
import ru.test.dao.HomeDirDAO;
import ru.test.model.HomeDir;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class HomeDirDAOImpl implements HomeDirDAO {

    @Value("${file.homedir.homepath}")
    private String homePathStr;

    @Value("${file.homedir.storepath}")
    private String storePathStr;

    private HomeDir homeDir;

    @PostConstruct
    public void initHomeDir() {
        this.homeDir = new HomeDir(this.homePathStr, this.storePathStr);
    }

    @Override
    public List<String> getHomeDirContent() throws IOException {
        List<String> resultList;
        if (Files.exists(this.homeDir.getHomePath()) && Files.isDirectory(this.homeDir.getHomePath())) {
            try (Stream<Path> walk = Files.walk(this.homeDir.getHomePath())) {
                resultList = walk.filter(Files::isRegularFile)
                        .map(x -> x.getFileName().toString())
                        .collect(Collectors.toList());
            } catch (IOException e) { //TODO Remove Try Catch, method throws IOExcpeption at all
                e.printStackTrace();
                throw new IOException("IO Error by reading home directory:" + this.homePathStr);
            }
            return resultList;
        } else
            throw new NotDirectoryException("Path Value of property is not a valid irectory: " + this.homePathStr);
    }


    @Override
    public File getFile(String fileName) throws FileNotFoundException {
        File file = new File(this.homeDir.getHomePath().toString().concat('\\' + fileName));
        if (file.exists())
            return file;
        else
            throw new FileNotFoundException("Not found file by path:" + file.getPath());

    }

    @Override
    public String storeFile(MultipartFile file) throws FileStoreException {
        try {
            Path fileUploadPath = this.homeDir.getStorePath().toAbsolutePath().normalize();
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path targetLocation = fileUploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStoreException("ERROR during store file with DAO!");
        }

    }
}
