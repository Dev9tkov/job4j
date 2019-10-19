package ru.job4j.array;

public class ArrayChar {
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i != pref.length; i++) {
            if (pref[i] != word[i]) {
                count++;
            }
        }
        if (count == 0) {
            result = true;
        }

        return result;
    }
}
