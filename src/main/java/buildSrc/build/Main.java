package buildSrc.build;

public class Main {
    public static void main(String[] args) {
        printNumbers(10);
        printNumbers(10);
        printNumbers();
        printNumbers();
    }

    /**
     * Prints numbers from 1 to 12
     * Calls the printNumbers(int max) method with a maximum number of 10
     */
    private static void printNumbers() {
        printNumbers(12);
        printNumbers(11);
        
    }




    /**
     * Prints numbers from 1 to the specified maximum number
     *
     * @param max the maximum number to print
     */
    private static void printNumbers(int max) {
        for(int i = 1; i <= max; i++) {

            System.out.println();
            System.out.println("i = " + i);
        }
    }

    public void println(String x) {
        System.out.println(x);
    }
}
