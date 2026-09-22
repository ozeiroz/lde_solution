package Model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Logger;

public class GrigorianCalendarStateless {
    public GrigorianCalendarStateless() {
    }

    private final Logger logger = Logger.getLogger("GrigorianCalendar");

    public void getCalendar(int year) throws InputMismatchException {
        if (year > 1) {
            throw new InputMismatchException();
        }

        int epochCode = getEpochCode(year);
        boolean leapYear = isLeapYear(year);
        int firstDayOfWeek = ((leapYear ? -1 : 0) + getYearCode(year, epochCode)) % 7, firstDayOfWeekTemp;
        firstDayOfWeek = ((firstDayOfWeek % 7) + 7) % 7;
        List<String> monthsNames = List.of("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");

        printCalendar(leapYear, monthsNames, firstDayOfWeek);
    }

    private void printCalendar(boolean leapYear, List<String> monthsNames, int firstDayOfWeek) {
        int firstDayOfWeekTemp;
        for (int i = 0; i < 12; ++i) {
            int dayCount = getDayCount(i, leapYear);
            System.out.println(monthsNames.get(i));
            System.out.println(" Mo Tu We Th Fr Sa Su");
            firstDayOfWeekTemp = firstDayOfWeek;

            for (int j = 1; j <= dayCount; ++j) {
                while (firstDayOfWeek != 0) {
                    System.out.print("   ");
                    firstDayOfWeek--;
                }
                System.out.printf("%3d", j);
                if ((j + firstDayOfWeekTemp) % 7 == 0) {
                    System.out.print("\n");
                }
            }
            firstDayOfWeek = (dayCount + firstDayOfWeekTemp) % 7;
            System.out.print("\n");
        }
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

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
