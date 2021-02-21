import org.junit.Test;
import org.junit.Assert;

/**
 * Test Suite for Company.java
 * 
 * @author Reagan McFarland
 */
public class CompanyTest {
  // add
  @Test
  public void testAdd() {
    // create new company
    Company c = new Company();

    // Create a new PartTime employee and add it to the company
    Parttime testPartTime = new Parttime(new Profile("Doe,Jane", "CS", new Date()), 21.3);
    Assert.assertTrue("Adding PartTime to empty Company", c.add(testPartTime));
    // Company should not be empty now
    Assert.assertFalse("Company should not be empty after inserting a new employee", c.isEmpty());

    // Adding the same employee should always fail
    Assert.assertFalse("Adding identical PartTime to Company should return false", c.add(testPartTime));
  }

  // remove
  public void testRemove() {

  }

  // setHours
  public void testSetHours() {

  }
}
