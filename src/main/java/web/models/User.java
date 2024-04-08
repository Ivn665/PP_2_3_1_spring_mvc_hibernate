package web.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 30, message = "First Name should be between 2 and 30 characters")
    @Column(name = "Name")
    private String firstName;

    @Size(min = 2, max = 30, message = "Last Name should be between 2 and 30 characters")
    @Column (name = "last_Name")
    private String lastName;

    @Min(value = 0, message = "Age should be equal or greater than 0")
    @Column
    private byte age;

    @Column (name = "Social_Rating")
    private int socRating;

    public User() {
    }

    public User(String firstName, String lastName, byte age, int socRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.socRating = socRating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public int getSocRating() {
        return socRating;
    }

    public void setSocRating(int socRating) {
        this.socRating = socRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", socRating=" + socRating +
                '}';
    }
}
