import org.junit.*;

/**
 * Test Suite for Company.java - Contains tests for Company.add(),
 * Company.remove(), and Company.setHours()
 * 
 * @author Reagan McFarland, Vatche Kafafian
 */
public class CompanyTest {
  Company c;

  /**
   * Test Company.add()
   */
  @Test
  public void testAdd() {
    c = new Company();
    // Create a new Parttime employee and add it to the company
    Assert.assertTrue("Adding Parttime to empty Company should return true", c.add(Constants.TEST_VARS_PARTTIME));
    // Company should not be empty now
    Assert.assertFalse("Company should not be empty after inserting a new employee", c.isEmpty());

    // Adding the same employee should always fail
    Assert.assertFalse("Adding identical Parttime to Company should return false", c.add(Constants.TEST_VARS_PARTTIME));

    // Adding a Management employee should always work
    Assert.assertTrue("Adding a Management employee to the Company should return true",
        c.add(Constants.TEST_VARS_MANAGEMENT));

    // Adding a Fulltime employee should always work
    Assert.assertTrue("Adding a Fulltime employee to the Company should return true",
        c.add(Constants.TEST_VARS_FULLTIME));

    // Adding a Parttime employee with the same profile as a fulltime should fail
    Parttime tempParttime2 = new Parttime(Constants.TEST_VARS_FULLTIME.getProfile(), 2.1);
    Assert.assertFalse("Adding a Parttime with the same profile as another employee should return false",
        c.add(tempParttime2));
  }

  /**
   * Test Company.remove()
   */
  @Test
  public void testRemove() {
    c = new Company();

    // Removing an employee that does exist should always work
    c.add(Constants.TEST_VARS_PARTTIME);
    Assert.assertTrue("Removing an employee that does exist should return true",
        c.remove(Constants.TEST_VARS_PARTTIME));

    // Removing the same employee twice should always fail
    Assert.assertFalse("Removing the same employee twice should always fail", c.remove(Constants.TEST_VARS_PARTTIME));

    // Removing an employee that doesn't exist always fail
    Employee testEmployee = new Employee(Constants.TEST_VARS_PROFILE4);
    Assert.assertFalse("Removing an employee that doesn't exist should return false", c.remove(testEmployee));
  }

  /**
   * Test Company.setHours()
   */
  @Test
  public void testSetHours() {
    c = new Company();

    // Setting valid hours (> 0 and < MAX_HOURS) for an employee that does exist
    // should always work
    c.add(Constants.TEST_VARS_PARTTIME);
    Assert.assertTrue("Setting (valid) hours for employee that exists should return true",
        c.setHours(Constants.TEST_VARS_PARTTIME));

    // Setting valid hours (> 0 and < MAX_HOURS) for employee that doesnt exist
    // should always fail
    c.remove(Constants.TEST_VARS_PARTTIME);
    Assert.assertFalse("Setting (valid) hours for employee that doesn't exst should return false",
        c.setHours(Constants.TEST_VARS_PARTTIME));

    // Setting hours for employee that is a Fulltime object should always fail
    Assert.assertFalse("Setting hours for Fulltime employee should return false",
        c.setHours(Constants.TEST_VARS_FULLTIME));

    // Setting hours for employee that is a Management object should always fail
    Assert.assertFalse("Setting hours for Management employee should return false",
        c.setHours(Constants.TEST_VARS_MANAGEMENT));

    // Setting hours over the maximum amount should always fail
    Constants.TEST_VARS_PARTTIME.setWorkingHours(Constants.MAX_HOURS_IN_PAY_PERIOD + 1);
    c.add(Constants.TEST_VARS_PARTTIME);
    Assert.assertFalse("Setting hours over the maximum amount should return false",
        c.setHours(Constants.TEST_VARS_PARTTIME));

    // Setting hours to a negative value should always fail
    c.remove(Constants.TEST_VARS_PARTTIME);
    Constants.TEST_VARS_PARTTIME.setWorkingHours(-1);
    c.add(Constants.TEST_VARS_PARTTIME);
    Assert.assertFalse("Setting hours to a negative value should return false",
        c.setHours(Constants.TEST_VARS_PARTTIME));
  }
}
