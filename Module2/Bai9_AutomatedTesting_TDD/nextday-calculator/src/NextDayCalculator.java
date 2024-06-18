public class NextDayCalculator {
    public static int[] nextDay(int day, int month, int year) {
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        if(day < 1 || day > 31 || month < 1 || month > 12) {
            System.out.println("Khong ton tai");
        }
        if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
            nextDay = 1;
            if (month == 12) {
                nextMonth = 1;
                nextYear = year + 1;
            }else {
                nextMonth = month + 1;
            }
        }else if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            nextDay = 1;
            nextMonth = month + 1;
        }else if(month == 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
                if (day == 29) {
                    nextDay = 1;
                    nextMonth = month + 1;
                }
            } else if (day == 28 && month == 2){
                nextDay = 1;
                nextMonth = month + 1;
            }
        }else {
            nextDay++;
        }
        return new int[] {nextDay, nextMonth, nextYear};
    }
}
