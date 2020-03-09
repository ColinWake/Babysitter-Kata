import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WageCalculatorTest {


    @Test
    void shouldInstantiate() {
        WageCalculator underTest = new WageCalculator();
    }

    @Test
    void shouldReturnZeroForNoHoursWorked() {
        WageCalculator underTest = new WageCalculator();

        int wage = underTest.calculateWage(5, 5, 5);

        assertThat(wage).isEqualTo(0);
    }
}
