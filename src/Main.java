import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer date = scanner.nextInt();

        GrigorianCalendarStateless grigorianCalendar = new GrigorianCalendarStateless();
        grigorianCalendar.getCalendar(date);
    }
}