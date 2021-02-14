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
        return super.toString() + "::management";
    }

    @Override
    public boolean equals(Object e) {
        return false;
    }
}