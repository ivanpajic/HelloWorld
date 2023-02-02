import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        int[] is = {1,2,3};
        for (int i : is) {
            System.out.println(i/0);
        }

    }


}
