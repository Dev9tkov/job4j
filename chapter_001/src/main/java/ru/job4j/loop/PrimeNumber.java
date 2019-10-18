package ru.job4j.loop;

public class PrimeNumber {
    CheckPrimeNumber ch = new CheckPrimeNumber();
    public int calc(int finish) {
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            if (ch.check(i)) {
                count++;
            }
        }
        return count;
    }
}



