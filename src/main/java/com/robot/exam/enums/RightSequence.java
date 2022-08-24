package com.robot.exam.enums;

import java.util.Arrays;
import java.util.List;


public enum RightSequence {
    NORTH, EAST, SOUTH, WEST;

    public static RobotDirection newDirection(RobotDirection currentDirection) {

        List<RightSequence> rightDirections = Arrays.asList(RightSequence.values());
        int index = 0;
        for (var x=0; x < rightDirections.size(); x++) {
            if (rightDirections.get(x).toString().equals(currentDirection.toString())) {
                index = x;
                break;
            }
        }

        int newIndex = index + 1;
        if (newIndex >= rightDirections.size()) newIndex = 0;

        return RobotDirection.valueOf(rightDirections.get(newIndex).toString());
    }
}
