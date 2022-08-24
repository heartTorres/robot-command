package com.robot.exam.enums;

import com.robot.exam.exception.InvalidCommandException;


public enum RobotCommand {
    PLACE, LEFT, RIGHT, MOVE, REPORT;

    public static RobotCommand getCommand(Object[] command) throws InvalidCommandException {

        try {
            return RobotCommand.valueOf(command[0].toString().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException ex ) {
            throw new InvalidCommandException("Invalid command. Command should be like PLACE, MOVE," +
                    " LEFT, RIGHT or REPORT");
        }

    }

}
