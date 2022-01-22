package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD(0),
    FRONTRIGHT(1),
    REARRIGHT(0),
    TURNTABLE(5),
    SHOOTER(9),
    FRONTLEFT(3),
    REARLEFT(2);

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}
