package Dymura_hw7;

import java.nio.file.Path;

public class FileData {
    private final String name;
    private final Byte size;
    private final Path path;

    public FileData(String name, Byte size, Path path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public Byte getSize() {
        return size;
    }

    public Path getPath() {
        return path;
    }

    @Override
    public String toString() {
        return '(' +
                "name = '" + name + '\'' +
                ", size = " + size +
                " Bytes, path = '" + path +
                '\'' + ')';
    }
}
