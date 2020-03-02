package RentalSimulation;

public class GPSModule extends addOnsCost {
    Catalog inventory;
    public GPSModule(Catalog inventory) {
        this.inventory=inventory;
    }
    @Override
    public int getCost() {
        return inventory.getGPSModuleCost();
    }
}