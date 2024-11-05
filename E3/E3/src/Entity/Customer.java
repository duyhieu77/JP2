package Entity;

public class Customer {
    private int id;
    private String cus_name;
    private String cus_phone;

    public Customer(int id, String cus_name, String cus_phone) {
        this.id = id;
        this.cus_name = cus_name;
        this.cus_phone = cus_phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }
}
