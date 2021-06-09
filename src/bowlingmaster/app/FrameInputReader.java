package bowlingmaster.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Class that reads the results of a bowling match frame by frame from the console inputs,
 * while validating the inserted numbers.
 */
public class FrameInputReader {

    private static final String NEW_FRAME_MSG_PATTERN = "%nThis is frame #%d - Please enter your results.%n";
    private static final String FIRST_ROLL_MSG = "Enter the result of your first roll: ";
    private static final String SECOND_ROLL_MSG = "Enter the result of your second roll: ";
    private static final String THIRD_ROLL_MSG = "This is the final round and you scored an extra roll! Enter the result of your third roll: ";

    private static final String INVALID_FRAME_MSG = "You've given an invalid input. Please insert a valid pair of roll results that add up to a maximum of 10.";
    private static final String INVALID_ROLL_MSG = "You've given an invalid input. Please insert a number between 0 and 10.";

    private static final String ROLL_INPUT_PATTERN = "^[0-9]|10$";

    private final List<Frame> frames = new ArrayList<>();

    /**
     * Constructor to create an instance of {@link FrameInputReader}, that also
     * immediately triggers the console dialogue to collect the rolls of ten frames.
     */
    public FrameInputReader() {
        IntStream.range(0, 10).forEach(index -> frames.add(resolveFrame(index)));
    }

    private Frame resolveFrame(int index) {
        System.out.printf(NEW_FRAME_MSG_PATTERN, index + 1);
        return index == 9 ? resolveLastFrameFromConsoleInput() : resolveFrameFromConsoleInput();
    }

    private Frame resolveFrameFromConsoleInput() {
        // resolve result of both rolls - set second to 0 in case the first roll was a strike
        int firstRoll = readRollInput(FIRST_ROLL_MSG);
        int secondRoll = firstRoll != 10 ? readRollInput(SECOND_ROLL_MSG) : 0;
        // return new frame if read values are valid
        if (firstRoll + secondRoll <= 10) {
            return new Frame(firstRoll, secondRoll);
        }
        // else redo the input
        System.out.println(INVALID_FRAME_MSG);
        return resolveFrameFromConsoleInput();
    }

    private Frame resolveLastFrameFromConsoleInput() {
        // resolve result of both rolls and create new frame
        Frame frame = new Frame(readRollInput(FIRST_ROLL_MSG), readRollInput(SECOND_ROLL_MSG));
        // add the result of an extra roll if this is the last frame and there was a strike or spare
        if (frame.isStrike() || frame.isSpare()) {
            int thirdRoll = readRollInput(THIRD_ROLL_MSG);
            frame.setThirdRoll(thirdRoll);
        }
        return frame;
    }

    private int readRollInput(String userOutput) {
        String firstRoll = System.console().readLine(userOutput);
        // return if it is a number between 0 and 10
        if (firstRoll.matches(ROLL_INPUT_PATTERN)) {
            return Integer.parseInt(firstRoll);
        }
        // else redo the input
        System.out.println(INVALID_ROLL_MSG);
        return readRollInput(userOutput);
    }

    public List<Frame> getFrames() {
        return frames;
    }
}