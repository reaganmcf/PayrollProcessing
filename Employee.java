/**
 * Abstract Employee Superclass used by Fulltime, Parttime, and Management
 * Employees
 * 
 * @author Reagan McFarland
 */
public abstract class Employee {

    protected Profile profile;
    protected double payment = 0.0;

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
     * Calculate payments must be implemented in all subclasses according to their
     * own specific rules
     */
    abstract void calculatePayment();

    /**
     * toString @Override method for Employee
     * 
     * @return String object following the format <name>::<dept>::<date>
     */
    @Override
    public String toString() {
        String ret = "";

        // Append name
        ret += this.profile.getName() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append department
        ret += this.profile.getDepartment() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append dateHired
        ret += this.profile.getDateHired() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append payment
        ret += String.format(Constants.CURRENCY_FORMAT_STRING, this.payment) + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        return ret;
    }
}