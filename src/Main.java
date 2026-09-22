import Model.Calendar;
import Model.CalendarPrinter;
import Model.CalendarYear;
import Model.GrigorianCalendar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer year = scanner.nextInt();
//          Stateless Solution
//        Model.GrigorianCalendarStateless grigorianCalendar = new Model.GrigorianCalendarStateless();
//        grigorianCalendar.getCalendar(year);


        CalendarPrinter printer = new CalendarPrinter();
        printer.printCalendar(new GrigorianCalendar().getCalendar(year));
    }
}