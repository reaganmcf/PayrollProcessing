public class Management extends Fulltime {

    private Constants.MANAGEMENT_ROLES managementRole;

    public Management(Profile profile, int salary, Constants.MANAGEMENT_ROLES managementRole) {
        super(profile, salary);
        this.managementRole = managementRole;
    }

    @Override
    public void calculatePayment() {
        // No need to reset payment because it gets reset in the super call
        // Call Fulltime calculatePayment
        super.calculatePayment();

        // Additional Compensation
        System.out.println(this.managementRole.getCode());
        double totalCompensation = this.getPayment() + managementRole.getAdditionalCompensation();
        this.setPayment(totalCompensation);
    }

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

    @Override
    public boolean equals(Object e) {
        return false;
    }
}