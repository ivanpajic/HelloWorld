package scripts;

public class A {
    void foo(int value) {
        class Local {
            void bar() {
                Runnable runnable = () -> {
                    getPrintln();// extract method on this statement
                };
            }

            //change for a pull request
            private static void getPrintln() {
            }
        }//change
    }
}
