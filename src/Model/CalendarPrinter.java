package Model;

import Model.CalendarYear;

public class CalendarPrinter {
    public CalendarPrinter() {}

    public void printCalendar(CalendarYear cal) {
        System.out.println(cal.getYear());
        for (Months month : cal.getMonths()) {
            System.out.println(month.getName());
            System.out.println(" Mo Tu We Th Fr Sa Su");

            int firstDayOfWeek = month.getFirstDayOfWeek();
            for (int k = 0; k < firstDayOfWeek; k++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= month.getDayCount(); ++j) {
                System.out.printf("%3d", j);
                if ((j + firstDayOfWeek) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println("\n");
        }
    }
}
