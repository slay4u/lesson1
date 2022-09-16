package Dymura_hw6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static Dymura_hw6.FileLoggerConfiguration.dateTimeFormatter;

public class FileLogger {
    protected OutputStream outputStream;
    protected String fileName;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        try {
            outputStream = new FileOutputStream(FileLoggerConfiguration.file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void debug(String message) {
        if (FileLoggerConfiguration.loggingLevel.equals(LoggingLevel.DEBUG)) {
            String logging = FileLoggerConfiguration.format(message, LoggingLevel.DEBUG);
            writeFileLog(logging);
        }
    }

    public void info(String message) {
        if (FileLoggerConfiguration.loggingLevel.equals(LoggingLevel.DEBUG) ||
        FileLoggerConfiguration.loggingLevel.equals(LoggingLevel.INFO)) {
            String logging = FileLoggerConfiguration.format(message, LoggingLevel.INFO);
            writeFileLog(logging);
        }
    }

    public void writeFileLog(String aboutLog) {
        try {
            if (FileLoggerConfiguration.file.length() >= FileLoggerConfiguration.maxSize) {
//                File f = new File("src/Dymura_hw6/" + fileName);
//                fileName = LocalDateTime.now().format(dateTimeFormatter) + ".txt";
//                if (f.createNewFile()) {
//                    System.out.println("File was created.");
//                }
                throw new FileMaxSizeReachedException("MaxFileSize: " + FileLoggerConfiguration.maxSize +
                        "\tCurrentFileSize: " + FileLoggerConfiguration.file.length() + "\tFilePath: " +
                        FileLoggerConfiguration.file);
            } else {
                outputStream.write(aboutLog.getBytes(StandardCharsets.UTF_8));
                outputStream.write("\n".getBytes());
            }
        } catch (IOException | FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
    }
}
