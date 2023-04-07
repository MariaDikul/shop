package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shop<Product> listProduct = new Shop();
        listProduct.addNewProduct(new Product("молоко", 60, 5.0));
        listProduct.addNewProduct(new Product("хлеб", 25, 4.9));
        listProduct.addNewProduct(new Product("курица", 250, 3.0));
        listProduct.addNewProduct(new Product("картофель", 15, 5.0));
        listProduct.addNewProduct(new Product("томаты", 226, 4.1));
        listProduct.addNewProduct(new Product("чай", 125, 5.0));
        listProduct.addNewProduct(new Product("кофе", 200, 2.9));

        ClientService clientService = new ClientService();
        System.out.println("Добро пожаловать в теле-магазин!");
        listProduct.print();
        while (true) {
            System.out.println("Если хотите добавить товар в корзину - нажмите 1; \n" +
                    "Если хотите убрать товар из корзины - нажмите 2; \n" +
                    "Если хотите применить филтр к списку товаров - нажмите 3; \n" +
                    "Если хотите сделать заказ - нажмите 4; \n" +
                    "Если хотите отменить заказ - нажмите 5; \n" +
                    "Если хоите еще раз увидеть список товаров - нажмите 6.");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println("Введите номер товара, указанный в [скобках]. " +
                            "Если хотите добавить сразу несколько товаров, то указывайте номера товаров, " +
                            "разделяя их пробелом.");
                    String shoppingList = scanner.nextLine();
                    clientService.addToBasket(listProduct.getProductList(), shoppingList);
                    clientService.print();
                    break;
                case "2":
                    if (clientService.getBasket().isEmpty()) {
                        System.out.println("Корзина пуста");
                    } else {
                        System.out.println("Чтобы удалить товар из козины, ведите номер товара, указанный в [скобках]. " +
                                "Если хотите удалить сразу несколько товаров, то указывайте номера товаров, " +
                                "разделяя их пробелом.");
                        clientService.removeFromBasket(scanner.nextLine());
                        clientService.print();
                    }
                    break;
                case "3":
                    System.out.println("Нажмите 1 - фильр по названию; \n" +
                            "Нажмите 2 - фильтр по цене; \n" +
                            "Нажмите 3 - фильтр по рейтингу.");
                    String filterName = scanner.nextLine();
                    switch (filterName) {
                        case "1":
                            listProduct.filterProductList(Filters.NAME);
                            break;
                        case "2":
                            listProduct.filterProductList(Filters.PRISE);
                            break;
                        case "3":
                            listProduct.filterProductList(Filters.RATING);
                            break;
                        default:
                            System.out.println("Некоррректный ввод");
                    }
                    listProduct.print();
                    break;
                case "4":
                    clientService.ordering();
                    break;
                case "5":
                    if (clientService.getTrackerList().isEmpty()) {
                        System.out.println("У вас нет активных заказов");
                    } else {
                        System.out.println("Чтобы отменить заказ, введите его номер:");
                        String tracker = scanner.nextLine();
                        clientService.cancelOrder(Integer.parseInt(tracker));
                    }
                    break;
                case "6":
                    listProduct.print();
                    break;
                default:
                    System.out.println("Некоррректный ввод");
            }
        }
    }
}