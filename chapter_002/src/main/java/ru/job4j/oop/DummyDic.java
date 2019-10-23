package ru.job4j.oop;

/**
 * ТЗ 1.4 Вызов метод с возвращаемым типом [#187475]
 * @author Dev9tkov
 * @version 1
 * @since 23.10.2019
 */

public class DummyDic {
    /**
     * Метод возвращает звук
     * @return вывдит переменную eng
     */
    public String engToRus() {
        String eng = "ku ku";
        return eng;
    }

    /**
     * Метод возвращает строку
     * @param args args
     */
    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String saw = dic.engToRus();
        System.out.println("Неизвестное слово " + saw);
    }
}
