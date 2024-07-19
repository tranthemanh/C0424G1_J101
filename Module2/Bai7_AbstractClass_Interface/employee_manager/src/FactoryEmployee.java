public class FactoryEmployee extends Employee{
    private int factoryID;
    private String type;

    public FactoryEmployee(int id, String name, String phone, String position, int factoryID, String type){
        super(id, name, phone, position);
        this.factoryID = factoryID;
        this.type = type;
    }

    public int getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(int factoryID) {
        this.factoryID = factoryID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+
                "FactoryEmployee{" +
                "factoryID=" + factoryID +
                ", type='" + type + '\'' +
                '}';
    }
}
