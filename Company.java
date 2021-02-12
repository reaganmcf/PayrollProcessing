public class Company {
    private Employee[] emplist;
    private int numEmployee;

    // Initial size of our Company, also the factor by which we increase the emplist
    // whenever it is full
    private static int INITIAL_EMPLOYEE_SIZE = 4;

    public Company() {
        emplist = new Employee[INITIAL_EMPLOYEE_SIZE];
        this.numEmployee = 0;
    }

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
        return -1;
    }

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

    // check the profile before adding
    public boolean add(Employee employee) {
        // Traverse the emplist array and check if there are empty slots in the array
        for (int i = 0; i < emplist.length; i++) {
            // If a slot is empty, the Employee can be inserted into the array
            if (emplist[i] == null) {
                emplist[i] = employee;
                this.numEmployee++;
                return true;
            }
        }
        grow();
        add(employee);
        return false;
    }

    // maintain the original sequence
    public boolean remove(Employee employee) {
        // has to call .find()
        // Call the find method to check if the employee is in emplist
        int empListIndex = find(employee);
        if (empListIndex == -1) {
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

    public boolean setHours(Employee employee) {
        return false;
    } // set working hours for a part time

    public void processPayments() {
    } // process payments for all employees

    public void print() {
        for (Employee e : emplist) {
            System.out.println(e.toString());
        }
    } // print earning statements for all employees

    public void printByDepartment() {
    } // print earning statements by department

    public void printByDate() {
    } // print earning statements by date hired
}