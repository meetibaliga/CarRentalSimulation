package RentalSimulation;

import java.util.ArrayList;
import java.util.List;

public abstract class Catalog {
    /*Car rental inventory*/

    static List<String> usedCars = new ArrayList<>();
    int count = 4;
    String car = "Not Defined";
    int cost = 0;
    int cSeatCost = 0;
    int GPSCost = 0;
    int satelliteCost = 0;

    public abstract int getCost();
    public String getList() {
        return car;
    }

    public List<String> getCarsBeingUsed(){
        return usedCars;
    }
    public void update_days(String customerName, int days) {
    }
    public int getChildSeatCost() {
        return cSeatCost;
    }
    public int getGPSModuleCost() {
        return GPSCost;
    }

    public int getSatelliteRadioCost() {
        return satelliteCost;
    }
    public  void setCost() {

    }
}
