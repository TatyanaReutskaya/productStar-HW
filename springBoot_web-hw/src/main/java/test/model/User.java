package test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    @JsonProperty("name")
    private String name;
    @Getter
    @Setter
    @JsonProperty("surname")
    private String surname;
    @Getter
    @Setter
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @Getter
    @Setter
    @JsonProperty("email")
    private String email;

    public User() {
    }

    public User(String name, String surname, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
