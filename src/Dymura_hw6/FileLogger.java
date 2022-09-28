package Dymura_hw6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements LogWriter{
    private OutputStream outputStream;
    private final FileLoggerConfiguration fileLoggerConfiguration;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy-hh.mm.ss.SSS");

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
    }

    @Override
    public void debug(String message) throws IOException {
        if (fileLoggerConfiguration.getLoggingLevel().equals(LoggingLevel.DEBUG)) {
            outputStream = new FileOutputStream(fileLoggerConfiguration.getFile(), true);
            String logging = FileLoggerConfiguration.format(message, LoggingLevel.DEBUG);
            writeFileLog(logging);
            outputStream.close();
        }
    }

    @Override
    public void info(String message) throws IOException {
        if (fileLoggerConfiguration.getLoggingLevel().equals(LoggingLevel.DEBUG) ||
        fileLoggerConfiguration.getLoggingLevel().equals(LoggingLevel.INFO)) {
            outputStream = new FileOutputStream(fileLoggerConfiguration.getFile(), true);
            String logging = FileLoggerConfiguration.format(message, LoggingLevel.INFO);
            writeFileLog(logging);
            outputStream.close();
        }
    }

    public void writeFileLog(String aboutLog) throws IOException {
        if (fileLoggerConfiguration.getFile().length() >= fileLoggerConfiguration.getMaxSize()) {
            File file1 = create(fileLoggerConfiguration);
            outputStream = new FileOutputStream(file1, true);
        }
        outputStream.write(aboutLog.getBytes(StandardCharsets.UTF_8));
        outputStream.write("\n".getBytes());
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
