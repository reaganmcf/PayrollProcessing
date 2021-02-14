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

    public double getWorkingHours() {
        return this.workingHours;
    }

    @Override
    public void calculatePayment() {
        // Reset payment
        this.setPayment(0);

        // The first 80 hours are charged at normal rate
        double normalPay = this.hourlyWage * Math.min(Constants.OVERTIME_HOURS_THRESHOLD, this.workingHours);

        // Any hours over 80 are charged at overtime rate
        double overtimeHours = Math.max(0, this.workingHours - Constants.OVERTIME_HOURS_THRESHOLD);
        double overtimePay = overtimeHours * this.hourlyWage * Constants.OVERTIME_PAY_RATE;

        // Combine and call the setter
        double totalPay = normalPay + overtimePay;
        this.setPayment(totalPay);
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