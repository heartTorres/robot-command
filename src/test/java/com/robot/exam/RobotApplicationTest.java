package com.robot.exam;

import com.robot.exam.exception.InvalidCommandException;
import com.robot.exam.service.LogicService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RobotApplicationTest {

	@InjectMocks
	private RobotApplication robotApplication;

	@Mock
	private LogicService logicService;

	@Test
	void whenUserInputIsPresent_shouldBeSuccess() throws Exception {

		Object[] command = {"PLACE,1,2,EAST"};
		List<Object[]> commands = new ArrayList<>();
		commands.add(command);
		when(logicService.getUserInput()).thenReturn(commands);
		robotApplication.run("");
		verify(logicService, times(1)).getUserInput();
	}


	@Test
	void whenUserInputIsInvalid_InvalidCommandException() throws Exception {

		Object[] command = {-1};
		List<Object[]> commands = new ArrayList<>();
		commands.add(command);
		when(logicService.getUserInput()).thenAnswer((t) -> {
			throw new InvalidCommandException("Invalid Command"); });
		Assertions.assertThrows(InvalidCommandException.class, () -> {
			robotApplication.run("");
		});

	}

}
