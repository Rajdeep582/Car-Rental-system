package Project;

public class Customer {
    private int Cust_id;
    private String name;


    public Customer(int Custom_id,String name){
        this.Cust_id=Custom_id;
        this.name=name;
    }

    public int getCustom_id() {
        return Cust_id;
    }

    public void setCustom_id(int custom_id) {
        Cust_id = custom_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
