public class DeliveryEmployee extends Employee{
    private String vehicleType;

    public DeliveryEmployee(int id, String name, String phone, String position, String vehicleType) {
        super(id, name, phone, position);
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "vehicleType='" + vehicleType;
    }
}
