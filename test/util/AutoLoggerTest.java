package util;

import util.loggers.AbstractLogger;
import util.loggers.AutoLogger;

import java.text.SimpleDateFormat;

public class AutoLoggerTest {

    public static void main(String[] args) {
        AbstractLogger logger = new AutoLogger("Source", new SimpleDateFormat("HH:mm:ss"));

    }

}
