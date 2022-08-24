# ROBOT COMMAND CODE

### Getting Started
For further reference, please consider the following sections below.

### Description
The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.

The toy robot must not fall off the table during movement. This also includes the initial placement of the toy robot. Any
move that would cause the robot to fall must be ignored.

### Prerequisites
Install the following tools required to run this robot code.
- JAVA 11
    * Official Java Downloads or OpenJDK https://www.oracle.com/java/technologies/downloads/
  
- MAVEN 3
    * Official Apache Maven Downloads https://maven.apache.org/install.html

### Installation
Clone this repository via web or use your command line in your local machine.

1. ```git clone https://github.com/heartTorres/robot-command.git```
2. ``` mvn clean package```
3. ``java -jar ./target/Robot-0.0.1.jar``
4. Output should be seen like on the console:
  ```2022-08-24 21:45:41.880  INFO 64171 --- [ main] com.robot.exam.service.LogicService      : Output: 0, 1, NORTH
2022-08-24 21:45:41.881  INFO 64171 --- [main] com.robot.exam.service.LogicService      : Output: 0, 0, WEST
2022-08-24 21:45:41.881  INFO 64171 --- [main] com.robot.exam.service.LogicService      : Output: 3, 3, NORTH
```

### Example Input File

```
PLACE 0,0,NORTH
MOVE
REPORT
Output: 0,1,NORTH
```
