package RentalSimulation;

interface OrderObserver {
    int countDays =1;
    int availableCars = 24;
    int profitOfTheDay = 0;

    void updateObserver(int x,int y,int z, int p, String q);
    void eventAnnouncement();

}