public abstract class Employee {

    private Profile profile;
    private double payment = 0.0;

    public Employee(Profile profile) {
        this.profile = profile;
    }

    abstract void calculatePayment();

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