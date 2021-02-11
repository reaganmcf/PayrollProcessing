public class Fulltime extends Employee {

    private int salary;

    public Fulltime(String firstname, String lastname, Constants.DEPARTMENT_CODES department, Date dateHired,
            int salary) {
        super(firstname, lastname, department, dateHired);
        this.salary = salary;
    }

    @Override
    public void calculatePayment() {

    }
}