public class Parttime extends Employee {

    private double hourlyWage;
    private double workingHours;

    public Parttime(String firstname, String lastname, Constants.DEPARTMENT_CODES department, Date dateHired,
            double hourlyWage) {
        super(firstname, lastname, department, dateHired);
        this.hourlyWage = hourlyWage;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public void calculatePayment() {

    }
}