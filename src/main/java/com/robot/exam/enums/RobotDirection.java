package com.robot.exam.enums;

import com.robot.exam.exception.InvalidCommandException;

public enum RobotDirection {

    NORTH, SOUTH, WEST, EAST;

    public static RobotDirection getDirection(Object[] command) throws InvalidCommandException {

        try {
            return RobotDirection.valueOf(command[3].toString().toUpperCase());
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
            throw new InvalidCommandException("Invalid direction. Direction should be like NORTH, EAST," +
                    " SOUTH, WEST");
        }

    }
}
