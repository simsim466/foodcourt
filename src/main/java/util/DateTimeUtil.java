package util;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeUtil {
    public static boolean isLate(LocalTime time) {
        return LocalTime.of(11, 0).isBefore(time);
    }

    public static boolean isLateNow() {
        return isLate(LocalTime.now());
    }

    public static boolean isToday(LocalDate date) {
        return LocalDate.now().isEqual(date);
    }

    private static LocalDate nextDate(LocalDate date) {
        return date.plusDays(1);
    }

    public static LocalDate today() {
        return LocalDate.now();
    }

    public static LocalDate tomorrow() {
        return nextDate(LocalDate.now());
    }

    private DateTimeUtil() {
    }
}
