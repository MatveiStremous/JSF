import jakarta.faces.bean.ManagedBean;

@ManagedBean
public class PersonBean {
    private Long id;
    private String name;
    private String surname;
    private Long age;
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void save(){
        Repository repository = new Repository();
        repository.save(new Person(name, surname, age, gender));
    }
}
