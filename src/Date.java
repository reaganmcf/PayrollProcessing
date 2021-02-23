import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Custom Date implemention supporting day, month, and year. It does not support
 * any smaller units of time such as seconds, minutes, hours, etc. Implements
 * the Comparable interface in order for easy comparison against dates to
 * determine which date is before
 * 
 * @author Reagan McFarland, Vatche Kafafian
 */
public class Date implements Comparable<Date> {

    // Constants used during isValid()
    public static final int MIN_YEAR = 1900;
    public static final int MIN_MONTH = 0;
    public static final int MAX_MONTH = 11;
    public static final int MIN_DAY = 0;
    public static final int MAX_DAY = 31;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;
    public static final int STANDARD_MONTH_MAX_DAY = 30;
    public static final int LEAP_YEAR_FEBRUARY_MAX_DAYS = 29;
    public static final int NON_LEAP_YEAR_FEBRUARY_MAX_DAYS = 28;
    public static final int MAX_SINGLE_DIGIT = 9;

    private int year;
    private int month;
    private int day;

    /**
     * Create date object
     * 
     * @param date date in mm/dd/yyyy format
     */
    public Date(String date) {

        // Extract params from tokens
        StringTokenizer tokenizer = new StringTokenizer(date, "/");

        // Month
        // Month is stored as a range of 0-11, so we need to subtract one
        String rawMonth = tokenizer.nextToken();
        this.month = Integer.parseInt(rawMonth) - 1;

        // Day
        String rawDay = tokenizer.nextToken();
        this.day = Integer.parseInt(rawDay);

        // Year
        String rawYear = tokenizer.nextToken();
        this.year = Integer.parseInt(rawYear);
    }

    /**
     * Create date object equal to today's date
     */
    public Date() {
        // Access util.Calendar to get todays date
        Calendar calendar = Calendar.getInstance();

        // Get month
        this.month = calendar.get(Calendar.MONTH);

        // Get day
        this.day = calendar.get(Calendar.DATE);

        // Get year
        this.year = calendar.get(Calendar.YEAR);
    }

    /**
     * Return date as string following format of mm/dd/yyyy
     * 
     * @return mm/dd/yyyy String
     */
    @Override
    public String toString() {
        String dateString = "";

        // Append mm/
        // We store month as a range of 0-11, so we need to add one
        dateString += (this.month + 1) + "/";

        // Append dd/
        dateString += this.day + "/";

        // Append yyyy
        dateString += this.year;

        return dateString;
    }

    /**
     * Determines whether the date stored in member params is a valid date
     * 
     * @return whether or not the date is valid
     */
    public boolean isValid() {
        // Check if year is less than 1900
        if (this.year < Date.MIN_YEAR)
            return false;

        // Check if month is not between 0-11
        if (this.month < Date.MIN_MONTH || this.month > Date.MAX_MONTH)
            return false;

        // Check if day is not between 0-31
        if (this.day < Date.MIN_DAY || this.day > Date.MAX_DAY)
            return false;

        // Get todays date via Calendar API
        Calendar calendar = Calendar.getInstance();
        int todaysYear = calendar.get(Calendar.YEAR);
        int todaysMonth = calendar.get(Calendar.MONTH);
        int todaysDay = calendar.get(Calendar.DATE);

        // Check date is in the future
        if (this.year > todaysYear)
            return false;
        if (this.year == todaysYear && this.month > todaysMonth)
            return false;
        if (this.year == todaysYear && this.month == todaysMonth && this.day > todaysDay) {
            return false;
        }

        // If April, June, September, or November, we can't have more than 30 days
        if (this.month == Calendar.APRIL || this.month == Calendar.JUNE || this.month == Calendar.SEPTEMBER
                || this.month == Calendar.NOVEMBER) {
            if (this.day > Date.STANDARD_MONTH_MAX_DAY)
                return false;
        }

        // If February, we can't have more than 28 if normal year, no more than 29 if
        // leap year
        if (this.month == Calendar.FEBRUARY) {
            /**
             * To Determine if we are in a leap year, follow these steps:
             * 
             * 1. If the year is evenly divisible by 4, go to step 2. Otherwise, go to step
             * 5 2. If the year is evenly divisible by 100, go to step 3. Otherwise, go to
             * step 4 3. If the year is evently divisible by 400, go to step 4. Otherwise,
             * go to stpe 5 4. This year is a leap year 5. This year is not a leap year
             */
            boolean isLeapYear = false;
            if (this.year % Date.QUADRENNIAL == 0) {
                if (this.year % Date.CENTENNIAL == 0) {
                    if (this.year % Date.QUARTERCENTENNIAL == 0) {
                        isLeapYear = true;
                    }
                } else {
                    isLeapYear = true;
                }
            }

            if (isLeapYear) {
                // February can't have more than 29 days in leap year
                if (this.day > Date.LEAP_YEAR_FEBRUARY_MAX_DAYS)
                    return false;
            } else {
                // February can't have more than 28 days in normal year
                if (this.day > Date.NON_LEAP_YEAR_FEBRUARY_MAX_DAYS)
                    return false;
            }
        }

        return true;
    }

    /**
     * compareTo inherited method from Comparable interface Compare to another Date
     * 
     * @param date Date object we are comparing against
     * @return returns -1 if less than, 0 if equal, and +1 if greater
     */
    @Override
    public int compareTo(Date date) {
        final int LESS_THAN = -1;
        final int EQUAL = 0;
        final int GREATER_THAN = 1;

        // Compare years
        if (this.year < date.year) {
            return LESS_THAN;
        } else if (this.year > date.year) {
            return GREATER_THAN;
        } else {
            // Years are the same, have to check month now
            if (this.month < date.month) {
                return LESS_THAN;
            } else if (this.month > date.month) {
                return GREATER_THAN;
            } else {
                // Months are the same, have to check day now
                if (this.day < date.day) {
                    return LESS_THAN;
                } else if (this.day > date.day) {
                    return GREATER_THAN;
                } else {
                    // If we make it here then year, month, and day are all the same
                    return EQUAL;
                }
            }
        }
    }
}
