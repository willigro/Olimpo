package com.rittamann.oappack.date;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ODate {

    /**
     * Use in views
     * */
    public static String dateTimeFormatoPTBR(Calendar calendar) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        dateFormat.setTimeZone(calendar.getTimeZone());
        return dateFormat.format(calendar.getTime());
    }

    /**
     * Use in databse
     * */
    public static String simpleDateFormat(Calendar calendar) {
        SimpleDateFormat format = getFormat();
        format.setTimeZone(calendar.getTimeZone());
        Date time = calendar.getTime();
        return format.format(time);
    }

    public static String getMonthSQLite(Calendar calendar) {
        int mont = calendar.get(Calendar.MONTH) + 1;
        if (mont < 10) {
            return "0" + mont;
        }
        return String.valueOf(mont);
    }

    public static String getDaySQLite(Calendar calendar) {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (day < 10) {
            return "0" + day;
        }
        return String.valueOf(day);
    }

    public static Calendar parseDate(String string) {
        Calendar calendar = Calendar.getInstance();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        try {
            calendar.setTime(getFormat().parse(string));
        } catch (ParseException e) {
            e.printStackTrace();
            Log.i("teste", e.getMessage());
        }
        return calendar;
    }

    public static int diffMinutes(long diff) {
        return (int) (diff / (60 * 1000));
    }

    public static String getOnlyDate(Calendar calendar) {
        SimpleDateFormat format = getFormatDate();
        format.setTimeZone(calendar.getTimeZone());
        Date time = calendar.getTime();
        return format.format(time);
    }

    public static String getDaySQLite(int day) {
        if (day < 10) {
            return "0" + day;
        }
        return String.valueOf(day);
    }

    public static Calendar getCalendarInitMonth(int value) {
        Calendar calendar = getCalendarInitDay();
        calendar.set(Calendar.MONTH, value);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar;
    }

    public static Calendar getCalendarInitDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    @SuppressLint("SimpleDateFormat")
    private static SimpleDateFormat getFormatDate() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @SuppressLint("SimpleDateFormat")
    private static SimpleDateFormat getFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
