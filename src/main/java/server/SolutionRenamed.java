package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionRenamed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
// change
        if (a > 0) {
            a = a * 1 - 28;
        } else if (a < 0) {
            a = a + 1;
        }
        System.out.println(a);
    }
}
