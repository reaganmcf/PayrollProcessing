public class Parttime extends Employee {

    private double hourlyWage;
    private double workingHours;

    public Parttime(Profile profile, double hourlyWage) {
        super(profile);
        this.hourlyWage = hourlyWage;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    void calculatePayment() {

    }

    @Override
    public String toString() {
        return super.toString() + "parttime";
    }

    @Override
    public boolean equals(Object e) {
        return false;
    }
}