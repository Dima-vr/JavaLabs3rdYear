package org.example.lab0;


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


    public void printNumberNTimes(int K, int N) {
        if (N <= 0) {
            System.out.println("N must be greater than zero");
            return;
        }

        String repeatedNumber = String.valueOf(K).repeat(N);
        System.out.print(repeatedNumber);
    }

    public int findRemainingLength(int A, int B) {
        if (A <= 0 || B <= 0) {
            throw new IllegalArgumentException("A and B must be positive numbers.");
        }

        while (A >= B) {
            A -= B;
        }

        //return A % B;
        return A;
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

    public int[] generateOddNumbers(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be greater than zero");
        }

        int[] oddNumbersArray = new int[N];
        int oddNumber = 1;

        for (int i = 0; i < N; i++) {
            oddNumbersArray[i] = oddNumber;
            oddNumber += 2;
        }

        return oddNumbersArray;
    }


    public int[][] createMatrix(int M, int N) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * (i + 1);
            }
        }
        return matrix;
    }
}
