package ru.netology;

public interface Order {
    void ordering();

    void cancelOrder(int trackerForRemove);
}
