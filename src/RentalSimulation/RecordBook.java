package RentalSimulation;
import java.lang.reflect.Field;

public class RecordBook {
    public String customer_name, newCustomerType, car;
    public int days,cost;
    public RecordBook(String customer,String customerType,String car, int days, int cost){
        this.customer_name = customer;
        this.newCustomerType = customerType;
        this.car = car;
        this.days = days;
        this.cost = cost;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");


        //result.append( "{" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            //result.append("\t");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(this) );
                result.append("\t\t");
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
        }
        //result.append("}");

        return result.toString();
    }
    public void printRecord() {
        String rec = this.toString();
        System.out.println("Record is"+rec.toString());

    }

}
