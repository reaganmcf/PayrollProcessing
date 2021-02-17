public class Parttime extends Employee {

    private double hourlyWage;
    private int workingHours;

    public Parttime(Profile profile, double hourlyWage) {
        super(profile);
        this.hourlyWage = hourlyWage;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
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
        // Call parent, which builds most of the string
        String employeeString = super.toString();

        // Append Employee Type
        employeeString += Constants.PARTTIME_STR + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append Hourly Rate
        employeeString += Constants.HOURLY_RATE_STR + String.format(Constants.CURRENCY_FORMAT_STRING, this.hourlyWage)
                + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append hours worked this period
        employeeString += Constants.HOURS_WORKED_THIS_PERIOD_STR + this.workingHours;

        // return total string
        return employeeString;
    }

    @Override
    public boolean equals(Object e) {
        return false;
    }
}