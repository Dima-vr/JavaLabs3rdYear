package org.example.lab0;

import java.util.Arrays;

public class Variant1 {
    public int inMeter(int l) {
        return l / 100;
    }

    public boolean isPositiveNumber(int number) {
        return number > 0;
    }

    public int increasesIfPositive(int number) {
        return isPositiveNumber(number) ? number + 1 : number;
    }

    public String getDayOfWeek(int dayNumber) {
        String[] daysOfWeek = {"undefined", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (dayNumber >= 1 && dayNumber <= 7) {
            return daysOfWeek[dayNumber];
        } else {
            return "undefined";
        }
    }


    public int[] printNumberNTimes(int k, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be greater than zero");
        }

        int[] repeatedNumber = new int[n];
        Arrays.fill(repeatedNumber, k);
        return repeatedNumber;
    }

    public int findRemainingLength(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("a and b must be positive numbers.");
        }

        while (a >= b) {
            a -= b;
        }

        return a;
    }

    public int[] findMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return new int[]{min, max};
    }

    public int[] generateOddNumbers(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero");
        }

        int[] oddNumbersArray = new int[n];
        int oddNumber = 1;

        for (int i = 0; i < n; i++) {
            oddNumbersArray[i] = oddNumber;
            oddNumber += 2;
        }

        return oddNumbersArray;
    }


    public int[][] createMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 10 * (i + 1);
            }
        }
        return matrix;
    }
}
