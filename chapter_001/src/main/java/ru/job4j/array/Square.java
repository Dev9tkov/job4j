package ru.job4j.array;

/**
 * Square заполняет массив числами, возведенными в квадрат
 * @author dev9tkov
 * @since 20.10.2019
 * @version 1
 */

public class Square {
    /**
     * Метод должен заполнить массив числами, возведенными в квадрат
     * @param bound кол-во цифр в массиве
     * @return вывод числе возведенных в квадрат
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != bound; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}
