package Dymura_hw7;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private final Map<Path, List<FileData>> mapList = new HashMap<>();

    void add(Path path, FileData fileData) {
        try {
            if (path.equals(fileData.getPath())) {
                if (!mapList.containsKey(path)) {
                    mapList.put(path, new ArrayList<>());
                }
                mapList.get(path).add(fileData);
            } else throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    List<FileData> find(Path path) {
        return mapList.get(path);
    }

    List<FileData> filterBySize(Byte size) {
        return mapList.values()
                .stream()
                .flatMap(List::stream)
                .filter(f -> f.getSize() < size)
                .collect(Collectors.toList());
    }

    List<FileData> remove(Path path) {
        return mapList.remove(path);
    }

    List<FileData> sortBySize() {
        return mapList.values()
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(FileData::getSize))
                .collect(Collectors.toList());
    }
}
