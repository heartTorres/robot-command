package com.robot.exam.component;

import com.robot.exam.enums.RobotDirection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Position {

    private int x;
    private int y;
    private RobotDirection direction;

}
