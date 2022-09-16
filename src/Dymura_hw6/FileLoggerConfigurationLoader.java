package Dymura_hw6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    protected byte maxFileSize;
    protected LoggingLevel currentLevel;
    protected String newFile;
    protected String format;

    public FileLoggerConfiguration load(String configFile) {
        try (FileReader fr = new FileReader(configFile);
             BufferedReader br = new BufferedReader(fr)) {
            String str;
            while ((str = br.readLine()) != null) {
                if (str.contains("FILE")) {
                    newFile = str.split(":")[1];
                } else if (str.contains("LEVEL")) {
                    String lvl = str.split(":")[1];
                    currentLevel = LoggingLevel.valueOf(lvl);
                } else if (str.contains("MAX-SIZE")) {
                    String size = str.split(":")[1];
                    maxFileSize = Byte.parseByte(size);
                } else if (str.contains("FORMAT")) {
                    format = str.split(":")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileLoggerConfiguration(currentLevel, maxFileSize, newFile, format);
    }
}
