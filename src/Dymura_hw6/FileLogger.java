package Dymura_hw6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private OutputStream outputStream;
    private File file1;
    private final FileLoggerConfiguration fileLoggerConfiguration;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy-hh.mm.ss");
    private LocalDateTime localDateTime;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
    }

    public void debug(String message) {
        if (fileLoggerConfiguration.getLoggingLevel().equals(LoggingLevel.DEBUG)) {
            try {
                outputStream = new FileOutputStream(fileLoggerConfiguration.getFile(), true);
                String logging = FileLoggerConfiguration.format(message, LoggingLevel.DEBUG);
                writeFileLog(logging);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void info(String message) {
        if (fileLoggerConfiguration.getLoggingLevel().equals(LoggingLevel.DEBUG) ||
        fileLoggerConfiguration.getLoggingLevel().equals(LoggingLevel.INFO)) {
            try {
                outputStream = new FileOutputStream(fileLoggerConfiguration.getFile(), true);
                String logging = FileLoggerConfiguration.format(message, LoggingLevel.INFO);
                writeFileLog(logging);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFileLog(String aboutLog) {
        if (fileLoggerConfiguration.getFile().length() >= fileLoggerConfiguration.getMaxSize()) {
            file1 = create(fileLoggerConfiguration);
            try {
                outputStream = new FileOutputStream(file1, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            outputStream.write(aboutLog.getBytes(StandardCharsets.UTF_8));
            outputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File create(FileLoggerConfiguration config) {
        String fileName = "Log-" + LocalDateTime.now().format(dateTimeFormatter) + ".txt";
        File file = new File("src/Dymura_hw6/" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
