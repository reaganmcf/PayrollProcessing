/**
 * Fulltime object representing a fulltime employee that can be in the company.
 * Extends the Employee class and overrides specific methods that have specific
 * implementations for Fulltime Employees
 * 
 * @author Reagan McFarland
 */
public class Fulltime extends Employee {

    private int salary;

    /**
     * Create new Fulltime Employee given a profile and salary
     * 
     * @param profile instance of the employee's Profile object
     * @param salary  annual salary for the fulltime employee
     */
    public Fulltime(Profile profile, int salary) {
        super(profile);
        this.salary = salary;
    }

    /**
     * Calculate and set the payment for the fulltime employee
     */
    @Override
    public void calculatePayment() {
        // Reset payment
        this.setPayment(0);

        // Payment for each pay period is equal to annual salary divided by the pay
        // periods in a year
        double newPayment = (double) this.salary / Constants.FULL_TIME_PAY_PERIODS_IN_YEAR;
        this.setPayment(newPayment);
    }

    /**
     * Returns a string representation of the fulltime employee following the format
     * of "<name>::<dept>::<date hired>::<payment>::<emp type>::Annual Salary
     * <salary>"
     * 
     * @return String following the format mentioned above
     */
    @Override
    public String toString() {
        // Call parent, which builds most of the string
        String employeeString = super.toString();

        // Append Employee Type
        employeeString += Constants.FULLTIME_STR + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append Annual Salary
        float salaryAsFloat = Float.valueOf(this.salary);
        employeeString += Constants.ANNUAL_SALARY_STR + String.format(Constants.CURRENCY_FORMAT_STRING, salaryAsFloat);

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