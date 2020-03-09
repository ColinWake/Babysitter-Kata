import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WageCalculatorTest {


    private WageCalculator underTest;

    @BeforeEach
    void setUp() {
        underTest = new WageCalculator();
    }

    @Test
    void shouldReturnZeroForNoHoursWorked() {
        int wage = underTest.calculateWage(17, 17, 17);

        assertThat(wage).isEqualTo(0);
    }
}
