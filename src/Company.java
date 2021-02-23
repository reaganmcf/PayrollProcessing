/**
 * Company class implements all of the commands sent from PayrollProcessing
 * Company size is by default set to 4 via the INITIAL_EMPLOYEE_SIZE constant
 * variable.
 * 
 * @author Reagan McFarland, Vatche Kafafian
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;

    private static int NOT_FOUND = -1;

    // Initial size of our Company, also the factor by which we increase the emplist
    // whenever it is full
    private int INITIAL_EMPLOYEE_SIZE = 4;

    /**
     * No parameter constructor
     */
    public Company() {
        emplist = new Employee[INITIAL_EMPLOYEE_SIZE];
        this.numEmployee = 0;
    }

    /**
     * 
     * @param employee Employee we are trying to find
     * @return -1 if not found, otherwise the index in the list
     */
    private int find(Employee employee) {
        Employee tempEmployee = null;
        // Traverse each employee in the list of employees
        for (int i = 0; i < this.numEmployee; i++) {
            tempEmployee = emplist[i];
            // If the employee is equal to an employee in the array,
            // return the index i
            if (employee.equals(tempEmployee)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Increase the size of the emplist array by INITIAL_EMPLOYEE_SIZE
     */
    private void grow() {
        // Set temporary array to emplist array
        Employee[] tempEmpList = emplist;
        // emplist is resized by the initial emplist size of 4
        emplist = new Employee[this.numEmployee + INITIAL_EMPLOYEE_SIZE];
        // copy all the employees in the tempEmpList array in to the resized emplist
        // array
        for (int i = 0; i < this.numEmployee; i++) {
            emplist[i] = tempEmpList[i];
        }
    }

    /**
     * Adds an employee to the employee list, grow if there is not enough space
     * 
     * @param employee Employee we are adding to emplist
     * @return true if an employee was able to be added, false otherwise
     */
    public boolean add(Employee employee) {
        // Check if an employee already is in the company
        if (find(employee) != NOT_FOUND)
            return false;

        // Traverse the emplist array and check if there are empty slots in the array
        for (int i = 0; i < emplist.length; i++) {
            // If a slot is empty, the Employee can be inserted into the array
            if (emplist[i] == null) {
                emplist[i] = employee;
                this.numEmployee++;
                return true;
            }
        }

        // If we made it here, we need to grow the company and then add
        grow();
        add(employee);
        return true;
    }

    /**
     * Removes an employee from the employee list
     * 
     * @param employee Employee we are removing from emplist
     * @return true if the employee was able to be removed, false if the employee is
     *         not found in the list
     */
    public boolean remove(Employee employee) {
        // has to call .find()
        // Call the find method to check if the employee is in emplist
        int empListIndex = find(employee);
        if (empListIndex == NOT_FOUND) {
            return false;
        }
        // Traverse emplist from the index to be removed and shift each employee to the
        // left
        for (int i = empListIndex; i < this.numEmployee - 1; i++) {
            emplist[i] = emplist[i + 1];
        }
        // books[this.numBooks-1] = null;
        this.numEmployee--;
        emplist[this.numEmployee] = null;

        return true;
    }

    /**
     * Set hours for parttime employees
     * 
     * @param employee Employee that is getting their hours set
     * @return false if the employee if the given employee is not found or if the
     *         employee is not parttime, true otherwise.
     */
    public boolean setHours(Employee employee) {
        // get the index of the employee in emplist
        int idx = find(employee);
        // return false if the employee is not found
        if (idx < 0) {
            return false;
        }

        // cannot set hours if employee isn't parttime
        if (employee instanceof Parttime == false) {
            return false;
        }

        // get the employee in the list
        Parttime emp = (Parttime) this.emplist[idx];
        // cast employee passed into setHours as type Parttime
        Parttime temp = (Parttime) employee;

        // hours cannot be over the max limit
        if (temp.getWorkingHours() > Constants.MAX_HOURS_IN_PAY_PERIOD)
            return false;

        // hours cannot be negative
        if (temp.getWorkingHours() < 0)
            return false;

        // set the working hours of the employee found in the list
        emp.setWorkingHours(temp.getWorkingHours());

        return true;
    }

    /**
     * Process the payments of each employee in emplist
     */
    public void processPayments() {
        for (int i = 0; i < this.numEmployee; i++) {
            this.emplist[i].calculatePayment();
        }
    }

    /**
     * Print each employee's earning statement in emplist by the current sequence.
     */
    public void print() {
        // Check if company is empty
        for (int i = 0; i < this.numEmployee; i++) {
            System.out.println(this.emplist[i]);
        }
    }

    /**
     * Print each employee's earning statement by department number.
     */
    public void printByDepartment() {
        // Sort employees by departments
        // We will be using bubble sort
        for (int i = 0; i < this.numEmployee - 1; i++) {
            // the last i elements are already in place
            for (int j = 0; j < this.numEmployee - i - 1; j++) {
                // Compare departments
                int dateCompareValue = this.emplist[j].getDepartment().compareTo(this.emplist[j + 1].getDepartment());
                if (dateCompareValue > 0) {
                    // swap
                    Employee temp = this.emplist[j];
                    this.emplist[j] = this.emplist[j + 1];
                    this.emplist[j + 1] = temp;
                }
            }
        }

        // Now that employees are sorted by departments, print them out
        for (int i = 0; i < this.numEmployee; i++) {
            System.out.println(this.emplist[i]);
        }
    }

    /**
     * Print each employee's earning statement by date hired.
     */
    public void printByDate() {

        // Sort employees by date hired
        // We will be using bubble sort
        for (int i = 0; i < this.numEmployee - 1; i++) {
            // the last i elements are already in place
            for (int j = 0; j < this.numEmployee - i - 1; j++) {
                // Compare dates hired
                int dateCompareValue = this.emplist[j].getDateHired().compareTo(this.emplist[j + 1].getDateHired());
                if (dateCompareValue > 0) {
                    // swap
                    Employee temp = this.emplist[j];
                    this.emplist[j] = this.emplist[j + 1];
                    this.emplist[j + 1] = temp;
                } else if (dateCompareValue == 0) {
                    // If the dates are the same, then we need to compare the employee names
                    if (this.emplist[j].getName().compareTo(this.emplist[j + 1].getName()) > 0) {
                        // swap
                        Employee temp = this.emplist[j];
                        this.emplist[j] = this.emplist[j + 1];
                        this.emplist[j + 1] = temp;
                    }
                }
            }
        }

        // Now that employees are sorted by dates hired, print them out
        for (int i = 0; i < this.numEmployee; i++) {
            System.out.println(this.emplist[i]);
        }

    }

    /**
     * Check if there are no employees in the company
     * 
     * @return boolean status representing whether or not the company is empty
     */
    public boolean isEmpty() {
        return this.numEmployee == 0;
    }
}