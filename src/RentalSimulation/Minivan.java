package RentalSimulation;

import java.util.*;

public class Minivan extends Catalog {

    //Holds cars already in use
    private static List<String> usedCars = new ArrayList<>();

    private static int count = 4;
    private int cost;

    private String name;
    private boolean f = false;

    //Rental period
    private static Map<String, Integer> numberOfDays = new HashMap<>();

    //Cost of every feature
    private int satelliteCost;
    private int cSeatCost;
    private int GPSCost;

    public enum Cars {
        M1, M2, M3, M4
    }

    public Minivan(String name) {
        super();
        for (String key : numberOfDays.keySet()) {
            if (numberOfDays.get(key) == 0) {
                usedCars.remove(key);
            }
        }
        this.cSeatCost = 50;
        this.name = name;
        this.satelliteCost = 150;
        this.GPSCost = 100;
    }

    public String getList() {

        System.out.println("Minivan Cars:");
        List<String> list = new ArrayList<>();

        list.add("M1");
        list.add("M2");
        list.add("M3");
        list.add("M4");

        if (usedCars.size() < 4) {
            for (Cars c : Cars.values()) {
                System.out.println(c.name());
            }
        } else {
            if (usedCars.size() == 4) {
                return "We have run out of cars in this category";
            }
        }

        String carRented = getRandomNumber(list);
        while (!f) {
            if (usedCars.contains(carRented)) {
                System.out.println("Please rent some other car");
                carRented = getRandomNumber(list);
            } else {
                f = true;
            }
        }
        usedCars.add(carRented);
        return carRented;
    }
    public Minivan() {
        for (String key : numberOfDays.keySet()) {
            if ((numberOfDays.get(key) != 0)) {
                numberOfDays.replace(key, numberOfDays.get(key) - 1);
            }
        }

    }


    public String getRandomNumber(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    @Override
    public void setCost() {
        this.cost = 700;
    }

    public void update_days(String carSelection, int days) {
        numberOfDays.put(carSelection, days);
    }

    @Override

    public int getCost() {
        return cost;
    }

    @Override

    public int getGPSModuleCost() {
        return this.GPSCost;
    }

    @Override

    public List<String> getCarsBeingUsed() {
        return usedCars;

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
