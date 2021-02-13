public class Constants {

    public static final String CURRENCY_FORMAT_STRING = "$%.2f.%n";
    public static final String EMPLOYEE_TO_STRING_SEPARATOR = "::";
    public static final int MAX_HOURS_IN_PAY_PERIOD = 100;

    public static enum DEPARTMENT_CODES {
        CS("CS"), ECE("ECE"), IT("IT");

        private String code;

        DEPARTMENT_CODES(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }

    public static enum MANAGEMENT_ROLES {
        MANAGER("1"), DEPARTMENT_HEAD("2"), DIRECTOR("3");

        private String code;

        MANAGEMENT_ROLES(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }
}
