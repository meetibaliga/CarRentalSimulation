package RentalSimulation;

import java.util.*;

public class SUV extends Catalog {

    private static List<String> usedCars = new ArrayList<>();              // ArrayList to hold cars
    private static int count = 4;                                          // Count of cars
    private String name;                                                   // Customer Name
    private String car;

    private int cost;                                                      // Cost to rent an SUV Car
    private int cSeatCost;
    private int GPSCost;
    private int satelliteCost;

    private boolean f = false;
    private static Map<String, Integer> numberOfDays = new HashMap<>();     // Rental Period

    public enum Cars{
        S1, S2, S3, S4, S5, S6                                                     // Define 4 SUV Cars
    }

    public SUV() {
        for (String key : numberOfDays.keySet()) {
            if ((numberOfDays.get(key) != 0)) {
                numberOfDays.replace(key, numberOfDays.get(key) - 1);
            }
        }
    }

    public SUV(String name) {
        super();
        for (String key : numberOfDays.keySet()) {
            if (numberOfDays.get(key) == 0) {
                usedCars.remove(key);

            }
        }

        this.GPSCost = 200;
        this.satelliteCost = 250;
        this.cSeatCost = 150;
        this.name = name;
    }

    public String getRandomNumber(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public String getList() {

        System.out.println("SUV Cars are: ");
        List<String> list = new ArrayList<>();
                                                                        // Add 4 cars in ArrayList
        list.add("S1");
        list.add("S2");
        list.add("S3");
        list.add("S4");
        list.add("S5");
        list.add("S6");

        if (usedCars.size() < 6) {
            for (Cars c : Cars.values()) {
                System.out.println(c.name());
            }
        } else {
            if (usedCars.size() == 6) {                                 // Check if limit has reached
                return "We have run out of cars in this category";
            }
        }

        String carRented = getRandomNumber(list);
        while (!f) {
            if (usedCars.contains(carRented)) {                         // If car selected has already been rented
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
        this.cost = 800;
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