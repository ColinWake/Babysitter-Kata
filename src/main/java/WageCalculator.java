public class WageCalculator {
    public int calculateWage(int startHour, int endHour, int bedtime) {

        int wage = 0;

        determineInvalidShiftTime(startHour, endHour);

        if (shiftHoursBeforeBedtime(endHour, bedtime)) {
            wage = (endHour - startHour) * 12;
        }

        if (shiftHoursAfterBedtime(endHour, bedtime)) {
            wage = 8;
        }

        return wage;
    }

    private boolean shiftHoursAfterBedtime(int endHour, int bedtime) {
        return endHour > bedtime;
    }

    private boolean shiftHoursBeforeBedtime(int endHour, int bedtime) {
        return endHour <= bedtime;
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
