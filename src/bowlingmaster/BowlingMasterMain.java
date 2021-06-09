package bowlingmaster;

import bowlingmaster.app.BonusCalculator;
import bowlingmaster.app.FrameInputReader;

/**
 * Bowling Master is an application to calculate the results of a bowling match.
 * <p>
 * The game consists of 10 frames. In each frame the player has two tries (rolls) and can knock down up to
 * 10 pins. The score per frame is calculated from the number of pins knocked down and other and additional bonuses.
 * These bonuses result from spares and strikes.
 * A spare is when the player has knocked down all 10 pins in a frame. The bonus for this is the number of pins knocked
 * down in the next roll.
 * A strike is when the player knocks down all 10 pins in the first attempt. The bonus for this is the number of pins
 * knocked down in the next two rolls.
 * In the tenth frame, a player who achieves a spare or a strike may play an additional roll to end the frame.
 * No more than 3 rolls can be played in the last frame.
 * <p>
 * The user is asked for the roll results of each frame via console. The inputs are validated. Only when ten valid
 * frame results are given, the end result is calculated and printed out.
 * <p>
 * TODO: write JUnit tests, especially for the calculation part
 * TODO: do some refactoring to increase readability and decrease time complexity
 * TODO: add more options for inserting numbers, e.g. via console args
 * TODO: add more features, e.g. an output of each frame rolls and their bonus or multiple players
 */
public class BowlingMasterMain {

    /**
     * Runs the Bowling Master application.
     *
     * @param args array of console parameters
     */
    public static void main(String[] args) {
        System.out.println("The Bowling Master can calculate your bowling results! Insert ten rounds of bowling!");
        FrameInputReader frameInputReader = new FrameInputReader();
        BonusCalculator bonusCalculator = new BonusCalculator(frameInputReader.getFrames());
        System.out.printf("%nGame finished! You scored %d points - Congratulations!", bonusCalculator.getEndResult());
    }
}
