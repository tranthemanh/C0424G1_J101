public abstract class Phone {
    private int id;
    private String phoneName;
    private double price;
    private int quantity;
    private String producer;

    public Phone(int id, String phoneName, double price, int quantity, String producer) {
        this.id = id;
        this.phoneName = phoneName;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public abstract String getI4();

    @Override
    public String toString() {
        return id + "," + phoneName + "," + price + "," + quantity + "," + producer;
    }
}
