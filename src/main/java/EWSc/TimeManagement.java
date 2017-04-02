package EWSc;

import java.util.Calendar;
import java.util.Date;

public class TimeManagement {
    private String date = "2017-03-29T18:55:00";
    public Date getDate(){
        String[] newDate =  date.split("T");
        String[] YMD, HMS;
        YMD = newDate[0].split("-");
        HMS = newDate[1].split(":");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(YMD[0]), Integer.parseInt(YMD[1]), Integer.parseInt(YMD[2]), Integer.parseInt(HMS[0]), Integer.parseInt(HMS[1]), Integer.parseInt(HMS[2]));
        return cal.getTime();
    }
}
