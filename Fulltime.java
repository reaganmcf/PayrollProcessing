public class Fulltime extends Employee {

    protected int salary;

    public Fulltime(Profile profile, int salary) {
        super(profile);
        this.salary = salary;
    }

    @Override
    public void calculatePayment() {
        // Reset payment
        this.setPayment(0);

        // Payment for each pay period is equal to annual salary divided by the pay
        // periods in a year
        double newPayment = (double) this.salary / Constants.FULL_TIME_PAY_PERIODS_IN_YEAR;
        this.setPayment(newPayment);
    }

    @Override
    public String toString() {
        return super.toString() + "fulltime";
    }

    @Override
    public boolean equals(Object e) {
        return false;
    }
}