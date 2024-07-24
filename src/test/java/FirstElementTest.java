import org.junit.jupiter.api.Test;

import java.util.List;

public class FirstElementTest {

    @Test
    void testFirstElement() {
        String expectedValue = "expectedValue";
        org.assertj.core.api.Assertions.assertThat(List.of(expectedValue)).first().isEqualTo(expectedValue);

    }

    @Test
    void testIntegerOneEqualsIntegerTwo() {

        @Test
        void testIntegerOneEqualsIntegerTwo () {
            Integer expectedInt = 2;
            org.assertj.core.api.Assertions.assertThat(1).isEqualTo(expectedInt);
        }
    }
}
