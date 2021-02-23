import org.junit.Test;

import org.junit.Assert;

/**
 * Test Suite for Company.java
 * 
 * @author Reagan McFarland
 */
public class CompanyTest {
  Company c;

  // predefined profiles to run tests on
  Profile profile1 = new Profile("Doe,Jane", "CS", new Date());
  Profile profile2 = new Profile("John,Wick", "IT", new Date("1/1/2020"));
  Profile profile3 = new Profile("Matt,Jones", "ECE", new Date("3/27/2014"));
  Profile profile4 = new Profile("Lily,Chang", "CS", new Date());

  Parttime testParttime = new Parttime(profile1, 21.3);
  Fulltime testFulltime = new Fulltime(profile3, 10000);
  Management testManagement = new Management(profile2, 1000, Constants.MANAGEMENT_ROLES.MANAGER);

  // add
  @Test
  public void testAdd() {
    c = new Company();
    // Create a new Parttime employee and add it to the company
    Assert.assertTrue("Adding Parttime to empty Company should return true", c.add(testParttime));
    // Company should not be empty now
    Assert.assertFalse("Company should not be empty after inserting a new employee", c.isEmpty());

    // Adding the same employee should always fail
    Assert.assertFalse("Adding identical Parttime to Company should return false", c.add(testParttime));

    // Adding a Management employee should always work
    Assert.assertTrue("Adding a Management employee to the Company should return true", c.add(testManagement));

    // Adding a Fulltime employee should always work
    Assert.assertTrue("Adding a Fulltime employee to the Company should return true", c.add(testFulltime));

    // Adding a Parttime employee with the same profile as a fulltime should fail
    Parttime tempParttime2 = new Parttime(testFulltime.getProfile(), 2.1);
    Assert.assertFalse("Adding a Parttime with the same profile as another employee should return false",
        c.add(tempParttime2));
  }

  // remove
  @Test
  public void testRemove() {
    c = new Company();

    // Removing an employee that does exist should always work
    c.add(testParttime);
    Assert.assertTrue("Removing an employee that does exist should return true", c.remove(testParttime));

    // Removing the same employee twice should always fail
    Assert.assertFalse("Removing the same employee twice should always fail", c.remove(testParttime));

    // Removing an employee that doesn't exist always fail
    Employee testEmployee = new Employee(profile4);
    Assert.assertFalse("Removing an employee that doesn't exist should return false", c.remove(testEmployee));
  }

  // setHours
  @Test
  public void testSetHours() {
    c = new Company();

    // Setting valid hours (> 0 and < MAX_HOURS) for an employee that does exist
    // should always work
    c.add(testParttime);
    Assert.assertTrue("Setting (valid) hours for employee that exists should return true", c.setHours(testParttime));

    // Setting valid hours (> 0 and < MAX_HOURS) for employee that doesnt exist
    // should always fail
    c.remove(testParttime);
    Assert.assertFalse("Setting (valid) hours for employee that doesn't exst should return false",
        c.setHours(testParttime));

    // Setting hours for employee that is a Fulltime object should always fail
    Assert.assertFalse("Setting hours for Fulltime employee should return false", c.setHours(testFulltime));

    // Setting hours for employee that is a Management object should always fail
    Assert.assertFalse("Setting hours for Management employee should return false", c.setHours(testManagement));

    // Setting hours over the maximum amount should always fail
    testParttime.setWorkingHours(Constants.MAX_HOURS_IN_PAY_PERIOD + 1);
    c.add(testParttime);
    Assert.assertFalse("Setting hours over the maximum amount should return false", c.setHours(testParttime));

    // Setting hours to a negative value should always fail
    c.remove(testParttime);
    testParttime.setWorkingHours(-1);
    c.add(testParttime);
    Assert.assertFalse("Setting hours to a negative value should return false", c.setHours(testParttime));
  }
}
