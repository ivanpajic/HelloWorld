import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
        List<String> helloWorld = new ArrayList<>();
        helloWorld.add("Hello, World!");
        System.out.println(helloWorld.get(0));
        String helloWorld2;
        helloWorld2 = helloWorld.get(0);
        helloWorld2 = helloWorld2 + " again.";
        helloWorld.add(helloWorld2);
        System.out.println(helloWorld.get(1));
        int[] is = {1, 2, 3};
        for (int i : is) {
            System.out.println(i + 1 / i);
        }
        System.out.println("Run ended");

        String myString = "blah " + "blah2 " + "blah3";

        boolean b = false;
        Occurrence instance = new Occurrence();


        HelloWorld hello = new HelloWorld();
        hello.testMain("1","2",3,4,false);

        hello.branch1Method("1", "2");

        NewThread t1 = new NewThread();
        t1.setName("MyThread-1");
        NewThread t2 = new NewThread();
        t2.setName("MyThread-2");
        t1.start();
        t2.start();
    }
//here also changes
    public void testFile() {
        File file1 = new File("C:\\Temp\\test");
        File[] files = file1.listFiles(file -> file.isDirectory() && file.getName().compareTo("20221212") <= 0);

        if(files == null || files.length ==0) {
            return;
        }
        for(File file : files) {
            System.out.println(file);
        }

    }

    public void testMain(String parameter1,
                         String parameter2,
                         int argument3,
                         int argument4,
                         boolean input5) {

        System.out.println("Test me!");
    }

    public String branch1Method(String parameter1,
                                String parameter2) {
        String text = "This is some text in Branch1 method";
        return text;
    }
}
