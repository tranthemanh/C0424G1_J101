public class NextDayCalculator {
    public static int[] nextDay(int day, int month, int year) {
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        if(CheckForValidDateAndMonth(day, month)) {
            System.out.println("Khong ton tai");
        }
        if (CheckTheMonthHas31Days(day, month)) {
            nextDay = 1;
            if (month == 12) {
                nextMonth = 1;
                nextYear = year + 1;
            }else {
                nextMonth = month + 1;
            }
        }else if (CheckTheMonthHas30Days(day, month)) {
            nextDay = 1;
            nextMonth = month + 1;
        }else if(month == 2) {
            if (checkLeapYear(year)){
                if (day == 29) {
                    nextDay = 1;
                    nextMonth = month + 1;
                }
            } else if (day == 28){
                nextDay = 1;
                nextMonth = month + 1;
            }
        }else {
            nextDay++;
        }
        return new int[] {nextDay, nextMonth, nextYear};
    }

    private static boolean checkLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private static boolean CheckTheMonthHas30Days(int day, int month) {
        return day == 30 && (month == 4 || month == 6 || month == 9 || month == 11);
    }

    private static boolean CheckTheMonthHas31Days(int day, int month) {
        return day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12);
    }

    private static boolean CheckForValidDateAndMonth(int day, int month) {
        return day < 1 || day > 31 || month < 1 || month > 12;
    }
}
