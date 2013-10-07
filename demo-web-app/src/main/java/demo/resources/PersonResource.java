package demo.resources;

import demo.domain.Person;
import demo.services.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/person")
public class PersonResource {

  @GET
  @Path("/{firstName}/{lastName}")
  @Produces("application/json")
  public Person getPerson(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
    return PersonService.find(firstName, lastName);
  }
}
