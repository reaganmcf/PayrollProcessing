/**
 * Global constants to be used across the entire project, including enum
 * definitions
 * 
 * @author Reagan McFarland
 */
public class Constants {
    public static final String CURRENCY_FORMAT_STRING = "$%,.2f";
    public static final String EMPLOYEE_TO_STRING_SEPARATOR = "::";
    public static final int MAX_HOURS_IN_PAY_PERIOD = 100;
    public static int FULL_TIME_PAY_PERIODS_IN_YEAR = 26;
    public static int OVERTIME_HOURS_THRESHOLD = 80;
    public static double OVERTIME_PAY_RATE = 1.5;
    public static String ANNUAL_SALARY_STR = "Annual Salary ";
    public static String HOURLY_RATE_STR = "Hourly Rate ";
    public static String HOURS_WORKED_THIS_PERIOD_STR = "Hours worked this period: ";
    public static String MANAGER_COMPENSATION_STR = "Manager Compensation ";
    public static String FULLTIME_STR = "FULL TIME";
    public static String PARTTIME_STR = "PART TIME";

    private static int MANAGER_YEARLY_BONUS = 5000;
    private static int DEPARTMENT_HEAD_YEARLY_BONUS = 9500;
    private static int DIRECTOR_YEARLY_BONUS = 12000;

    private static final String NO_MATCHING_DEPT_CODE_MSG = "No matching department code to department enum";
    private static final String NO_MATCHING_MANAGER_ROLE_MSG = "No matching manager role to manager enum";

    /**
     * Enum for the Department Codes
     */
    public static enum DEPARTMENT_CODES {
        CS("CS"), ECE("ECE"), IT("IT");

        private String code;

        DEPARTMENT_CODES(String code) {
            this.code = code;
        }

        /**
         * Get the department code for a department code enum
         * 
         * @return String representation of the department code
         */
        public String getCode() {
            return this.code;
        }

        /**
         * Given a string representation of the department code, attempt to match it to
         * a valid DEPARTMENT_CODES Enum. If it doesn't find a match, throws
         * IllegalArgumentException
         * 
         * @param rawDepartmentCode String representation of the department code
         * @return DEPARTMENT_CODES Enum
         * @throws IllegalArgumentException Gets thrown if no match is found
         */
        static DEPARTMENT_CODES getDepartmentCodeFromString(String rawDepartmentCode) throws IllegalArgumentException {
            switch (rawDepartmentCode) {
                case "CS":
                    return CS;
                case "ECE":
                    return ECE;
                case "IT":
                    return IT;
                default:
                    throw new IllegalArgumentException(NO_MATCHING_DEPT_CODE_MSG);
            }
        }
    }

    /**
     * Enum for Management Roles
     */
    public static enum MANAGEMENT_ROLES {
        MANAGER("1"), DEPARTMENT_HEAD("2"), DIRECTOR("3");

        private String code;

        MANAGEMENT_ROLES(String code) {
            this.code = code;
        }

        /**
         * Get the management code for a management role enum
         * 
         * @return Code for management role
         */
        public String getCode() {
            return this.code;
        }

        /**
         * Given a string representation of the management code, attempt to match it to
         * a valid MANAGEMENT_ROLES Enum. If it doesn't find a match, throws
         * IllegalArgumentException
         * 
         * @param rawManagementRole String representation of the management code
         * @return MANAGEMENT_ROLES Enum
         * @throws IllegalArgumentException Gets thrown if no match is found
         */
        static MANAGEMENT_ROLES getManagementRoleFromString(String rawManagementRole) throws IllegalArgumentException {
            switch (rawManagementRole) {
                case "1":
                    return MANAGER;
                case "2":
                    return DEPARTMENT_HEAD;
                case "3":
                    return DEPARTMENT_HEAD;
                default:
                    throw new IllegalArgumentException(NO_MATCHING_MANAGER_ROLE_MSG);
            }
        }

        /**
         * Calculate the additional compensation a given manager recieves which varies
         * on the management role
         * 
         * @return additional compensation
         */
        public double getAdditionalCompensation() {
            switch (code) {
                case "1":
                    return MANAGER_YEARLY_BONUS / (double) FULL_TIME_PAY_PERIODS_IN_YEAR;
                case "2":
                    return DEPARTMENT_HEAD_YEARLY_BONUS / (double) FULL_TIME_PAY_PERIODS_IN_YEAR;
                default:
                    return DIRECTOR_YEARLY_BONUS / (double) FULL_TIME_PAY_PERIODS_IN_YEAR;
            }
        }
    }
}
