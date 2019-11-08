package ru.job4j.sort;

import java.util.Arrays;

/**
 * Нужно реализовать механизм возврата монет в лендинговых аппаратах.
 *
 * @author Dev9tkov
 * @version 01
 * @since 08.11.2019
 */
public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int i = 0;
        int k = 0;
        int raznica = money - price;
        while (raznica != 0) {
            if (raznica >= coins[i]) {
                raznica -= coins[i];
                rsl[k] = coins[i];
                k++;
                size++;
            } else {
                i++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
