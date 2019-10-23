package ru.job4j.oop;

/**
 * 1.5 Поля объекта[#187471]
 * @author Dev9tkov
 * @version 1
 * @since 23.10.2019
 */
public class Cat {

    private String food;
    private String name;

    /**
     * Метод вызывает имя котика и что он ел
     */
    public void show() {
        System.out.println(this.name + " el " + this.food);
    }

    /**
     * Метод записывает в поле объекта значение переменной
     * @param meat что ел котик
     */
    public void eat(String meat) {
        this.food = meat;
    }

    /**
     * Метод записывает кличку кота в переменную
     * @param nick кличка котика
     */
    public void giveNick(String nick) {
        this.name = nick;
    }

    /**
     * Метод создает 2 экземпляра класса и вызывает методы gav, show и giveNick
     * @param args args
     */
    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
