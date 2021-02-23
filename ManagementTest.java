import org.junit.*;

/**
 * Test Suite for Management.java - Contains tests for
 * Management.calculatePayment()
 * 
 * @author Reagan McFarland
 */
public class ManagementTest {

  /**
   * Test Management.calculatePayment()
   */
  @Test
  public void testCalculatePayment() {
    double payment, roundedPayment;

    // Constants.TEST_VARS_MANAGEMENT_MANAGER payment should be equal to
    // Constants.TEST_VARS_EXPECTED_MANAGER_PAYMENT
    Constants.TEST_VARS_MANAGEMENT_MANAGER.calculatePayment();
    payment = Constants.TEST_VARS_MANAGEMENT_MANAGER.getPayment();
    // Round to 2 decimal places
    roundedPayment = Math.round(payment * 100.0) / 100.0;
    Assert.assertTrue("Manager's payment should be equal to TEST_VARS_EXPECTED_MANAGER_PAYMENT",
        roundedPayment == Constants.TEST_VARS_EXPECTED_MANAGER_PAYMENT);

    // Constants.TEST_VARS_MANAGEMENT_DEPARTMENT_HEAD payment should be equal to
    // Constants.TEST_VARS_EXPECTED_DEPARTMENT_HEAD_PAYMENT
    Constants.TEST_VARS_MANAGEMENT_DEPARTMENT_HEAD.calculatePayment();
    payment = Constants.TEST_VARS_MANAGEMENT_DEPARTMENT_HEAD.getPayment();
    // Round to 2 decimal places
    roundedPayment = Math.round(payment * 100.0) / 100.0;
    Assert.assertTrue("Department Head's payment should be equal to TEST_VARS_EXPECTED_DEPARTMENT_HEAD_PAYMENT",
        roundedPayment == Constants.TEST_VARS_EXPECTED_DEPARTMENT_HEAD_PAYMENT);

    // Constants.TEST_VARS_MANAGEMENT_DIRECTOR payment should be equal to
    // CONSTANTS.TEST_VARS_EXPECTED_DIRECTOR_PAYMENT
    Constants.TEST_VARS_MANAGEMENT_DIRECTOR.calculatePayment();
    payment = Constants.TEST_VARS_MANAGEMENT_DIRECTOR.getPayment();
    // Round to 2 decimal places
    roundedPayment = Math.round(payment * 100.0) / 100.0;
    Assert.assertTrue(
        "Director's payment should be equal to TEST_VARS_EXPECTED_DEPARTMENT_HEAD_PAYMENT" + roundedPayment,
        roundedPayment == Constants.TEST_VARS_EXPECTED_DIRECTOR_PAYMENT);

  }
}
