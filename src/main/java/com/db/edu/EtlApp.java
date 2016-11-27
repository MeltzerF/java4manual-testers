package com.db.edu;

import com.db.edu.etl.RecordType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.db.edu.etl.Controller.extract;
import static com.db.edu.etl.Controller.load;
import static com.db.edu.etl.Controller.transform;

public class EtlApp {
    private static final Logger logger = LoggerFactory.getLogger(EtlApp.class);
    private EtlApp() {}
    public static String[] extractResult;
    public static String[] transformResult;

    public static void main(String... args) {
        logger.debug("Entering main method with args {}", args);
        for(RecordType currentType : RecordType.values()) {
//            extractResult = extract(currentType);
//            transformResult = transform(currentType, extractResult);
//            load(transformResult);
        }

        byte overflowVar = 0;
        for (int counter = 0; counter < 129; counter++) {
            overflowVar++;
        }
        System.out.println(overflowVar);
    }
}
