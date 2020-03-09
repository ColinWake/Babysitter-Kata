import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

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

    @Test
    void shouldThrowExceptionWhenWorkingBeforeFivePM() {
        assertThatCode(() -> underTest.calculateWage(16, 17, 17)).isInstanceOf(InvalidShiftTimeException.class).hasMessage("Invalid shift time");
    }
}
