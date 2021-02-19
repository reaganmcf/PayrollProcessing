/**
 * Profile object holding name, department, and the date hired of any type of
 * employee
 * 
 * @author Reagan McFarland, Vatche Kafafian
 */
public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    /**
     * Create new Profile with a given name, department, and dateHired
     * 
     * @param name       name of the employee
     * @param department department (as string) the employee works in
     * @param dateHired  date the employee was hired
     */
    public Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    /**
     * Getter for the name of the employee's profile
     * 
     * @return name of the employee's profile
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the department of the employee's profile
     * 
     * @return department of the employee's profile
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Getter for the date hired of the employee's profile
     * 
     * @return date hired of the employee's profile
     */
    public Date getDateHired() {
        return this.dateHired;
    }

    /**
     * Returns a string representation of the profile following the format of
     * "<name>::<dept>::<date hired>"
     * 
     * @return String following the format above
     */
    @Override
    public String toString() {
        String employeeString = "";

        // Append name
        employeeString += this.name + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append department
        employeeString += this.department + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        // Append dateHired
        employeeString += this.dateHired.toString() + Constants.EMPLOYEE_TO_STRING_SEPARATOR;

        return employeeString;
    }

    /**
     * Check if another Profile is equal to the current instance
     * 
     * @return status representing if the current instance is equal to the other
     *         Profile
     */
    @Override
    public boolean equals(Object obj) {
        final int EQUAL = 0;
        if (obj instanceof Profile) {
            Profile objAsProfile = (Profile) obj;
            if (objAsProfile.getName().equals(this.name) && objAsProfile.getDepartment().equals(this.department)
                    && objAsProfile.getDateHired().compareTo(this.dateHired) == EQUAL) {
                return true;
            }
        }
        return false;
    }
}