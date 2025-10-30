package scripts;

public interface Foo {

    sealed interface BarResult {

        record Ok() implements BarResult {}

        record Err(String msg) implements BarResult {}

    }

    sealed interface BazResult {

        record Ok() implements BazResult {}

        record Err(String msg) implements BazResult {}

    }

    BarResult performBar();

    BazResult performBaz();

}