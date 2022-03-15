package frc.robot.data;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD_0(0), //driver gamepad
    CAMERA_SHOOTER(1181), //first camera at 1181, second at 1182 etc.
    GAMEPAD_1(2), //shooter gamepad
    FRONTRIGHT(3), //new board port 3
    REARRIGHT(0), //new board port 0
    TURNTABLE(2),
    SHOOTER(4),
    FRONTLEFT(1), //new board port 1
    REARLEFT(2), //new board port 2
    SHOOTER_INTAKE(4),
    SHOOTER_LEFT(5),
    SHOOTER_BACK(8),
    SHOOTER_RIGHT(6),
    SHOOTER_FRONT(7);

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}