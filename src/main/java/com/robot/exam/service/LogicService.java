package com.robot.exam.service;

import com.robot.exam.component.Position;
import com.robot.exam.component.TableGrid;
import com.robot.exam.enums.LeftSequence;
import com.robot.exam.enums.RightSequence;
import com.robot.exam.enums.RobotCommand;
import com.robot.exam.enums.RobotDirection;
import com.robot.exam.exception.InvalidCommandException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
public class LogicService {

    private Position position = null;

    public List<Object[]> getUserInput() throws IOException {

        List<Object[]> commands =  new ArrayList<>();
        InputStream inputStream = new ClassPathResource("commands.txt").getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String contentLine;
        while ((contentLine = bufferedReader.readLine()) != null){
            Object[] command = contentLine.split(",");
            commands.add(command);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        return commands;
    }


    public Position executeUserInput(List<Object[]> commands) throws InvalidCommandException {

        for (Object[] c : commands) {
            RobotCommand command = RobotCommand.getCommand(c);
            switch(command) {
                case PLACE:
                   place(c);
                   break;
                case MOVE:
                    move();
                    break;
                case LEFT:
                    left();
                    break;
                case RIGHT:
                    right();
                    break;
                case REPORT:
                    report();
                    break;
                default:
                    break;
            }
        }

        return position;

    }


    private void place(Object[] command) throws InvalidCommandException {

        try {
            if (Integer.parseInt(command[1].toString()) < TableGrid.MIN_TABLE_GRID)
                command[1] = TableGrid.MIN_TABLE_GRID;
            if (Integer.parseInt(command[2].toString()) > TableGrid.MAX_UNIT_GRID)
                command[2] = TableGrid.MAX_UNIT_GRID;
        } catch (NumberFormatException ex) {
            throw new InvalidCommandException("Invalid Place command, position should be in number format");
        }

        position = Position.builder()
                .x(Integer.parseInt(command[1].toString()))
                .y(Integer.parseInt(command[2].toString()))
                .direction(RobotDirection.getDirection(command))
                .build();

    }


    private void move() {

        if (position == null) return;
        RobotDirection robotDirection = position.getDirection();
        switch(robotDirection) {
            case NORTH:
                position.setY(TableGrid.plusGridY(position.getY()));
                break;
            case SOUTH:
                position.setY(TableGrid.minusGridY(position.getY()));
                break;
            case WEST:
                position.setX(TableGrid.minusGridX(position.getX()));
                break;
            case EAST:
                position.setX(TableGrid.plusGridX(position.getX()));
                break;
            default:
                break;

        }

    }


    private void left() {

        if (position == null) return;
        RobotDirection currentDirection = position.getDirection();
        RobotDirection newDirection = LeftSequence.newDirection(currentDirection);
        position.setDirection(newDirection);

    }


    private void right() {

        if (position == null) return;
        RobotDirection currentDirection = position.getDirection();
        RobotDirection newDirection = RightSequence.newDirection(currentDirection);
        position.setDirection(newDirection);

    }


    private void report() {

        if (position == null) return;
        String message = String.format("Output: %s, %s, %s", position.getX(), position.getY(),
                position.getDirection());
        log.info(message);

    }

}
