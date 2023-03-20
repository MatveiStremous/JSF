import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private Long age;
    private String gender;
    public Person() {
    }

    public Person(String name, String surname, Long age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Person(Long id, String name, String surname, Long age, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
