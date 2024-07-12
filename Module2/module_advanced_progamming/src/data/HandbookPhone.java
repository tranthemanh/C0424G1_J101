package data;

public class HandbookPhone extends Phone {
    private String nation;
    private String phoneStatus;

    public HandbookPhone(int id, String name, double price, int quantity, String producer, String nation, String phoneStatus) {
        super(id, name, price, quantity, producer);
        this.nation = nation;
        this.phoneStatus = phoneStatus;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(String phoneStatus) {
        this.phoneStatus = phoneStatus;
    }


    @Override
    public String getI4() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString()+","+nation+","+phoneStatus;
    }
}
