package demo.services;

import demo.domain.Address;
import demo.domain.Person;
import org.joda.time.LocalDate;

public class PersonService {

  public static Person find(String firstName, String lastName) {
    Person p = new Person();
    p.setFirstName(firstName);
    p.setLastName(lastName);
    p.setDateOfBirth(new LocalDate(1960, 12, 12));
    Address address = new Address();
    address.setNumber(12);
    address.setPostalCode("1234wq");
    address.setStreetName("High street");
    p.setAddress(address);
    return p;
  }
}
