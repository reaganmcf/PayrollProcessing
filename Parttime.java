/**
 * Parttime object representing a Partime employee that can be in the company.
 * Extends the Employee class and overrides specific methods that have specific
 * implementations for Parttime Employees
 * 
 * @author Reagan McFarland
 */
public class Parttime extends Employee {

    private double hourlyWage;
    private int workingHours;

    /**
     * Create new Parttime Employee given a profile and an hourly wage
     * 
     * @param profile    instance of the employee's Profile object
     * @param hourlyWage hourly wage of an employee
     */
    public Parttime(Profile profile, double hourlyWage) {
        super(profile);
        this.hourlyWage = hourlyWage;
    }

    /**
     * Set the working hours for the parttime employee
     * 
     * @param workingHours new working hours
     */
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    /**
     * Get the working hours for the parttime employee
     * 
     * @return
     */
    public int getWorkingHours() {
        return this.workingHours;
    }

    /**
     * Calculate and set the payment for the parttime employee
     */
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

    /**
     * Returns a string representation of the parttime employee following the fomrat
     * of "<name>::<dept>::<date hired>::<payment>::<emp type>::<hourly
     * rate>::<hours worked>"
     * 
     * @return String following the format mentioned above
     */
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

    /**
     * TODO
     */
    @Override
    public boolean equals(Object e) {
        return super.equals(e);
    }
}