package jpa-basic;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30};

        if (month == 1) {
            if ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0) {
                days[month] = 29;
            }
        }
        System.out.println(days[month] + " days for " + year + "-" + (month + 1));
    }
}