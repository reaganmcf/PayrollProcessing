public class Management extends Fulltime {

    private Constants.MANAGEMENT_ROLES managementRole;

    public Management(String firstname, String lastname, Constants.DEPARTMENT_CODES department, Date dateHired,
            int salary, Constants.MANAGEMENT_ROLES managementRole) {
        super(firstname, lastname, department, dateHired, salary);
        this.managementRole = managementRole;
    }

    @Override
    public void calculatePayment() {

    }
}