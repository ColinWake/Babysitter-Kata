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
        assertWage(17, 17, 17, 0);
    }

    @Test
    void shouldThrowExceptionWhenWorkingBeforeFivePM() {
        assertInvalidShiftTime(16, 17);
    }


    @Test
    void shouldThrowExceptionWhenEndingAfterFourAM() {
        assertInvalidShiftTime(17, 5);
    }

    @Test
    void shouldMakeOneHoursWageWorkingBeforeBedtime() {
        assertWage(17, 18, 18, 12);
        assertWage(18, 19, 19, 12);
    }


    @Test
    void shouldMakeOneHoursWageWorkingAfterBedtime() {
        assertWage(18, 19, 18, 8);
    }


    private void assertWage(int startHour, int endHour, int bedtime, int wage) {
        assertThat(underTest.calculateWage(startHour, endHour, bedtime)).isEqualTo(wage);
    }

    private AbstractThrowableAssert<?, ? extends Throwable> assertInvalidShiftTime(int startHour, int endHour) {
        return assertThatCode(() -> underTest.calculateWage(startHour, endHour, 17)).isInstanceOf(InvalidShiftTimeException.class).hasMessage("Invalid shift time");
    }
}
