package ru.test.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HomeDir {
    private Path path;

    public HomeDir(String pathString) {
        this.path = Paths.get(pathString);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "HomeDir{" +
                "path=" + path +
                '}';
    }
}
