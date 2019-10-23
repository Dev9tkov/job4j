package ru.job4j.oop;

/**
 * ТЗ 1.3 Вызов метода с аргументамми. [#187473]. Напишите метод main с
 * демонстрацией работы этого метода и объекта этого класса
 *
 * @author dev9tkov
 * @version 1
 * @since 23.10.2019
 */

public class Jukebox {
    /**
     * Метод описывает различные варианты песен
     * @param position число показывает, слова какой песни выводить
     *
     */
    public static void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }
    /**
     * Метод демонстрирует работу объектов класса
     * @param args args
     */

    public static void main(String[] args) {
        Jukebox pesnya1 = new Jukebox();
        Jukebox pesnya2 = new Jukebox();
        Jukebox pesnya3 = new Jukebox();
        pesnya1.music(1);
        pesnya2.music(2);
        pesnya3.music(3);
    }
}
