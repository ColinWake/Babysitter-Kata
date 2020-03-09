public class WageCalculator {
    public int calculateWage(int startHour, int endHour, int bedtime) {

        if (startHour < 17) {
            throw new InvalidShiftTimeException("Invalid shift time");
        }

        return 0;
    }
}
