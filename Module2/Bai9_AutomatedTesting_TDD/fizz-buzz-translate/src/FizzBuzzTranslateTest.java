import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {
    @Test
    public void testFizz() {
        assertEquals("Fizz", FizzBuzzTranslate.translate(3));
        assertEquals("Fizz", FizzBuzzTranslate.translate(13));
        assertEquals("Fizz", FizzBuzzTranslate.translate(33));
    }

    @Test
    public void testBuzz() {
        assertEquals("Buzz", FizzBuzzTranslate.translate(5));
        assertEquals("Buzz", FizzBuzzTranslate.translate(52));
        assertEquals("Buzz", FizzBuzzTranslate.translate(55));
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzzTranslate.translate(15));
        assertEquals("FizzBuzz", FizzBuzzTranslate.translate(30));
        assertEquals("FizzBuzz", FizzBuzzTranslate.translate(45));
    }

    @Test
    public void testNumberToWords() {
        assertEquals("một", FizzBuzzTranslate.translate(1));
        assertEquals("hai mươi sáu", FizzBuzzTranslate.translate(26));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzzTranslate.translate(0);
        });
    }
}