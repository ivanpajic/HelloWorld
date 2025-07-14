package scripts;

public class A {
    void foo(int value) {
        class Local {
            void bar() {
                Runnable runnable = () -> {
                    this.getPrintln(); // extract method on this statement
                };
            }

            private void getPrintln() {
                    System.out.println("USER REQUEST: test changes");
            }
            // line added in the IntroduceChange line
        }
    }
}
