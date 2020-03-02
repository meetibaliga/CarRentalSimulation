package RentalSimulation;

import java.util.*;

public class Economy extends Catalog {

    public enum Cars {
        E1, E2, E3, E4, E5, E6
    }

    private static List<String> usedCars = new ArrayList<>();
    private static int count = 6;
    private int cost;
    private int cSeatCost;
    private int GPSCost;
    private int satellitCost;

    private String name;
    private boolean f = false;
    private static Map<String, Integer> numberOfDays = new HashMap<>();

    public Economy() {
        for (String key : numberOfDays.keySet()) {
            if ((numberOfDays.get(key) != 0)) {
                numberOfDays.replace(key, numberOfDays.get(key) - 1);
            }
        }

    }

    public Economy(String customerName) {
        super();
        for (String key : numberOfDays.keySet()) {
            if (numberOfDays.get(key) == 0) {
                usedCars.remove(key);
            }
        }
        this.name = customerName;
        this.cSeatCost = 5;
        this.GPSCost = 10;
        this.satelliteCost = 15;
    }

    @Override
    public String getList() {

        List<String> list = new ArrayList<>();
        // add 5 element in ArrayList
        list.add("E1");
        list.add("E2");
        list.add("E3");
        list.add("E4");
        list.add("E5");
        list.add("E6");

        System.out.println("Cars in Economy are: ");

        if (usedCars.size() < 6) {
            for (Cars c : Cars.values()) {
                System.out.println(c.name());
            }
        } else {
            if (usedCars.size() == 6) {
                return "No cars in this category are available";
            }
        }

        String carRented = getRandomNumber(list);

        while (!f) {
            if (usedCars.contains(carRented.toUpperCase())) {
                System.out.println("Car" + carRented + "is already rented. You can rent some other car");
                carRented = getRandomNumber(list);
            } else {
                f = true;
            }
        }
        usedCars.add(carRented.toUpperCase());
        return carRented;
    }

    public String getRandomNumber(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    @Override
    public void setCost() {
        this.cost = 400;
    }

    public void update_days(String carSelection, int days) {
        numberOfDays.put(carSelection, days);
    }

    @Override

    public int getCost() {
        return cost;
    }

    @Override

    public int getChildSeatCost() {
        return this.cSeatCost;
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

    public List<String> getCarsBeingUsed() {
        return usedCars;

    }
}
