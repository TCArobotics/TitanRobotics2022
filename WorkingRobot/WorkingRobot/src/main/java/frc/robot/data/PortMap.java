package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD_0(0), //driver gamepad
    GAMEPAD_1(2), //shooter gamepad (Green)
    CAMERA_SHOOTER(1181), //first camera at 1181, second at 1182 etc.
    FRONTRIGHT(3), //new board port 3 (Red)
    REARRIGHT(0), //new board port 0 (Purple)
    TURNTABLE(2),
    FRONTLEFT(2), //new board port 1 (Yellow)
    REARLEFT(1), //new board port 2
    CLIMBER(6),
    SHOOTER_INTAKE_LEFT(4), //Gray
    SHOOTER_INTAKE_RIGHT(9), //Brown
    SHOOTER_LEFT(5), //Orange
    SHOOTER_BACK(8), //White
    SHOOTER_FRONT(7); //Blue

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}