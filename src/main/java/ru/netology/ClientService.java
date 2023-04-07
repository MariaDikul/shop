package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientService implements Basket, Order, Printer {
    protected List<Product> basket;
    protected List<Product> removeBasket;
    List<Integer> trackerList = new ArrayList<>();
    Random random = new Random();

    public ClientService() {
        basket = new ArrayList<>();
    }

    public List<Product> getBasket() {
        return basket;
    }

    public List<Integer> getTrackerList() {
        return trackerList;
    }

    public void addToBasket(List<Product> listProduct, String shoppingList) {
        String[] shoppingListArr = shoppingList.split(" ");
        for (String productId : shoppingListArr) {
            for (Product product : listProduct) {
                if (product.getProductId().equals(productId)) {
                    basket.add(product);
                }
            }
        }
    }

    public void removeFromBasket(String removeList) {
        String[] removeListArr = removeList.split(" ");
        List<Product> basketIt = new ArrayList<>(basket);
        for (String productId : removeListArr) {
            for (Product product : basketIt) {
                if (product.getProductId().equals(productId)) {
                    basket.remove(product);
                }
            }
        }

    }

    public void print() {
        if (basket.isEmpty()) {
            System.out.println("Ваша корзина пуста");
        } else {
            System.out.println("Ваша козина:");
            for (Product product : basket) {
                System.out.println(product);
            }
        }
    }

    public void ordering() {
        int tracker = random.nextInt(100000);
        trackerList.add(tracker);
        removeBasket = basket;
        basket = new ArrayList<>();
        System.out.println("Заказ офрмлен и уже отправляется к вам! \n Номер вашего заказа: " + tracker);
    }

    public void cancelOrder(int trackerForRemove) {
        List<Integer> trackerListIt = new ArrayList<>(trackerList);
        for (int tracker : trackerListIt) {
            if (tracker == trackerForRemove) {
                trackerList.remove((Object) tracker);
                System.out.println("Заказ номер " + trackerForRemove + " отменен. Вы можете продолжить покупки");
                basket = removeBasket;
            } else {
                System.out.println("Заказа с таким номером не существует");
            }
        }
    }

}
