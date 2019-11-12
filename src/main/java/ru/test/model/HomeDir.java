package ru.test.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HomeDir {
    private Path homePath;
    private Path storePath;

    public HomeDir(String homePathStr, String storePathStr) {
        this.homePath = Paths.get(homePathStr);
        this.storePath = Paths.get(storePathStr);
    }

    public Path getHomePath() {
        return homePath;
    }

    public void setHomePath(Path homePath) {
        this.homePath = homePath;
    }

    public Path getStorePath() {
        return storePath;
    }

    public void setStorePath(Path storePath) {
        this.storePath = storePath;
    }

    @Override
    public String toString() {
        return "HomeDir{" +
                "homePath=" + homePath +
                ", storePath=" + storePath +
                '}';
    }
}
