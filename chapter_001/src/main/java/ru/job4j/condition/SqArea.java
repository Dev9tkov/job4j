package ru.job4j.condition;

public class SqArea {
    public static double squarea(int p, int k) {
        return (0.5 * p / (k + 1)) * (k * 0.5 * p / (k + 1));
    }
    public static void main(String[] args) {
        double result1 = squarea(6,2 );
        System.out.println(" p = 6, k = 2, s = " + result1);
    }

}
