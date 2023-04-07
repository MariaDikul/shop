package ru.netology;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop<T> implements Printer {
    List<T> productList = new ArrayList<>();

    public void addNewProduct(T newProduct) {
        productList.add(newProduct);
    }

    public List<T> getProductList() {
        return productList;
    }

    public void print() {
        System.out.println("Каталог товаров:");
        for (T product : productList) {
            System.out.println(product);
        }
    }

    public void filterProductList(Filters filterName) {
        switch (filterName) {
            case PRISE:
                productList = productList.stream()
                        .sorted((Comparator<? super T>) Comparator.naturalOrder())
                        .collect(Collectors.toList());
                break;
            case NAME:
                productList = productList.stream()
                        .sorted((Comparator<? super T>) new NameComparator())
                        .collect(Collectors.toList());
                break;
            case RATING:
                productList = productList.stream()
                        .sorted((Comparator<? super T>) new RatingComparator())
                        .collect(Collectors.toList());
                break;
        }
    }
}
