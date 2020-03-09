import org.assertj.core.api.AbstractThrowableAssert;
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
        assertInvalidShiftTime(16, 17);
    }


    @Test
    void shouldThrowExceptionWhenEndingAfterFourAM() {
        assertInvalidShiftTime(17, 5);
    }

    private AbstractThrowableAssert<?, ? extends Throwable> assertInvalidShiftTime(int startHour, int endHour) {
        return assertThatCode(() -> underTest.calculateWage(startHour, endHour, 17)).isInstanceOf(InvalidShiftTimeException.class).hasMessage("Invalid shift time");
    }
}
