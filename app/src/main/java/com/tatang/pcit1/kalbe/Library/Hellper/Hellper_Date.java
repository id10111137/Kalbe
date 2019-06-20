package com.tatang.pcit1.kalbe.Library.Hellper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Hellper_Date {


    public String sHasil;
    public int iHasil;
    SimpleDateFormat simpleDateFormat;
    Date date;

    String Hari[] = {"Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"};

    public Hellper_Date() {
        date = new Date();
    }

    public String getTime() {
        return sHasil = Integer.toString(Calendar.getInstance().get(Calendar.HOUR)) + " - " + Integer.toString(Calendar.getInstance().get(Calendar.MINUTE)) + " - " + Integer.toString(Calendar.getInstance().get(Calendar.SECOND));
    }

    public String getDateDay() {
        return sHasil = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    }

    public String GetDateMonth() {
        return sHasil = Integer.toString(iHasil = Calendar.getInstance().get(Calendar.MONTH));
    }

    public String getDateYearh() {
        return sHasil = Integer.toString(iHasil = Calendar.getInstance().get(Calendar.YEAR));
    }

    public String getDateDays() {

        iHasil = Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);

        switch (iHasil) {
            case 1:
                sHasil = "Senin";
                break;
            case 2:
                sHasil = "Selasa";
                break;
            case 3:
                sHasil = "Rabu";
                break;
            case 4:
                sHasil = "Kamis";
                break;
            case 5:
                sHasil = "Jumat";
                break;
            case 6:
                sHasil = "Sabtu";
                break;
            case 7:
                sHasil = "Minggu";
                break;
            default:
                sHasil = "Error";
                break;
        }

        return sHasil;
    }

    public String ConDate(String Format) {
        Date myDate = new Date(Format);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sHasil = simpleDateFormat.format(myDate);
    }

    public String getyyyyMMddHHmmss(Date date) {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sHasil = simpleDateFormat.format(date);
    }

    public String getHHmmSS() {
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return sHasil = simpleDateFormat.format(date);
    }

    public String getyyyyMMdd(String Format) {
        Date myDate = new Date(Format);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return sHasil = simpleDateFormat.format(myDate);
    }

    public String getDate() {
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return sHasil = simpleDateFormat.format(date);
    }

}
