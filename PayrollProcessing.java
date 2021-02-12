import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

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

    private static final String QUIT_MSG = "Payroll Processing Completed.";
    private static final String NO_NEGATIVE_HOURLY_RATE_MSG = "Pay rate  cannot be negative.";
    private static final String NO_NEGATIVE_SALARY_MESSAGE = "Salary cannot be negative";
    private static final String EMPLOYEE_ADDED_MSG = "Employee added.";
    private static final String EMPLOYEE_ALREADY_IN_COMPANY_MSG = "Employee is already in the list.";

    // Input delimiter between commands to extract params
    private final String INPUT_DELIMETER = "\\s";

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

        // Instantiate our scanner and company
        scanner = new Scanner(System.in);

        // Wait for commands
        while (scanner.hasNextLine()) {

            // Fetch the input and instantiate a new tokenizer to process the input
            String rawInput = scanner.nextLine();

            // Check that the input is not empty
            if (rawInput.length() > 0) {
                StringTokenizer tokenizer = new StringTokenizer(rawInput, INPUT_DELIMETER);

                // Extract command out of rawInput
                String rawCommand = tokenizer.nextToken();

                // Command dispatcher, determine which handler to redirect too
                switch (rawCommand) {
                    case CMD_ADD_EMPLOYEE_PARTTIME:
                        addPartimeEmployeeHandler(tokenizer);
                        break;
                    case CMD_ADD_EMPLOYEE_FULLTIME:
                        addFulltimeEmployeeHandler(tokenizer);
                        break;
                    case CMD_ADD_EMPLOYEE_MANAGER:
                        addManagementEmployeeHandler(tokenizer);
                        break;
                    case CMD_REMOVE_EMPLOYEE:
                        removeEmployeeHandler(tokenizer);
                        break;
                    case CMD_CALCULATE_PAYMENTS:
                        calculatePaymentsHandler(tokenizer);
                        break;
                    case CMD_SET_HOURS_FOR_EMPLOYEE_PARTTIME:
                        setHoursForEmployeeHandler(tokenizer);
                        break;
                    case CMD_PRINT_EARNINGS_CURRENT_SEQUENCE:
                        printEarningsHandler(tokenizer);
                        break;
                    case CMD_PRINT_EARNINGS_DATES_ASCENDING:
                        printEarningsDatesAscendingHandler(tokenizer);
                        break;
                    case CMD_PRINT_EARNINGS_GROUP_BY_DEPARTMENT:
                        printEarningsGroupByDepartmentHandler(tokenizer);
                        break;
                    case CMD_QUIT:
                        quitHandler();
                        return;
                    default:
                        invalidCommandHandler(rawCommand);
                        break;
                }
            }
        }
    }

    /**
     * "AP" Command Handler. Handler for the "Adding Parttime Employee" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void addPartimeEmployeeHandler(StringTokenizer tokenizer) {
        // Expecting 4 params, but we have to check
        final int EXPECTED_PARAM_COUNT = 4;
        final int ACTUAL_PARAM_COUNT = tokenizer.countTokens();
        if (ACTUAL_PARAM_COUNT != EXPECTED_PARAM_COUNT) {
            printMismatchedParamsError(EXPECTED_PARAM_COUNT, ACTUAL_PARAM_COUNT);
            return;
        }

        // Extract each param
        String rawName = tokenizer.nextToken();
        String rawDepartment = tokenizer.nextToken();
        String rawDate = tokenizer.nextToken();
        String rawHourlyRate = tokenizer.nextToken();

        Constants.DEPARTMENT_CODES departmentCode;
        Date date = new Date(rawDate);
        double hourlyRate = Double.parseDouble(rawHourlyRate);

        // Check if department is valid
        try {
            departmentCode = Constants.DEPARTMENT_CODES.valueOf(rawDepartment);
        } catch (IllegalArgumentException e) {
            // If we make it here, it isn't valid
            printInvalidDepartmentError(rawDepartment);
            return;
        }

        // Check if date is valid
        if (!date.isValid()) {
            printInvalidDateError(date);
            return;
        }

        // Check if hourly rate is negative
        if (hourlyRate < 0) {
            System.out.println(NO_NEGATIVE_HOURLY_RATE_MSG);
        }

        // Create new employee and attempt to add to the company
        Parttime newEmployee = new Parttime(new Profile(rawName, departmentCode.getCode(), date), hourlyRate);
        boolean addedSuccessfully = company.add(newEmployee);

        if (addedSuccessfully) {
            System.out.println(EMPLOYEE_ADDED_MSG);
        } else {
            System.out.println(EMPLOYEE_ALREADY_IN_COMPANY_MSG);
        }
    }

    /**
     * "AF" Command Handler. Handler for the "Adding Fulltime Employee" commandzz
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void addFulltimeEmployeeHandler(StringTokenizer tokenizer) {

    }

    /**
     * "AM" Command Handler. Handler for the "Adding Management Employee" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void addManagementEmployeeHandler(StringTokenizer tokenizer) {

    }

    /**
     * "R" Command Handler. Handler for the "Remove Employee" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void removeEmployeeHandler(StringTokenizer tokenizer) {

    }

    /**
     * "C" Command Handler. Handler for the "Calculate Payments" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void calculatePaymentsHandler(StringTokenizer tokenizer) {

    }

    /**
     * "S" Command Handler. Handler for the "Set Hours for Employee" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void setHoursForEmployeeHandler(StringTokenizer tokenizer) {

    }

    /**
     * "PA" Command Handler. Handler for the "Print Earning Statements For All
     * Employees" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void printEarningsHandler(StringTokenizer tokenizer) {

    }

    /**
     * "PH" Command Handler. Handler for the "Print Earning Statements For All
     * Employees Ordered by Date Hired" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void printEarningsDatesAscendingHandler(StringTokenizer tokenizer) {

    }

    /**
     * "PD" Command Handler. Handler for the "Print Earning Statements For All
     * Employees Grouped by Deparatment" command
     * 
     * @param tokenizer current StringTokenizer instance containing the command's
     *                  params
     */
    private void printEarningsGroupByDepartmentHandler(StringTokenizer tokenizer) {

    }

    /**
     * "Q" Command Handler. Handler for the "Quit" command
     */
    private void quitHandler() {
        scanner.close();
        System.out.println(QUIT_MSG);
    }

    /**
     * Invalid Command Handler
     * 
     * @param command Command sent by the user that didn't match any supported
     *                commands
     */
    private void invalidCommandHandler(String command) {
        final String INVALID_CMD_MSG_PREFIX = "Command '";
        final String INVALID_CMD_MSG_SUFFIX = "' not supported!";
        System.out.println(INVALID_CMD_MSG_PREFIX + command + INVALID_CMD_MSG_SUFFIX);
    }

    /**
     * Mismatched params error handler.
     */
    public void printMismatchedParamsError(int expected_param_count, int actual_param_count) {

    }

    /**
     * Invalid department error handler
     */
    public void printInvalidDepartmentError(String invalidDepartment) {
        System.out.println(invalidDepartment + " is not a valid department code.");
    }

    /**
     * Invalid date error handler
     */
    public void printInvalidDateError(Date invalidDate) {
        System.out.println(invalidDate.toString() + " is not a valid date!");
    }
}
