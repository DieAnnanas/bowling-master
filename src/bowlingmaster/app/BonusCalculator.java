package bowlingmaster.app;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Class that calculates the results and bonuses for each frame of a given list of {@link Frame}s,
 * adding them up for the end result of the bowling match.
 */
public class BonusCalculator {

    private final List<Frame> frames;
    private final int endResult;

    /**
     * Constructor to create an instance of {@link BonusCalculator}, that also
     * immediately triggers the end result calculation of the given ten frames.
     *
     * @param frames list of {@link Frame}s that must have exact ten items, else an error is thrown
     */
    public BonusCalculator(List<Frame> frames) {
        if (frames == null || frames.size() != 10) {
            throw new IllegalArgumentException("Frames given for bonus calculation are either null or have not size of 10.");
        }
        this.frames = frames;
        this.endResult = IntStream.range(0, 10).map(this::calculateFrameResult).sum();
    }

    private int calculateFrameResult(int index) {
        Frame frame = frames.get(index);
        Frame nextFrame = getFrameSafely(index + 1);
        Frame frameAfterNextFrame = getFrameSafely(index + 2);
        return getSumOfFrameRolls(frame) + resolveBonus(frame, nextFrame, frameAfterNextFrame);
    }

    private Frame getFrameSafely(int index) {
        return index < frames.size() ? frames.get(index) : null;
    }

    private int getSumOfFrameRolls(Frame frame) {
        return frame.getFirstRoll() + frame.getSecondRoll() + frame.getThirdRoll();
    }

    private int resolveBonus(Frame frame, Frame nextFrame, Frame frameAfterNextFrame) {
        // if there is no next frame, there is no bonus
        if (nextFrame == null) {
            return 0;
        }
        // if current frame is a strike, add sum of next two rolls as bonus
        if (frame.isStrike()) {
            return resolveStrikeBonus(nextFrame, frameAfterNextFrame);
        }
        // if current frame is a spare, return sum of rolls and next roll
        if (frame.isSpare()) {
            return nextFrame.getFirstRoll();
        }
        // else there is no bonus
        return 0;
    }

    private int resolveStrikeBonus(Frame nextFrame, Frame frameAfterNextFrame) {
        // if next frame is also a strike and there is a frame after the next frame, return sum of their first rolls
        if (nextFrame.isStrike() && frameAfterNextFrame != null) {
            return nextFrame.getFirstRoll() + frameAfterNextFrame.getFirstRoll();
        }
        // else return sum of the first and second roll of next frame
        return nextFrame.getFirstRoll() + nextFrame.getSecondRoll();
    }

    public int getEndResult() {
        return endResult;
    }
}