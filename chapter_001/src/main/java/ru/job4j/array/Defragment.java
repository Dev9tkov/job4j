package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        int j = 0;
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell != null) {
                if (j < index) {
                    array[j] = null;
                    array[j] = array[index];
                    array[index] = null;
                }
                j++;
            }
        }
        return array;
    }



    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.println(compressed[index] + " ");
        }
    }
}
