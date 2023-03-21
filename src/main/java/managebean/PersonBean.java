package managebean;

import entity.Person;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.inject.Inject;
import repo.Repository;

import java.util.List;

@ManagedBean
@SessionScoped
public class PersonBean {
    @Inject
    private Repository repository;

    private Long id;
    private String name;
    private String surname;
    private Integer age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void save(){
        repository.save(new Person(name, surname, age, gender));
    }

    public List<Person> getAll(){
        return repository.getAll();
    }

    public void delete(){
        repository.deleteById(id);
    }

    public Person getById(){
        Person person = repository.findById(id);
        this.id = person.getId();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.age = person.getAge();
        this.gender = person.getGender();
        return repository.findById(id);
    }

    public String showPerson(Long id) {
        this.id = id;
        return "viewById";
    }

    public String updatePerson(Long id) {
        this.id = id;
        return "updateById";
    }

    public void update(){
        repository.update(new Person(id, name, surname, age, gender));
    }
}
