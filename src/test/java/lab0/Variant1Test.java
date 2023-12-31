package lab0;

import org.example.lab0.Variant1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Variant1Test {
    @Test(dataProvider = "meterData")
    public void meterTest(int l, int expected) {
        int actual = new Variant1().inMeter(l);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] meterData() {
        return new Object[][]{
                {100, 1},
                {200, 2},
                {300, 3}
        };
    }

    @Test(dataProvider = "positiveNumberData")
    public void testIsPositiveNumber(int number, boolean expected) {
        boolean actual = new Variant1().isPositiveNumber(number);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] positiveNumberData() {
        return new Object[][]{
                {1, true},
                {0, false},
                {-1, false}
        };
    }

    @Test(dataProvider = "increasesIfPositive")
    public void testModifyNumber(int input, int expected) {
        int actual = new Variant1().increasesIfPositive(input);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] increasesIfPositive() {
        return new Object[][]{
                {1, 2},
                {0, 0},
                {-1, -1}
        };
    }

    @Test(dataProvider = "dayOfWeekData")
    public void testGetDayOfWeek(int dayNumber, String expected) {
        String actual = new Variant1().getDayOfWeek(dayNumber);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] dayOfWeekData() {
        return new Object[][]{
                {1, "Monday"},
                {2, "Tuesday"},
                {3, "Wednesday"},
                {4, "Thursday"},
                {5, "Friday"},
                {6, "Saturday"},
                {7, "Sunday"},
                {0, "undefined"},
                {100, "undefined"}
        };
    }

    @Test(dataProvider = "numberData")
    public void testPrintNumberNTimes(int k, int n, int[] expectedOutput) {
        int[] actualOutput = new Variant1().printNumberNTimes(k, n);

        assertEquals(actualOutput, expectedOutput);
    }

    @DataProvider(name = "numberData")
    public Object[][] numberData() {
        return new Object[][]{
                {1, 5, new int[]{1, 1, 1, 1, 1}},
                {2, 1, new int[]{2}}
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void printNumberNTimesNegative() {
        new Variant1().printNumberNTimes(1, -1);
    }


    @Test(dataProvider = "remainingLengthData")
    public void testFindRemainingLength(int a, int b, int expected) {
        int actual = new Variant1().findRemainingLength(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] remainingLengthData() {
        return new Object[][]{
                {10, 5, 0},
                {2, 1, 0},
                {20, 3, 2},
        };
    }

    @Test(dataProvider = "minMaxData")
    public void testFindMinMax(int[] numbers, int[] expected) {
        int[] actual = new Variant1().findMinMax(numbers);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] minMaxData() {
        return new Object[][]{
                {new int[]{3, 52, 2456, 6, -555}, new int[]{-555, 2456}},
                {new int[]{4, 62, 1}, new int[]{1, 62}},
                {new int[]{0}, new int[]{0, 0}},
        };
    }

    @Test(dataProvider = "oddNumbersData")
    public void testGenerateOddNumbers(int n, int[] expected) {
        int[] actual = new Variant1().generateOddNumbers(n);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] oddNumbersData() {
        return new Object[][]{
                {1, new int[]{1}},
                {3, new int[]{1, 3, 5}},
                {5, new int[]{1, 3, 5, 7, 9}},
        };
    }

    @Test(dataProvider = "matrixData")
    public void testCreateMatrix(int m, int n, int[][] expectedMatrix) {
        int[][] actualMatrix = new Variant1().createMatrix(m, n);

        assertEquals(actualMatrix.length, expectedMatrix.length);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertEquals(actualMatrix[i].length, expectedMatrix[i].length);
        }

        for (int i = 0; i < expectedMatrix.length; i++) {
            for (int j = 0; j < expectedMatrix[i].length; j++) {
                assertEquals(actualMatrix[i][j], expectedMatrix[i][j]);
            }
        }
    }

    @DataProvider
    public Object[][] matrixData() {
        return new Object[][]{
                {2, 2, new int[][]{{10, 10}, {20, 20}}},
                {3, 3, new int[][]{{10, 10, 10}, {20, 20, 20}, {30, 30, 30}}},
                {1, 1, new int[][]{{10}}},
        };
    }
}
