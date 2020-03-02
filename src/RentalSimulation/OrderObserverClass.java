package RentalSimulation;

public class OrderObserverClass implements OrderObserver {
    public static int countDays =1;
    private static int availableCars = 24;
    private static int profitOfTheDay = 0;
    private  static int netProfit = 0;
    String rental_records;

    public void updateObserver(int day_count,int cars_available,int profit, int totalProfit, String rentals) {
        countDays = day_count;
        availableCars = cars_available;
        profitOfTheDay = profit;
        netProfit = totalProfit;
        rental_records = rentals;
        this.eventAnnouncement();
    }

    public void eventAnnouncement() {

        System.out.println("\t\t\t | Profit made on day "+countDays+" is $"+profitOfTheDay+" |");
        System.out.println("\t\t\t | Total profit by the end of the day "+countDays+" is $"+netProfit+" |");
        if(!rental_records.equalsIgnoreCase("Do not print yet")) {
            String[] records = rental_records.split("###");
            System.out.println("\t\t\t | Total rentals "+records.length+" |");
            System.out.println("\t\t\t | Records from the last " +countDays+"days |");
            for(String record: records) {
                System.out.println(record);
            }
            System.out.println("\t\t\t | Finished simulation! |");
        }
    }
}
