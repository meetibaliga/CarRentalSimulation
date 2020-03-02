package RentalSimulation;

import java.util.*;

public class TrackDays {
    // this class keeps track of the available cars and rented cars

    private static List<String> carsInUse = new ArrayList<>(); //list of cars that has been rented
    public TrackDays() {
        RentalSimulation.Economy a = new RentalSimulation.Economy();
        Standard b = new Standard();
        Luxury c = new Luxury();
        SUV d = new SUV();
        Minivan e = new Minivan();

        for(String k : a.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : b.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : c.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : d.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : e.getCarsBeingUsed())
            carsInUse.add(k);
    }

    public List<String> getRemainingCars() {
        List<String> carsList = Arrays.asList("E1", "E2", "E3", "E4", "E5", "E6", "ST1", "ST2", "ST3", "ST4", "L1", "L2", "L3", "L4", "S1", "S2", "S3", "S4", "S5", "S6", "M1", "M2","M3", "M4");
        List<String> result = difference(carsList, carsInUse);  //result will have the available cars.
        return result;
    }
    public <T> List<T> difference(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<T>();
        Set<T> set2 = new HashSet<T>(list2);
        for (T t1 : list1) {
            if( !set2.contains(t1) ) {
                result.add(t1);
            }
        }
        return result;
    }

}


