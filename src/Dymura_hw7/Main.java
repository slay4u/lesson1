package Dymura_hw7;

import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("src/Dymura_hw7/files");
        Path path1 = Paths.get("src/Dymura_hw7/file");
        FileData file1 = new FileData("111.txt", (byte) 105, path);
        FileData file2 = new FileData("222.txt", (byte) 100, path);
        FileData file3 = new FileData("333.txt", (byte) 95, path);
        FileData file4 = new FileData("444.txt", (byte) 90, path1);
        FileData file5 = new FileData("555.txt", (byte) 85, path1);
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(path, file1);
        fileNavigator.add(path, file2);
        fileNavigator.add(path, file3);
        fileNavigator.add(path1, file4);
        fileNavigator.add(path1, file5);

        System.out.println(fileNavigator.find(path));
        System.out.println(fileNavigator.find(path1));
        System.out.println(fileNavigator.filterBySize((byte) 96));
        System.out.println(fileNavigator.sortBySize());
        System.out.println(fileNavigator.remove(path1));
        System.out.println(fileNavigator.find(path1));
    }
}
