package stepDefinitions.base;

import java.io.File;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import org.apache.commons.io.FileUtils;

public class Base {
    public static String getRandomCode() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);

        return new String(array, Charset.forName("UTF-8"));
    }


    public static String CreatePreviousFutureDate(int days, String simpleDateFormat){
        Calendar cal  = Calendar.getInstance();
        //subtracting a day
        cal.add(Calendar.DATE, days);

        SimpleDateFormat s = new SimpleDateFormat(simpleDateFormat);
        String result = s.format(new Date(cal.getTimeInMillis()));
        return result;
    }

    public static String CalculateTheFirstWorkingDay(String hoursMinutesSeconds, String simpleDateFormat){
        String tempDate="01.01.1000";
        Date d = new Date();

        if (java.time.LocalTime.now().isAfter(LocalTime.parse(hoursMinutesSeconds + ".000000000")) && d.getDay() == 5){
            tempDate = Base.CreatePreviousFutureDate(3,simpleDateFormat);
        } else if(d.getDay() == 6){
            tempDate = Base.CreatePreviousFutureDate(2,simpleDateFormat);
        } else if (d.getDay() == 0 || java.time.LocalTime.now().isAfter(LocalTime.parse(hoursMinutesSeconds + ".000000000"))){
            tempDate = Base.CreatePreviousFutureDate(1,simpleDateFormat);
        } else {tempDate = Base.CreatePreviousFutureDate(0,simpleDateFormat);
        }
        return tempDate;
    }

    public static boolean IsFileDownloaded(String path, String fileName){
        File root = new File(path);

        try {

            boolean recursive = true;

            Collection files = FileUtils.listFiles(root, null, recursive);

            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                if (file.getName().equals(fileName)){
                    System.out.println("File path is: " + file.getAbsolutePath() + ". Deleting the file...");
                    file.delete();
                    return true;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        System.out.println("Didnt find the file.");
        return false;
    }

}
