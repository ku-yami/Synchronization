package com.company;

public class Producer implements Runnable {
    private final int ASSEMBLY_TIME = 1000;
    private final int maxProducedCars;
    private final Dealer carDealer;

    public Producer(Dealer carDealer, int maxProducedCars) {
        this.carDealer = carDealer;
        this.maxProducedCars = maxProducedCars;
    }

    @Override
    public void run() {
        int producedCars = 0;
        while (producedCars < maxProducedCars) {
            try {
                System.out.println("Производитель производит автомобиль");
                Thread.sleep(ASSEMBLY_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            producedCars++;
            System.out.printf("Производитель выпустил новый автомобиль #%d\n", producedCars);
            carDealer.getNewCar(new Car());
        }
        System.out.println("Производитель выпустил максимальное количество автомобилей");
    }

    public void interrupt() {
        Thread.currentThread().interrupt();
    }
}
