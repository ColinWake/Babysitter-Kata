public class WageCalculator {
    public int calculateWage(int startHour, int endHour, int bedtime) {

        determineInvalidShiftTime(startHour, endHour);

        if (shiftHoursBeforeBedtime(endHour)) {
            return 12;
        }

        if (shiftHoursAfterBedtime(endHour)) {
            return 8;
        }

        return 0;
    }

    private boolean shiftHoursAfterBedtime(int endHour) {
        return endHour == 19;
    }

    private boolean shiftHoursBeforeBedtime(int endHour) {
        return endHour == 18;
    }

    private void determineInvalidShiftTime(int startHour, int endHour) {
        if (startHour < 17) {
            throw new InvalidShiftTimeException("Invalid shift time");
        }

        if (endHour > 4 && endHour < 17) {
            throw new InvalidShiftTimeException("Invalid shift time");
        }
    }
}
