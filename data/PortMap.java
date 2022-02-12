package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD_0(0),
    GAMEPAD_1(1),
    FRONTRIGHT(0),//new board port 1
    REARRIGHT(1),//new board port 0
    TURNTABLE(2),
    SHOOTER(13),
    FRONTLEFT(7), //new board port 3
    REARLEFT(6), //new board port 2
    SHOOTERGROUND(11),
    SHOOTERMIDDLE(12),
    SHOOTERROTATION(2); //new board port 4
    

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}