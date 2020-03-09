public class WageCalculator {
    public int calculateWage(int startHour, int endHour, int bedtime) {

        if (startHour < 17) {
            throw new InvalidShiftTimeException("Invalid shift time");
        }

        if (endHour > 4 && endHour < 17) {
            throw new InvalidShiftTimeException("Invalid shift time");
        }

        if (endHour == 18) {
            return 12;
        }

        if (endHour == 19) {
            return 8;
        }

        return 0;
    }
}
