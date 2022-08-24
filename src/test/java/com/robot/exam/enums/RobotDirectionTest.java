package com.robot.exam.enums;


import com.robot.exam.exception.InvalidCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RobotDirectionTest {

    @Test
    void testGetDirection_withParamNonExist_shouldThrowError() throws InvalidCommandException {

        Object[] command = new Object[1];
        assertThrows(InvalidCommandException.class, ()-> {
            RobotDirection.getDirection(command);
        });
    }


    @Test
    void testGetDirection_withParamExistButInvalidValue_shouldThrowError() throws InvalidCommandException {

        Object[] command = new Object[1];
        command[0] = "PLACE,1,1,1";
        assertThrows(InvalidCommandException.class, ()-> {
            RobotDirection.getDirection(command);
        });
    }

    @Test
    void testGetDirection_withParamValid_shouldBeSuccess() throws InvalidCommandException {

        try (MockedStatic<RobotDirection> mockedStatic = Mockito.mockStatic(RobotDirection.class,
                Mockito.CALLS_REAL_METHODS)){
            Object[] command = new Object[1];
            command[0] = "PLACE,3,3,SOUTH";
            mockedStatic.when(() -> RobotDirection.getDirection(command))
                    .thenReturn(RobotDirection.SOUTH);

            RobotDirection robotDirection = RobotDirection.getDirection(command);
            assertEquals(1, command.length);
            assertEquals(RobotDirection.SOUTH, robotDirection);

        }
    }

}
