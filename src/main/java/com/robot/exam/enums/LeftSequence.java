package com.robot.exam.enums;

import java.util.*;

public enum LeftSequence {
    NORTH, WEST,SOUTH, EAST;

    public static RobotDirection newDirection(RobotDirection currentDirection) {

        List<LeftSequence> leftDirections = Arrays.asList(LeftSequence.values());
        int index = 0;
        for (var x=0; x < leftDirections.size(); x++) {
            if (leftDirections.get(x).toString().equals(currentDirection.toString())) {
                index = x;
                break;
            }
        }

        int newIndex = index + 1;
        if (newIndex >= leftDirections.size()) newIndex = 0;
        return RobotDirection.valueOf(leftDirections.get(newIndex).toString());
    }
}
