package Model;

public class Months {
    private final String name;
    private final int dayCount;
    private final int firstDayOfWeek;

    public Months(String name, int dayCount, int firstDayOfWeek) {
        this.name = name;
        this.dayCount = dayCount;
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public int getDayCount() {
        return dayCount;
    }

    public int getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    public String getName() {
        return name;
    }
}
