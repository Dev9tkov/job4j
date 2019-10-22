package ru.job4j.condition;

public class SqArea {
    public static double squarea(int p, int k) {
        int h = p / (2 * (k + 1));
        int w = k * h;
        int s = w * h;
        return s;
        //return (0.5 * p / (k + 1)) * (k * 0.5 * p / (k + 1));
    }
    public static void main(String[] args) {
        double result1 = squarea(6, 2);
        System.out.println(" p = 6, k = 2, s = " + result1);
    }

}
