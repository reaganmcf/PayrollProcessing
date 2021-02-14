/**
 * Employee Superclass used by Fulltime, Parttime, and Management Employees
 * 
 * @author Reagan McFarland
 */
public class Employee {

    private Profile profile;
    private double payment = 0.0;

    /**
     * Creates a new Employee instance with a given profile
     * 
     * @param profile Profile instance containing name, deptartment, and dateHired
     *                for an employee
     */
    public Employee(Profile profile) {
        this.profile = profile;
    }

    /**
     * Getter for the name of an employee
     * 
     * @return Name of employee as String
     */
    public String getName() {
        return this.profile.getName();
    }

    /**
     * Getter for the department of an employee
     *
     * @return Department of employee as String
     */
    public String getDepartment() {
        return this.profile.getDepartment();
    }

    /**
     * Getter for the date hired of an employee
     * 
     * @return Date object representing the date on which the employee was hired
     */
    public Date getDateHired() {
        return this.profile.getDateHired();
    }

    /**
     * Getter for the payment of an employee
     * 
     * @return Payment for the employee
     */
    public double getPayment() {
        return this.payment;
    }

    /**
     * Setter for the payment of an employee
     * 
     * @param newPayment New payment to set payment to
     */
    public void setPayment(double newPayment) {
        this.payment = newPayment;
    }

    /*
     * Calculate payments must be implemented in all subclasses according to their
     * own specific rules
     */
    public void calculatePayment() {
        // Nothing needs to go here, because all subclasses will override
    };

    /**
     * equals @Override method for Employee
     * 
     * @param e Object to compare against
     * @return boolean whether or not the employees are equal
     */
    @Override
    public boolean equals(Object e) {
        // Check if object is even an employee
        if (!(e instanceof Employee)) {
            return false;
        }

        // Object casted to employee
        Employee objectAsEmployee = (Employee) e;

        // Check profile
        // return this.profile.equals(e.)
        return false;

    }

    /**
     * toString @Override method for Employee
     * 
     * @return String object following the format <name>::<dept>::<date>
     */
    @Override
    public String toString() {
        String employeeString = "";

        // Append name
        employeeString += this.profile.getName() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append department
        employeeString += this.profile.getDepartment() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append dateHired
        employeeString += this.profile.getDateHired() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append payment
        employeeString += "Payment " + String.format(Constants.CURRENCY_FORMAT_STRING, this.payment)
                + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        return employeeString;
    }
}