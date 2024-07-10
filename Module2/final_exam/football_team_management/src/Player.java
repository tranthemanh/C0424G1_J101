import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Player extends Person {
    private int id;
    private int shirtNumber;
    private String position;
    private LocalDate daySign;
    private LocalDate dayExpiration;
    private double dailyWage;

    public Player(int id, String name, LocalDate dob, double height, double weight, int shirtNumber, String position, LocalDate daySign, LocalDate dayExpiration, double dailyWage) {
        super(name, dob, height, weight);
        this.id = id;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.daySign = daySign;
        this.dayExpiration = dayExpiration;
        this.dailyWage = dailyWage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getDaySign() {
        return daySign;
    }

    public void setDaySign(LocalDate daySign) {
        this.daySign = daySign;
    }

    public LocalDate getDayExpiration() {
        return dayExpiration;
    }

    public void setDayExpiration(LocalDate dayExpiration) {
        this.dayExpiration = dayExpiration;
    }

    public double getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(double dailyWage) {
        this.dailyWage = dailyWage;
    }

    public long getDaysWorked() {
        return ChronoUnit.DAYS.between(daySign, dayExpiration) + 1;
    }

    public double calculateSalary() {
        return getDaysWorked() * dailyWage;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Id=" + id + super.toString() +
                ", Shirt Number=" + shirtNumber +
                ", Position='" + position + '\'' +
                ", Day Signed=" + daySign +
                ", Day Expiration=" + dayExpiration +
                ", Daily Wage=" + dailyWage +
                '}';
    }
}
