package ru.netology;

import java.util.Random;

public class Product implements Comparable<Product> {
    protected String productId;
    protected String productName;
    protected int prise;
    protected double rating;


    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    public Product(String productName, int prise, double rating) {
        sb.append(productName, 0, 2);
        sb.append(random.nextInt(99 - 10) + 10);
        this.productId = String.valueOf(sb);
        this.productName = productName;
        this.prise = prise;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %d рублей (рейтинг: %.1f)", productId, productName, prise, rating);
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public int compareTo(Product product) {
        if (prise < product.prise) {
            return -1;
        } else if (prise > product.prise) {
            return 1;
        } else {
            return productName.compareTo(product.productName);
        }
    }
}
