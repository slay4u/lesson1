package Dymura_hw6;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLoggerConfiguration {
    private final File file;
    private final LoggingLevel loggingLevel;
    private final byte maxSize;
    private LocalDateTime localDateTime;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy hh:mm");

    public FileLoggerConfiguration(LoggingLevel loggingLevel, byte maxSize, String file1, String format) {
        this.file = new File("src/Dymura_hw6/" + file1);
        this.loggingLevel = loggingLevel;
        this.maxSize = maxSize;
        format = String.format("%s %s Message:", localDateTime, loggingLevel);
    }

    public FileLoggerConfiguration(LoggingLevel loggingLevel, byte maxSize, String file1) {
        this.file = new File("src/Dymura_hw6/" + file1);
        this.loggingLevel = loggingLevel;
        this.maxSize = maxSize;
    }

    public File getFile() {
        return file;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public byte getMaxSize() {
        return maxSize;
    }

    public static String format(String message, LoggingLevel loggingLevel){
        return LocalDateTime.now().format(dateTimeFormatter) + " " + loggingLevel +
                " Message: " + message;
    }
}
