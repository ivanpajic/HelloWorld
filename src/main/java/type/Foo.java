package type;

public class Foo {
    public int bar(int a, int b) {
        if (a < b) {
            return b;
        }
        for (int i = 0; i < 10; i++) {
            if (i == b) {
                continue;
            }
            if (i == a) {
                break;
            }
            bazz();
        }
        return a;
    }

    private void bazz() {
    }
}

