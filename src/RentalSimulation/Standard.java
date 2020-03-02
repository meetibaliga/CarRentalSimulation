package RentalSimulation;

import java.util.*;

public class Standard extends Catalog {


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

    public enum Cars{
        ST1, ST2, ST3, ST4
    }

    private String car;

    public Standard(String name) {
        super();
        for (String key : numberOfDays.keySet()) {
            if (numberOfDays.get(key) == 0) {
                usedCars.remove(key);

            }
        }
        this.name = name;

        this.cSeatCost = 70;
        this.GPSCost = 120;
        this.satelliteCost = 170;

    }

    public String getList() {

        System.out.println("Standard Cars:");
        List<String> list = new ArrayList<>();

        list.add("ST1");
        list.add("ST2");
        list.add("ST3");
        list.add("ST4");

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

    public Standard() {
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
        this.cost = 600;
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
