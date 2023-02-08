import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        int[] is = {1, 2, 3};
        for (int i : is) {
            System.out.println(i + 1 / i);
        }
        System.out.println("Run ended");

        String myString = "blah "
                + "blah2 "
                + "blah3";

        boolean b = false;
        Instance instance = new Instance();


    }

    public void testMain() {
        System.out.println("Test me!");
    }

    public String branch1Method() {
        String text = "This is some text";
        return text;
    }
}
