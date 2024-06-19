public class FizzBuzzTranslate {
    public static String translate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;
        boolean contains3 = String.valueOf(number).contains("3");
        boolean contains5 = String.valueOf(number).contains("5");


        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        }else if (divisibleBy3 || contains3) {
            return "Fizz";
        }else if (divisibleBy5 || contains5) {
            return "Buzz";
        }
        return numberToWords(number);
    }

    private static String numberToWords(int number) {
        String[] units = { "", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
        String[] teens = { "mười", "mười một", "mười hai", "mười ba", "mười bốn", "mười lăm", "mười sáu", "mười bảy", "mười tám", "mười chín" };
        String[] tens = { "", "", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi" };

        if (number < 10) {
            return units[number];
        }else if (number < 20) {
            return teens[number - 10];
        }else {
            int unit = number % 10;
            int ten = number / 10;

            if (unit == 0) {
                return tens[ten];
            }
            return tens[ten] + " " + units[unit];
        }
    }
}
