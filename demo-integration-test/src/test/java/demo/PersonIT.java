package demo;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

public class PersonIT {

    @Test
    public void testPersonService() {
        // note: context root and port needs to be equal to what is defined in pom file!
        expect().body("firstName", equalTo("John")).when().get("http://localhost:9090/rest/person/John/Doe");
//      expect().body("firstName", equalTo("John")).when().get("http://localhost:1234/rest/person/John/Doe");
//    with().parameters("firstName", "John", "lastName", "Doe").expect().body("firstName", equalTo("John")).
//            body("lastName", equalTo("Doe")).when().get("http://localhost:8080/rest/person");
    }
}