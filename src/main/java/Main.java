public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        repository.save(new Person("Ma", "sad", 16L, "MALE"));
    }
}
