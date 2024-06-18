import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class NextDayCalculatorTest extends NextDayCalculator {
    @Test
    void testNextDay1() {
        assertArrayEquals(new int[]{2, 1, 2018}, NextDayCalculator.nextDay(1, 1, 2018));
    }
    @Test
    void testNextDay2() {
        assertArrayEquals(new int[]{1, 2, 2018}, NextDayCalculator.nextDay(31, 1, 2018));
    }
    @Test
    void testNextDay3() {
        assertArrayEquals(new int[]{1, 5, 2018}, NextDayCalculator.nextDay(30, 4, 2018));
    }

    @Test
    void testNextDay4(){
        assertArrayEquals(new int[]{1, 3, 2018}, NextDayCalculator.nextDay(28, 2, 2018));
    }

    @Test
    void testNextDay5(){
        assertArrayEquals(new int[]{1, 3, 2020}, NextDayCalculator.nextDay(29, 2, 2020));
    }

    @Test
    void testNextDay6(){
        assertArrayEquals(new int[]{1, 1, 2019}, NextDayCalculator.nextDay(31, 12, 2018));
    }
}