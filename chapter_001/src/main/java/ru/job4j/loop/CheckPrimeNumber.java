package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num) {
        boolean prime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if ((num % i) == 0) {
                prime = false;
            }
        }
        return prime;
    }
}
