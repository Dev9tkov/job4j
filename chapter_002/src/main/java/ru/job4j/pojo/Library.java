package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book garry = new Book("Garry Potter", 325);
        Book code = new Book("Clean code", 285);
        Book don = new Book("Tichii Don", 148);
        Book milya = new Book("Zelenaya Milya", 443);

        Book[] books = new Book[4];
        books[0] = garry;
        books[1] = code;
        books[2] = don;
        books[3] = milya;

        for (int i = 0; i < books.length; i++) {
            Book bo = books[i];
            System.out.println(bo.getName() + " - " + bo.getPages());
        }

        System.out.println("Perestavim mestami knigi 0 i 3");
        Book tmp = new Book("Null", 0);
        tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int i = 0; i < books.length; i++) {
            Book bo = books[i];
            System.out.println(bo.getName() + " - " + bo.getPages());
        }

        System.out.println("Vyvesti knigu clean code");
        for (int i = 0; i < books.length; i++) {
            Book bo = books[i];
            if (bo.getName() == "Clean code") {
                System.out.println(bo.getName() + " - " + bo.getPages());
            }
        }

    }
}
