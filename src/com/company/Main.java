package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int MAX_SALES = 10;
        final int MAX_WAIT_TIME = 2000;

        final Dealer dealer = new Dealer();
        final Producer producer = new Producer(dealer, MAX_SALES);
        final Buyer buyer = new Buyer(dealer);

        // Создаем поток продавца автомобилей
        new Thread(producer).start();

        for (int i = 0; i < MAX_SALES; i++) {
            // Создаем поток покупателя автомобилей
            new Thread(buyer, "Покупатель " + i).start();
            Thread.sleep(MAX_WAIT_TIME);
        }
    }
}
