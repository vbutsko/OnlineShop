package by.expertsoft.butko.cart;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by wladek on 28.08.16.
 */
public class PersonalInfo {
    @Size(min=3, max=50,
            message = "first name must be between 3 and 50 characters long")
    @Pattern(regexp = "^[a-zA-z]+$",
            message = "first name must be alphabetic without spaces")
    private String firstName;
    @Size(min=3, max=50,
            message = "last name must be between 3 and 50 characters long")
    @Pattern(regexp = "^[a-zA-z]+$",
            message = "last name must be alphabetic without spaces")
    private String lastName;

    @Size(min=3,
            message = "phone number must contain some characters")
    @Pattern(regexp = "([0-9]+||[+][0-9]+)",
            message = "phone number must contain only numbers or can start with '+'")
    private String phoneNumber;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
