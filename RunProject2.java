import Constants.DEPARTMENT_CODES;

public class RunProject2 {
    public static void main(String[] args) {
        new PayrollProcessing().run();

        Employee[] emps = new Employee[5];
        emps[0] = new Parttime("Jane", "Doe", Constants.DEPARTMENT_CODES.CS, new Date(), 45.9);
        emps[1] = new Fulltime("Jane", "Doe", Constants.DEPARTMENT_CODES.CS, new Date(), 85000);

    }
}