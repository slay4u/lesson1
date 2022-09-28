package Dymura_hw6;

import java.io.IOException;

public interface LogWriter {
    void debug(String message) throws IOException;

    void info(String message) throws IOException;
}
