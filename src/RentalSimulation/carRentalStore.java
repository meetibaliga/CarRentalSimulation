package RentalSimulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class carRentalStore {
    Random random = new Random();
    private RentalSimulation.CatalogFactory inventoryFactory;
    public int customerID;
    public String customerName;
    private int cost;
    private int additional_cost = 0;
    private String carSelection;
    public carRentalStore(RentalSimulation.CatalogFactory inventoryFactory) {
        this.inventoryFactory=inventoryFactory;
    }

    public HashMap<String, String> carOrder(String carTypes, String customerName,String newCustomerType,ArrayList<RecordBook> record) {
        HashMap<String,String> returnMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        RentalSimulation.CatalogFactory inventoryFactory= new RentalSimulation.CatalogFactory();
        RentalSimulation.Catalog inventory = inventoryFactory.createCarInventory(carTypes,customerName);
        carSelection=inventory.getList();
        if (carSelection.contentEquals("No cars in this category are available")) {
            System.out.println("All cars in this category are rented. Select another category");
            returnMap.put("no_cars", "-1");
            return returnMap;
        } else if (carSelection.contentEquals("The car has already been rented")) {
            System.out.println("The car has already been rented.Select another car");
            returnMap.put("zero", "0");
            return returnMap;
        } else {
            System.out.println("You have selected "+carSelection+" for "+customerName);
        }
        System.out.println("How many add ons do you want to include?");
        int count = random.nextInt(2)+1;
        System.out.println("You want to have  "+count + "add ons");
        carRentalStore obj = new carRentalStore(inventoryFactory);
        for(int i=0;i<count;i++) {
            additional_cost=obj.addOnOrder(inventory)+additional_cost;
        }

        int count_Days =0;
        if(newCustomerType.equalsIgnoreCase("Regular")) {
            System.out.println("Since you are a regular customer, you can rent for 3-5 nights. How many nights do you want to rent?");
            count_Days += random.nextInt(2)+3;

        }
        else if(newCustomerType.equalsIgnoreCase("Casual")) {
            System.out.println("Since you are a casual customer, you can rent for 1-3 nights. How many nights do you want to rent?");
            count_Days += random.nextInt(2)+1;
        }
        else if(newCustomerType.equalsIgnoreCase("Business")) {
            System.out.println("Since you are a business customer, you have to rent for 7 nights");
            count_Days += 7;
        }
        System.out.println("Number of nights cars will be rented"+count_Days+"\n");
        System.out.println("SELECTED CAR : "+carSelection);
        inventory.update_days(carSelection, count_Days);
        inventory.setCost();
        cost=inventory.getCost();
        int total =(cost+additional_cost) * count_Days;
        RecordBook crsnew= new RecordBook(customerName,newCustomerType,carSelection,count_Days,total);
        record.add(crsnew);
        //update ledger with new transaction
        stringBuilder.append("[Ledger Record]" + customerName + "(" + newCustomerType +" customer )" + "spent " + total);

        System.out.println("Rental Price for a night is $" + cost);
        System.out.println("Add ons cost for this rental is $"+additional_cost);
        System.out.println("Final cost for your rental $"+total+". Please pay upfront!");


        System.out.println("Transaction updated in record book");
        returnMap.put("total", Integer.toString(total));
        returnMap.put("record", stringBuilder.toString());
        return returnMap;
    }
    public int addOnOrder(RentalSimulation.Catalog inventory) {
        ArrayList<String> addOnOptions = new ArrayList<>();
        addOnOptions.add("1");
        addOnOptions.add("2");
        addOnOptions.add("3");
        System.out.println("Select an add on if you want to : 1. Child Seat 2. GPS Module 3. Satellite Radio Package");
        String addOns = addOnOptions.get(random.nextInt(2));
        System.out.println("Add on selected: "+addOns);
        switch(addOns) {
            case "1":
                inventory = new childSeat(inventory);
                break;
            case "2":
                inventory = new GPSModule(inventory);
                break;
            case "3":
                inventory = new satelliteRadio(inventory);
                break;
        }
        return inventory.getCost();
    }


}



