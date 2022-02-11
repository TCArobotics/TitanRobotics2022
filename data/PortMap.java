package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD(0),
    FRONTRIGHT(0),
    REARRIGHT(1),
    TURNTABLE(2),
    SHOOTER(13),
    FRONTLEFT(7),
    REARLEFT(6),
    SHOOTERGROUND(11),
    SHOOTERMIDDLE(12),
    SHOOTERROTATION(5);
    

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}