package Model;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Logger;

public class GrigorianCalendar implements Calendar {
    private final Logger logger = Logger.getLogger("GrigorianCalendar");


    public GrigorianCalendar() {}

    @Override
    public CalendarYear getCalendar(int year) throws InputMismatchException {
        if (year < 1) {
            throw new InputMismatchException("Year must be a positive integer");
        }

        int epochCode = getEpochCode(year);
        boolean leapYear = isLeapYear(year);
        int firstDayOfWeek = (((leapYear ? -1 : 0) + getYearCode(year, epochCode)) % 7 + 7) % 7;

        List<Months> monthsList = new ArrayList<>();

        for (int i = 0; i < 12; ++i) {
            int dayCount = getDayCount(i, leapYear);
            monthsList.add(new Months(MonthNames.values()[i].toString(), dayCount, firstDayOfWeek));
            firstDayOfWeek = (dayCount + firstDayOfWeek) % 7;
        }

        return new CalendarYear(year, monthsList);
    }

    private int getDayCount(int monthNumber, Boolean leapYear) {
        int dayCount = -1;
        // JAN FEB MAR APR MAY JUN JUL
        if (monthNumber / 7 == 0) {
            if (monthNumber % 2 == 0) {
                dayCount = 31;
            } else if (monthNumber == 1) {
                dayCount = leapYear ? 29 : 28;
            } else if (monthNumber % 2 == 1) {
                dayCount = 30;
            }
            // AUG SEP OCT NOV DEC
        } else {
            if (monthNumber % 2 == 1) {
                dayCount = 31;
            } else if (monthNumber % 2 == 0) {
                dayCount = 30;
            }
        }
        return dayCount;
    }

    private int getEpochCode(int year) {
        return switch (year / 100 % 4) {
            case 1 -> 4;
            case 2 -> 2;
            case 3 -> 0;
            default -> 6;
        };
    }

    private int getYearCode(int year, int epochCode) {
        return (epochCode + year % 100 + ((year % 100) / 4) % 7);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
