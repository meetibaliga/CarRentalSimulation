package RentalSimulation;

public class CatalogFactory {
    public Catalog createCarInventory(String carTypes, String customerName) {
        if(carTypes == null) {
            return null;
        }
        if(carTypes.equalsIgnoreCase("Economy")) {
            return new RentalSimulation.Economy(customerName);
        }
        else if(carTypes.equalsIgnoreCase("Standard")) {
            return new RentalSimulation.Standard(customerName);
        }
        else if(carTypes.equalsIgnoreCase("Luxury")) {
            return new RentalSimulation.Luxury(customerName);
        }
        else if(carTypes.equalsIgnoreCase("Suv")) {
            return new RentalSimulation.SUV(customerName);
        }
        else if(carTypes.equalsIgnoreCase("Minivan")) {
            return new RentalSimulation.Minivan(customerName);
        }
        return null;

    }

}

