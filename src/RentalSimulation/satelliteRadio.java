package RentalSimulation;

public class satelliteRadio extends addOnsCost {
    Catalog inventory;
    public satelliteRadio(Catalog inventory) {
        this.inventory=inventory;
    }
    @Override
    public int getCost() {
        return inventory.getSatelliteRadioCost();
    }
}