package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i != data.length; i++) {
            if (data[0] != data[i]) {
                count++;
            }
        }
        if (count == 0) {
            result = true;
        }
        return result;
    }
}
