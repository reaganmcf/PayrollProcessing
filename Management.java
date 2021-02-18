/**
 * Management Employee object representing a fulltime employee that holds a
 * management position that can be in the company. Extends the Fulltime
 * class(and hence, also the Employee class) and overrides specific methods that
 * have specific implementations for Management Employees
 * 
 * @author Reagan McFarland
 */
public class Management extends Fulltime {

    private Constants.MANAGEMENT_ROLES managementRole;

    /**
     * Create new Management Employee given a profile, salary, and management role
     * 
     * @param profile        instance of the employee's Profile object
     * @param salary         annual salary for the employee
     * @param managementRole management role for the employee
     */
    public Management(Profile profile, int salary, Constants.MANAGEMENT_ROLES managementRole) {
        super(profile, salary);
        this.managementRole = managementRole;
    }

    /**
     * Calculate and set the payment for the management employee
     */
    @Override
    public void calculatePayment() {
        // No need to reset payment because it gets reset in the super call
        // Call Fulltime calculatePayment
        super.calculatePayment();

        // Additional Compensation
        double totalCompensation = this.getPayment() + managementRole.getAdditionalCompensation();
        this.setPayment(totalCompensation);
    }

    /**
     * Returns a string representation of the management employee following the
     * format of "<name>::<dept>::<date hired>::<payment>::<emp type>::Annual Salary
     * <salary>::<management role> Compensation <additional compensation>"
     * 
     * @return String following the format mentioned above
     */
    @Override
    public String toString() {
        // Call parent, which builds most of the string
        String employeeString = super.toString() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append Manager Compensation
        employeeString += Constants.MANAGER_COMPENSATION_STR
                + String.format(Constants.CURRENCY_FORMAT_STRING, this.managementRole.getAdditionalCompensation());

        // return total string
        return employeeString;
    }

    /**
     * TODO
     */
    @Override
    public boolean equals(Object e) {
        return false;
    }
}