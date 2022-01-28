package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD(0),
    FRONTRIGHT(0),
    REARRIGHT(1),
    TURNTABLE(2),
    SHOOTER(5),
    FRONTLEFT(3),
    REARLEFT(2);

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}