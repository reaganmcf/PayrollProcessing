public class Fulltime extends Employee {

    private int salary;

    public Fulltime(Profile profile, int salary) {
        super(profile);
        this.salary = salary;
    }

    @Override
    public void calculatePayment() {

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