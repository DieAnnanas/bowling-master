package bowlingmaster.app;

/**
 * Model that holds the data of a bowling frame, containing up to three rolls.
 * Does not hold or add any bonuses.
 */
public class Frame {

    private final int firstRoll;

    private final int secondRoll;

    private int thirdRoll;

    /**
     * Constructor to create a valid instance of this type, containing at least two roll values.
     *
     * @param firstRoll the value of the first roll
     * @param secondRoll the value of the second roll
     */
    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public int getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(int thirdRoll) {
        this.thirdRoll = thirdRoll;
    }

    /**
     * @return whether this frame is a strike
     */
    public boolean isStrike() {
        return firstRoll == 10;
    }

    /**
     * @return whether this frame is a spare
     */
    public boolean isSpare() {
        return !isStrike() && firstRoll + secondRoll == 10;
    }
}
