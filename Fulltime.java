public class Fulltime extends Employee {

    private int salary;

    public Fulltime(Profile profile, int salary) {
        super(profile);
        this.salary = salary;
    }

    @Override
    public void calculatePayment() {
        // Reset payment
        this.setPayment(0);

        // Payment for each pay period is equal to annual salary divided by the pay
        // periods in a year
        double newPayment = (double) this.salary / Constants.FULL_TIME_PAY_PERIODS_IN_YEAR;
        this.setPayment(newPayment);
    }

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

    @Override
    public boolean equals(Object e) {
        return false;
    }
}