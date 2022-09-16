package Dymura_hw6;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration {
    protected static File file;
    protected static LoggingLevel loggingLevel;
    protected static byte maxSize;
    protected LocalDateTime localDateTime;
    protected static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy hh:mm");

    public FileLoggerConfiguration(LoggingLevel loggingLevel, byte maxSize, String file1, String format) {
        file = new File("src/Dymura_hw6/" + file1);
        FileLoggerConfiguration.loggingLevel = loggingLevel;
        FileLoggerConfiguration.maxSize = maxSize;
        format = String.format("%s %s Message:", localDateTime, loggingLevel);
    }

    public FileLoggerConfiguration(LoggingLevel loggingLevel, byte maxSize, String file1) {
        file = new File("src/Dymura_hw6/" + file1);
        FileLoggerConfiguration.loggingLevel = loggingLevel;
        FileLoggerConfiguration.maxSize = maxSize;
    }

    public FileLoggerConfiguration() {}

    public static String format(String message, LoggingLevel loggingLevel){
        return LocalDateTime.now().format(dateTimeFormatter) + " " + loggingLevel +
                " Message: " + message;
    }
}
