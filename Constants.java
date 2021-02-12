public class Constants {

    public static final String CURRENCY_FORMAT_STRING = "$%.2f.%n";
    public static final String EMPLOYEE_TO_STRING_SEPARATOR = "::";

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
        MANAGER(1), DEPARTMENT_HEAD(2), DIRECTOR(3);

        private int code;

        MANAGEMENT_ROLES(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }
}
