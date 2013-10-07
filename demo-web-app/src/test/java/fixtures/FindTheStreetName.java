package fixtures;

import demo.domain.Address;
import demo.domain.Person;
import demo.services.PersonService;

/**
 * Created with IntelliJ IDEA.
 * User: michielsens
 * Date: 02/10/2013
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
// fixtures are invoked by fitnesse SLIM for table Person Service.
public class FindTheStreetName {

    private String firstName;
    private String lastName;
    private String streetName;

    //input value from fitnesse column first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //input value from fitnesse column last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void execute() { // executed after each table row
       Person person = PersonService.find(this.firstName, this.lastName);
       Address address = person.getAddress();
       this.streetName = address.getStreetName();
      }

    //returns value to fitnesse, into column streetName? (with questionmark)
    public String streetName() {
        return this.streetName;
    }

}
