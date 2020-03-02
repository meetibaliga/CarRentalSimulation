package RentalSimulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Order {

    public HashMap<String, String> order_func(int countDays, int customer_no, int availableCars,
                                              ArrayList<RecordBook> record, boolean bool) {
        //customers and car types are created
        Random random = new Random();

        ArrayList<String> regularCustomers = new ArrayList<>();
        regularCustomers.add("Robert");
        regularCustomers.add("Riley");
        regularCustomers.add("Ryan");
        regularCustomers.add("Reena");

        ArrayList<String> casualCustomers = new ArrayList<>();
        casualCustomers.add("Christina");
        casualCustomers.add("Cameron");
        casualCustomers.add("Cathy");
        casualCustomers.add("Chris");

        ArrayList<String> businessCustomers = new ArrayList<>();
        businessCustomers.add("Bob");
        businessCustomers.add("Billy");
        businessCustomers.add("Bryan");
        businessCustomers.add("Beatrice");

        ArrayList<String> originalCustomerType = new ArrayList<>();
        originalCustomerType.add("Regular");
        originalCustomerType.add("Casual");
        originalCustomerType.add("Business");

        ArrayList<String> noBusinessCustomerType = new ArrayList<>();
        noBusinessCustomerType.add("Regular");
        noBusinessCustomerType.add("Casual");

        ArrayList<String> carTypes = new ArrayList<>();
        carTypes.add("Economy");
        carTypes.add("Standard");
        carTypes.add("Minivan");
        carTypes.add("Suv");
        carTypes.add("Luxury");

        CatalogFactory inventoryFactory = new CatalogFactory();
        carRentalStore carRentalObject = new carRentalStore(inventoryFactory);
        StringBuilder stringBuilder = new StringBuilder();

        if (bool) {
            TrackDays td = new TrackDays();
            List<String> rentCars = new ArrayList<String>();
            rentCars = td.getRemainingCars();
            System.out.println("\t\t\t | DAY "+countDays+" |");
            System.out.println("\t\t\t | Number of cars available in rental shop :"+rentCars.size()+" |");
            System.out.println("\t\t\t | Available car list |");

            for (int i = 0; i < rentCars.size(); i++) {
                System.out.print(rentCars.get(i) + "  ");
//                if (i > 1 && i % 10 == 0) {
//                    System.out.println("\n");
//                }
            }
            System.out.println("\n");
            if (countDays > 1) {
                int k = record.size();
                for (int i = 0; i < k; i++) {
                    System.out.println("Customer Records till present date " +i + record.get(i));
                }
            }
        }

        System.out.println("\t\t\t | Customer Number: " + customer_no + " |");

        String newCustomerType = "";

        if (availableCars < 3) {                // If available cars < 3, no business customers allowed
            System.out.println("Choose the type of customer: Regular or Casual");
            newCustomerType = noBusinessCustomerType.get(random.nextInt(1)); // Random customer type chosen
        } else {
            System.out.println("Choose the type of customer: Regular, Casual, Business"); // Random customer type chosen
            newCustomerType = originalCustomerType.get(random.nextInt(2));
        }

        System.out.println("Hi " + newCustomerType + " customer!");
        String cName = "";
        int carCount = 0;

        if (newCustomerType.equalsIgnoreCase("Regular")) {
            System.out.println("Your name? 1.Robert 2.Riley 3.Ryan 4.Reena");
            cName = regularCustomers.get(random.nextInt(3));                    // Choose any one of the 4 customers
            RegularCustomer customerInfo = new RegularCustomer(cName);
            System.out.println("Hi" + customerInfo.customer_name + "As a regular customer, you are allowed to rent between 1 to 3 cars. How many cars would you like to rent today?");
            carCount += (random.nextInt(2)+1);

        } else {
            if (newCustomerType.equalsIgnoreCase("Casual")) {
                System.out.println("Your name? 1.Christina 2.Cameron 3.Cathy 4.Chris");
                cName = casualCustomers.get(random.nextInt(3));                     // Choose any one of the 4 customers
                CasualCustomer customerInfo = new CasualCustomer(cName);
                System.out.println("Hi " + customerInfo.customer_name+"As a casual customer, you are allowed to rent only 1 car");
                carCount += 1;
            } else {
                if (newCustomerType.equalsIgnoreCase("Business")) {
                    System.out.println("Your name? 1.Bob 2.Billy 3.Bryan 4.Beatrice");
                    cName = businessCustomers.get(random.nextInt(3));               // Choose any one of the 4 customers
                    BusinessCustomer customerInfo = new BusinessCustomer(cName);
                    System.out.println("Hi " + customerInfo.customer_name+"As a business customer, you must rent 3 cars");
                    carCount += 3;
                }
            }
        }
        System.out.println("You are going to rent "+carCount+" number of car(s)");
        String[] carModel = new String[carCount];
        int count = carCount;
        int i = 0;

        int netProfit = 0;
        while (carCount > 0) {

            System.out.println("We have the following categories of car : 1.Economy 2.Standard 3.Luxury 4.Suv 5.Minivan....Which car would you like to rent?");
            carModel[i] = carTypes.get(random.nextInt(4));
            HashMap<String, String> rentalInformation = carRentalObject.carOrder(carModel[i], cName, newCustomerType, record);
            if(rentalInformation.containsKey("no_cars")) {
                //All the cars are rented, therefore user must reselect the category
                // Do nothing; continue;
            } else {
                netProfit += Integer.parseInt(rentalInformation.get("total"));
                stringBuilder.append(rentalInformation.get("record"));
                stringBuilder.append("###");
                i++;
                carCount--;
            }
        }

        int k = record.size();
        for (i = 0; i < k; i++) {
            System.out.println("Record is " + record.get(i));
        }

        HashMap<String, String> netProfitMap = new HashMap<>();
        netProfitMap.put("total_profit", Integer.toString(netProfit));
        netProfitMap.put("count", Integer.toString(count));
        netProfitMap.put("rental_records", stringBuilder.toString());
        return netProfitMap;
    }
}