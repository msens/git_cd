package fixtures;

/**
 * Created with IntelliJ IDEA.
 * User: michielsens
 * Date: 02/10/2013
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
public class FindThePostalCode {
    private String firstName;
    private String lastName;
    private String postalCode;

    //input value from fitnesse column first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //input value from fitnesse column last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void execute() { // executed after each table row
        this.postalCode = "1234wq";
        //      this.postalCode = new FindThePostalCode().find(this.firstName, this.lastName);
    }

    //returns value to fitnesse, into column postalcode? (with questionmark)
    public String postalCode() {
        return this.postalCode;
    }


}
