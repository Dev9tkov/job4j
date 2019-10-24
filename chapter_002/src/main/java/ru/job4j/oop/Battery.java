package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        this.load = this.load - another.load;
        another.load += another.load;
    }

    public static void main(String[] args) {
        Battery bat1 = new Battery(25);
        Battery bat2 = new Battery(5);
        System.out.println("bat1 : " + bat1.load + ". bat2 : " + bat2.load);
        bat1.exchange(bat2);
        System.out.println("bat1 : " + bat1.load + ". bat2 : " + bat2.load);
    }
}
