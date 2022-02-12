package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD(0),
    CAMERA_SHOOTER(1181),  //first camera at 1181, second at 1182 etc.
    FRONTRIGHT(0),
    REARRIGHT(1),
    TURNTABLE(2),
    SHOOTER(3),
    FRONTLEFT(7),
    REARLEFT(6),
    SHOOTER_GROUND(11),
    SHOOTER_MIDDLE(12),
    SHOOTER_ROTATION(5);

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}