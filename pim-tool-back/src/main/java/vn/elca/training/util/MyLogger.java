package vn.elca.training.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
    private static MyLogger instance;
    private Logger logger;

    private static final String FILE_NAME = "application.log";

    private MyLogger() {
        logger = Logger.getLogger(MyLogger.class.getName());

        try {
            // Configure the FileHandler to write logs to a file named "application.log"
            FileHandler fileHandler = new FileHandler(FILE_NAME);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyLogger getInstance() {
        if (instance == null) {
            synchronized (MyLogger.class) {
                if (instance == null) {
                    instance = new MyLogger();
                }
            }
        }
        return instance;
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logWarning(String message) {
        logger.warning(message);
    }

    public void logError(String message) {
        logger.log(Level.SEVERE, message);
    }
}

