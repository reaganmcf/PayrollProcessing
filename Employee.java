public class Employee extends Profile {

    private Profile profile;

    public Employee(String firstname, String lastname, Constants.DEPARTMENT_CODES department, Date dateHired) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.dateHired = dateHired;
    }

    public void calculatePayment() {

    }

}