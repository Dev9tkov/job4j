package ru.job4j.io;

import java.util.Scanner;


public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sp = 11;
        while (sp > 0) {
            System.out.println("Игрок 1 введите число от 1 до 3: ");
            int select = Integer.valueOf(input.nextLine());
            sp = sp - select;
            System.out.println("Осталось " + sp + " спичек");
            if (sp > 0) {
                System.out.println("Игрок 2 введите число от 1 до 3: ");
                int select2 = Integer.valueOf(input.nextLine());
                sp = sp - select2;
                System.out.println("Осталось " + sp + " спичек");
            }
        }

    }
}
