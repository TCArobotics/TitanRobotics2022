package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD_0(0), //driver gamepad
    CAMERA_SHOOTER(1181), //first camera at 1181, second at 1182 etc.
    GAMEPAD_1(2), //shooter gamepad (Green)
    FRONTRIGHT(3), //new board port 3 (Red)
    REARRIGHT(0), //new board port 0 (Purple)
    TURNTABLE(2),
    FRONTLEFT(1), //new board port 1 (Yellow)
    REARLEFT(2), //new board port 2
    CLIMBER(10),
    SHOOTER_INTAKE_LEFT(4), //Gray
    SHOOTER_INTAKE_RIGHT(9), //Brown
    SHOOTER_LEFT(5), //Orange
    SHOOTER_BACK(8), //White
    SHOOTER_RIGHT(6), //Unused
    SHOOTER_FRONT(7); //Blue

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}