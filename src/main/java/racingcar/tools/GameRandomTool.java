package racingcar.tools;

import static utils.RandomUtils.nextInt;

public class GameRandomTool {

    private static int minimumNumberRange = 0;
    private static int maximumNumberRange = 9;
    private static int minimumRequirementNumberForCarMove = 4;

    private GameRandomTool() {
    }

    public static boolean carMoveVerifier() {
        return nextInt(minimumNumberRange, maximumNumberRange)
            >= minimumRequirementNumberForCarMove;
    }
}
