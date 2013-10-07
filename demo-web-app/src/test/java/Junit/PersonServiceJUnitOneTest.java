package Junit;


import demo.domain.Person;
import demo.services.PersonService;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonServiceJUnitOneTest {
    //for surefire to test: the name should always end with "Test"!!

  @BeforeClass
  public static void testSetup() {
  }

  @Test
  public void findPersonByFirstAndLastName() throws Exception {
    String firstName = "John";
    String lastName = "Doe";

    Person p = PersonService.find(firstName, lastName);
    Assert.assertEquals(firstName,  p.getFirstName());
    Assert.assertEquals(lastName,  p.getLastName());
  }
}
