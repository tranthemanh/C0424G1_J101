
public class GenuinePhone extends Phone {
    private int warrantyPeriod;
    private String warrantyScope;

    public GenuinePhone(int id, String phoneName, double price, int quantity, String producer, int warrantyPeriod, String warrantyScope) {
        super(id, phoneName, price, quantity, producer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    @Override
    public String getI4() {
        return toString() + ","+ warrantyPeriod + "," + warrantyScope;
    }
}
