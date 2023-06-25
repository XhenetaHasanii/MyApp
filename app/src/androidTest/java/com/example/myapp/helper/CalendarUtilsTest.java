package com.example.myapp.helper;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import com.example.myapp.helpers.CalendarUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class CalendarUtilsTest {
    CalendarUtils calendarUtils;

    @Before
    public void createObjects() {
        calendarUtils = new CalendarUtils();
    }

    @Test
    public void formattedDateTest(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 22);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,55);
        cal.set(Calendar.SECOND,0);
        LocalDate localDate = LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId()).toLocalDate();
        String outputString = CalendarUtils.formattedDate(localDate);

        assertEquals("22 June 2023", outputString);

    }

    @Test
    public void formattedTimeTest(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 22);
        cal.set(Calendar.HOUR_OF_DAY,11);
        cal.set(Calendar.MINUTE,30);
        cal.set(Calendar.SECOND,0);
        // Getting the timezone
        TimeZone tz = cal.getTimeZone();
        // Getting zone id
        ZoneId zoneId = tz.toZoneId();
        // conversion
        LocalDateTime localDateTime = LocalDateTime.ofInstant(cal.toInstant(), zoneId);

        LocalTime localTime = localDateTime.toLocalTime();
        String outputString = CalendarUtils.formattedTime(localTime);

        assertEquals("11:30:00 AM", outputString);

    }

    @Test
    public void monthYearFromDateTest(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 22);
        cal.set(Calendar.HOUR_OF_DAY,11);
        cal.set(Calendar.MINUTE,30);
        cal.set(Calendar.SECOND,0);
        // Getting the timezone
        TimeZone tz = cal.getTimeZone();
        // Getting zone id
        ZoneId zoneId = tz.toZoneId();
        // conversion
        LocalDateTime localDateTime = LocalDateTime.ofInstant(cal.toInstant(), zoneId);

        LocalDate localDate = localDateTime.toLocalDate();
        String outputString = CalendarUtils.monthYearFromDate(localDate);

        assertEquals("April 2023", outputString);


    }

}
