package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Dealer {

    private final List<Car> cars;

    public synchronized void getNewCar(Car car) {
        cars.add(car);
        System.out.println("Дилер принял новый автомобиль");
        System.out.println("Всего машин в наличии: " + cars.size());
        notify();
    }

    public Dealer() {
        // Используем синхронизированный лист, чтобы избежать проблем с потоками
        this.cars = Collections.synchronizedList(new ArrayList<>());
    }

    public boolean isCarsAvailable() {
        return cars.size() > 0;
    }

    public synchronized void sellCar() {
        while (!isCarsAvailable()) {

            try {
                System.out.println("Машин нет. Ожидаем поставки");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Дилер продает автомобиль клиенту");
        cars.remove(0);
        System.out.println("Осталось машин в наличии: " + cars.size());
    }
}
