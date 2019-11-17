package ru.job4j.array;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int m = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                rsl[m] = left[i];
                i++;
            } else {
                rsl[m] = right[j];
                j++;
            }
            m++;
        }
        while (i < left.length) {
            rsl[m] = left[i];
            i++;
            m++;
        }
        while (j < right.length) {
            rsl[m] = right[j];
            j++;
            m++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
