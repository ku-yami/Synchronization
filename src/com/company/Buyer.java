package com.company;

public class Buyer implements Runnable{
    private final Dealer dealer;

    public Buyer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public void run() {
        System.out.printf("Покупатель %s пришел за автомобилем\n", Thread.currentThread().getName());
        dealer.sellCar();
    }
}
