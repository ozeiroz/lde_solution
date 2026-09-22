package Model;

import java.util.List;

public class CalendarYear {
    private final int year;
    private final List<Months> months;

    public CalendarYear(int year, List<Months> months) {
        this.year = year;
        this.months = months;
    }

    public int getYear() {
        return year;
    }

    public List<Months> getMonths() {
        return months;
    }
}
