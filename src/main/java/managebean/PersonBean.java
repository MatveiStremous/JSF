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

    private String id;
    private String name;
    private String surname;
    private String age;
    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String save() {
        repository.save(new Person(name, surname, Integer.parseInt(age), gender));
        return "hello.xhtml";
    }

    public List<Person> getAll() {
        return repository.getAll();
    }

    public String delete() {
        repository.deleteById(Long.parseLong(id));
        return "hello.xhtml";
    }

    public Person getById() {
        Person person = repository.findById(Long.parseLong(id));
        if (person != null) {
            this.id = person.getId().toString();
            this.name = person.getName();
            this.surname = person.getSurname();
            this.age = person.getAge().toString();
            this.gender = person.getGender();
        }
        return person;
    }

    public String showPerson(Long id) {
        this.id = id.toString();
        return "viewById";
    }

    public String updatePerson(String id) {
        this.id = id;
        return "updateById";
    }

    public String update() {
        repository.update(new Person(Long.parseLong(id), name, surname, Integer.parseInt(age), gender));
        return "hello.xhtml";
    }
}
