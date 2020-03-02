package RentalSimulation;

import java.util.*;

public class Luxury extends Catalog {

    private static List<String> usedCars = new ArrayList<>();
    private static int count = 4;
    private String name;
    private String car;

    private int cost;
    private int cSeatCost;
    private int GPSCost;
    private int satelliteCost;

    private boolean f = false;
    private static Map<String, Integer> numberOfDays = new HashMap<>();

    public enum Cars{
        L1, L2, L3, L4
    }

    public Luxury() {
        for (String key : numberOfDays.keySet()) {
            if ((numberOfDays.get(key) != 0)) {
                numberOfDays.replace(key, numberOfDays.get(key) - 1);
            }
        }
    }

    public Luxury(String name) {
        super();
        for (String key : numberOfDays.keySet()) {
            if (numberOfDays.get(key) == 0) {
                usedCars.remove(key);

            }
        }
        this.cSeatCost = 200;
        this.GPSCost = 300;
        this.satelliteCost = 320;
        this.name = name;
    }

    public String getRandomNumber(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public String getList() {

        System.out.println("Luxury Cars are: ");
        List<String> list = new ArrayList<>();
                                                                                    // add 4 element in ArrayList
        list.add("L1");
        list.add("L2");
        list.add("L3");
        list.add("L4");

        if (usedCars.size() < 4) {
            for (Cars c : Cars.values()) {
                System.out.println(c.name());
            }
        } else {
            if (usedCars.size() == 4) {                                              // Check if limit has reached
                return "We have run out of cars in this category";
            }
        }

        String carRented = getRandomNumber(list);
        while (!f) {
            if (usedCars.contains(carRented)) {                                 // If car selected has already been rented
                System.out.println("Please rent some other car");
                carRented = getRandomNumber(list);
            } else {
                f = true;
            }
        }
        usedCars.add(carRented);
        return carRented;
    }

    @Override                                                           // Override Inventory methods
    public void setCost() {
        this.cost = 1000;
    }

    public void update_days(String carSelection, int days) {
        numberOfDays.put(carSelection, days);
    }

    @Override

    public int getCost() {
        return cost;
    }

    @Override

    public List<String> getCarsBeingUsed() {
        return usedCars;
    }

    @Override

    public int getGPSModuleCost() {
        return this.GPSCost;
    }

    @Override

    public int getSatelliteRadioCost() {
        return this.satelliteCost;
    }

    @Override

    public int getChildSeatCost() {
        return this.cSeatCost;
    }

}