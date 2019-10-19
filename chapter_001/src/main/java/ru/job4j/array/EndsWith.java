package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        int count = 0;
        int k = 0;
        for (int i = post.length - 1; i >= 0; i--) {
            k++;
            if (post[i] != word[word.length-k]) {
                    count++;
            }
        }
        if (count == 0) {
            result = true;
        }

        return result;
    }
}
