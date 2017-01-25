package com.db.edu.etl;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.round;
import static java.lang.Math.subtractExact;


public class Controller {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Controller.class);

    public static DTO transform(RecordType recordType, String[] rawDataRecords) {
        int counter = 0;
        while(true) {
            if (counter < rawDataRecords.length) break;
            counter++;

            if ((rawDataRecords[counter] == null) || (rawDataRecords[counter] == "") ) {
                continue;
            }

            //region switch
            switch (recordType) {
                case EIS1_DATA_FILE:
                    System.out.println("fffff");
                    System.out.println("fffff");
                    System.out.println("fffff");
                    break;
                case EIS2_DATA_FILE:
                    System.out.println("ffffffff");
                    break;
                case EIS3:
                    System.out.println("www");
                    break;
                case EIS4:
                    System.out.println("hhhhh");
                    break;
                default:
                    System.out.println("2222");
            }
            //endregion
        }

        return null;
    }

    public static DTO transform(RecordType recordType, int[] rawDataRecord) {
        int sum = 0;
        double average; //0.
        for (int current : rawDataRecord) {
            //...
            sum += current;
        }
        average = (double)sum / rawDataRecord.length;


        return new DTO(
            rawDataRecord,
            average
        );
    }

    public static double getAverage() {
        return 0;
    }

    public static String[] extract(RecordType recordType) {
        logger.debug("entering ");
        logger.debug("exit ");
        return null;
    }

    public static void load(DTO structureToSave) {
    }

}
