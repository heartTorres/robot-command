package com.robot.exam.service;


import com.robot.exam.exception.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(MockitoExtension.class)
class LogicServiceTest {

    @InjectMocks
    private LogicService logicService;


    @Test
    void testGetUserInputValid_shouldBeSuccess() throws IOException {

         List<Object[]> commands = logicService.getUserInput();
         assertEquals(12, commands.size());
    }


    @Test
    void testExecuteUserInput_withInvalidCommand_shouldThrowError() throws InvalidCommandException {

        Object[] command = {"-1"};
        List<Object[]> commands = new ArrayList<>();
        commands.add(command);
         Exception exception = Assertions.assertThrows(InvalidCommandException.class, () -> {
            logicService.executeUserInput(commands);
        });

        String message = "Invalid command. Command should be like PLACE, MOVE," +
                " LEFT, RIGHT or REPORT";
       assertEquals(message, exception.getMessage());

    }


    @Test
    void testExecuteUserInput_withCorrectPlaceCommand_shouldBeSuccess() throws InvalidCommandException {

        Object[] place = new Object[4];
        place[0] = "PLACE";place[1] = "1";place[2] = "2"; place[3] = "NORTH";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);
        logicService.executeUserInput(commands);

        assertEquals(1, commands.size());
    }


    @Test
    void testExecuteUserInput_PlaceCommand_WithIncorrectPosition_shouldThrowError() throws InvalidCommandException {

        Object[] place = new Object[4];
        place[0] = "PLACE";place[1] = "a";place[2] = "b"; place[3] = "NORTH";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);
        Exception exception = Assertions.assertThrows(InvalidCommandException.class, () -> {
            logicService.executeUserInput(commands);
        });

        String message = "Invalid Place command, position should be in number format";
        assertSame(message, exception.getMessage());

    }


    @Test
    void testExecuteUserInput_withCorrectLeftCommand_shouldBeSuccess() throws InvalidCommandException {

        Object[] place = new Object[4];
        Object[] left = new Object[1];
        left[0] = "LEFT";
        place[0] = "PLACE";place[1] = "1";place[2] = "2"; place[3] = "NORTH";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);commands.add(left);
        logicService.executeUserInput(commands);

        assertEquals(2, commands.size());
    }


    @Test
    void testExecuteUserInput_withCorrectRightCommand_shouldBeSuccess() throws InvalidCommandException {

        Object[] place = new Object[4];
        Object[] left = new Object[1];
        left[0] = "RIGHT";
        place[0] = "PLACE";place[1] = "1";place[2] = "2"; place[3] = "EAST";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);commands.add(left);
        logicService.executeUserInput(commands);

        assertEquals(2, commands.size());

    }


    @Test
    void testExecuteUserInput_withCorrectRightMoveCommand_shouldBeSuccess() throws InvalidCommandException {

        Object[] place = new Object[4];
        Object[] left = new Object[1];
        Object[] move = new Object[1];
        Object[] right = new Object[1];
        place[0] = "PLACE";place[1] = "1";place[2] = "2"; place[3] = "WEST";
        left[0] = "MOVE";
        right[0] = "RIGHT";
        move[0] = "REPORT";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);commands.add(left);commands.add(move);
        logicService.executeUserInput(commands);

        assertEquals(3, commands.size());

    }


    @Test
    void testExecuteUserInput_withCorrectEastDirection_shouldBeSuccess() throws InvalidCommandException {

        Object[] place = new Object[4];
        Object[] left = new Object[1];
        Object[] move = new Object[1];
        place[0] = "PLACE";place[1] = "1";place[2] = "2"; place[3] = "EAST";
        left[0] = "MOVE";
        move[0] = "REPORT";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);commands.add(left);commands.add(move);
        logicService.executeUserInput(commands);

        assertEquals(3, commands.size());

    }


    @Test
    void testExecuteUserInput_withCorrectReportCommand_shouldBeSuccess() throws InvalidCommandException {

        Object[] place = new Object[4];
        Object[] left = new Object[1];
        Object[] move = new Object[1];
        place[0] = "PLACE";place[1] = "1";place[2] = "2"; place[3] = "SOUTH";
        move[0] = "MOVE";
        left[0] = "REPORT";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);commands.add(left);commands.add(move);
        logicService.executeUserInput(commands);

        assertEquals(3, commands.size());

    }


    @Test
    void testExecuteUserInput_withCorrectReportCommandWithNullCommand_shouldThrowError() throws InvalidCommandException {

        Object[] place = new Object[4];
        Object[] left = new Object[1];
        Object[] move = new Object[1];
        place[0] = "PLACE";place[1] = "1";place[2] = "2"; place[3] = "SOUTH";
        left[0] = "REPORT";
        List<Object[]> commands = new ArrayList<>();
        commands.add(place);commands.add(left);commands.add(move);

        Exception exception = assertThrows(InvalidCommandException.class, () -> {
            logicService.executeUserInput(commands);
        });

        assertEquals(3, commands.size());

    }


}
