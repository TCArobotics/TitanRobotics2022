package frc.robot.data;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD_0(0),
    CAMERA_SHOOTER(1181),  //first camera at 1181, second at 1182 etc.
    GAMEPAD_1(1),
    FRONTRIGHT(13),//new board port 3
    REARRIGHT(10),//new board port 0
    TURNTABLE(2),
    SHOOTER(4),
    FRONTLEFT(11), //new board port 1
    REARLEFT(12), //new board port 2
    SHOOTER_INTAKE(5),
    SHOOTER_LEFT(0),
    SHOOTER_BACK(1),
    SHOOTER_RIGHT(2),
    SHOOTER_FRONT(3);

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}