import type.EmployeeModified;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelloWorld {

    public static void main(String[] args) {

        //lets make another merge conflict
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
        // this is the new change after the newBranch changes were introduced
        System.out.println("Run ended");
        String reusability = "reusability";
        String myString = "blah " + "blah2 " + "blah3";
        String teststr = "40|50|60";
        boolean b = false;
//add a change
        HelloWorld hello = new HelloWorld();
        hello.testMain("1",
                       "2",
                       3,
                       4,
                       false);

        hello.branch1Method("1",
                            "2");

        var var = new EmployeeModified();

        /*listOf("clean",
                "assemble",
                "test",
                "publish",
                "publishJarPublicationToArtifactoryRepository",
                "jib",
                "rollout"
        ).forEach { name ->
                (tasks.findByName(name) ?: tasks.create(name)).apply {
                    dependsOn(gradle.includeBuilds.mapNotUtil { it.taskOrNull(":$name") })
        }*/
    }

    private static void listOf(String... s) {
    }

    //here also changes
    public void testFile() {
        File file1 = new File("C:\\Temp\\test");
        File[] files = file1.listFiles(file -> file.isDirectory() && file.getName().compareTo("20221212") <= 0);

        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
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


        Map<String, String> testMap = Map.of("testKey1",
                                             "testValue1",
                                             "testKey2",
                                             "testValue2",
                                             "testKey3",
                                             "testValue3");
        return "";
        //new change
    }
}