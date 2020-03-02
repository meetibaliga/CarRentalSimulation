package RentalSimulation;

public class childSeat extends addOnsCost {
    Catalog inventory;
    public childSeat(Catalog inventory) {
        this.inventory=inventory;
    }
    @Override
    public int getCost() {
        return inventory.getChildSeatCost();
    }
}

