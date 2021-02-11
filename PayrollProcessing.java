public class PayrollProcessing {

    // Command Identifiers
    private static final String CMD_ADD_EMPLOYEE_PARTTIME = "AP";
    private static final String CMD_ADD_EMPLOYEE_FULLTIME = "AF";
    private static final String CMD_ADD_EMPLOYEE_MANAGER = "AM";
    private static final String CMD_REMOVE_EMPLOYEE = "R";
    private static final String CMD_CALCULATE_PAYMENTS = "C";
    private static final String CMD_SET_HOURS_FOR_EMPLOYEE_PARTTIME = "S";
    private static final String CMD_PRINT_EARNINGS_CURRENT_SEQUENCE = "PA";
    private static final String CMD_PRINT_EARNINGS_DATES_ASCENDING = "PH";
    private static final String CMD_PRINT_EARNINGS_GROUP_BY_DEPARTMENT = "PD";
    private static final String CMD_QUIT = "Q";

    // Input delimiter between commands to extract params
    private final String INPUT_DELIMETER = ",";

    // Scanner is a member because we have to remember to close it later. Gets
    // instantiated inside run()
    private Scanner scanner;

    // Our Company instance. Gets instantiated inside run()
    private Company company;

    /**
     * Runner for the entire project. Waits for commands and acts accordingly,
     * pulling out tokens via StringTokenizer Once it has identified the command,
     * dispatches the command to the appropriate function handler
     */
    public void run() {
        System.out.println("Payroll Processing starts.");
    }
}