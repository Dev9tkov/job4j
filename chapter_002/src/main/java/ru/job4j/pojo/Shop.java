package ru.job4j.pojo;

public class Shop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null && i < products.length - 1) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product products[] = new Product[4];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Juce", 14);
        delete(products, 1);
    }
}


