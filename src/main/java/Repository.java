import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Repository {
    private EntityManagerFactory entityManagerFactory;

    public Repository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("test");
    }

    public void save(Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Person findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Person person = entityManager.find(Person.class, id);
        entityManager.close();
        return person;
    }

    public void update(Person person){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(person);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public List<Person> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Person> persons = entityManager.createQuery("select new Person(a.id, a.name, a.surname, a.age, a.gender) from Person a order by a.id", Person.class).getResultList();
        entityManager.close();
        return persons;
    }
}
