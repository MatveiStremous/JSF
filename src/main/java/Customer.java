import jakarta.inject.Named;

@Named
public class Customer {
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void sayHello(){
        System.out.println("hello "+input);
    }
}
