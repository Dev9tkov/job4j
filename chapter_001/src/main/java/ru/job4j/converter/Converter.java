package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }
    public static int rubleToDollar(int value) {
        return value / 60;
    }
    public static int euroToRuble(int value) {
        return value * 70;
    }
    public static int dollarToRuble(int value) {
        return value * 60;
    }
    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2 euro. Test result: " + passed);

        int indol = 180;
        int expecteddol = 3;
        int outdol = rubleToDollar(indol);
        boolean passeddol = expecteddol == outdol;
        System.out.println("180 rubles are 3 dollar. Test result: " + passeddol);

        int inrub = 2;
        int expectedrub = 140;
        int outrub = euroToRuble(inrub);
        boolean passedrub = expectedrub == outrub;
        System.out.println("2 euro are 140 rubles. Test result: " + passedrub);

        int inrubdol = 3;
        int expectedrubdol = 180;
        int outrubdol = dollarToRuble(inrubdol);
        boolean passedrubdol = expectedrubdol == outrubdol;
        System.out.println("3 dollars are 180 rubles. Test result: " + passedrubdol);

    }
}
