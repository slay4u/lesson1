package Dymura_hw6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(LoggingLevel.DEBUG, (byte) 125,
                "log.txt");
        FileLogger fileLogger = new FileLogger(fileLoggerConfiguration);
        fileLogger.debug("Debug comment.");
        fileLogger.info("Info comment.");
        FileLoggerConfigurationLoader file = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration file1 = file.load("src/Dymura_hw6/cfg.txt");
        FileLogger file2 = new FileLogger(file1);
        file2.info("Test");
    }
}
