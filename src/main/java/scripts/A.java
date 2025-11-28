package scripts;

public class A {
    void foo(int value) {
        class Local {
            void bar() {
                Runnable runnable = () -> {
                    getPrintln();// extract method on this statement
                };
            }
// change on line 11 on test branch
            private static void getPrintln() {
                // line added on the BetaBranch
            }
            // line added in new change to conflict
        }
    }
}
