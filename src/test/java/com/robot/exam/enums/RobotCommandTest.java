package com.robot.exam.enums;

import com.robot.exam.exception.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RobotCommandTest {


    @Test
    void testRobotCommand_validParams_shouldBeSuccess() throws InvalidCommandException {

        Object[] command = new Object[1];
        command[0] = "REPORT";
        RobotCommand robotCommand = RobotCommand.getCommand(command);
        assertEquals(RobotCommand.REPORT, robotCommand);
    }


    @Test
    void testRobotCommand_InvalidParams_shouldThrowError() throws InvalidCommandException {

        Object[] command = new Object[1];
        Exception exception = Assertions.assertThrows(InvalidCommandException.class, () -> {
            RobotCommand.getCommand(command);
        });

        assertEquals("Invalid command. Command should be like PLACE, MOVE," +
                " LEFT, RIGHT or REPORT", exception.getMessage());
    }
}
