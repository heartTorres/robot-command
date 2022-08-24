package com.robot.exam;

import com.robot.exam.exception.InvalidCommandException;
import com.robot.exam.service.LogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
@Slf4j
public class RobotApplication implements CommandLineRunner {

	@Autowired
	private LogicService logicService;

	public static void main(String[] args) {
		SpringApplication.run(RobotApplication.class, args);
	}

	@Override
	public void run(String... args) throws InvalidCommandException, IOException {

		log.info("Command Line Runner started..");

		List<Object[]> commands = logicService.getUserInput();
		logicService.executeUserInput(commands);
	}




}
