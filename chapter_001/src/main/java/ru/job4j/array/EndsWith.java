package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        int k = 0;
        for (int i = post.length - 1; i >= 0; i--) {
            k++;
            if (post[i] != word[word.length - k]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
