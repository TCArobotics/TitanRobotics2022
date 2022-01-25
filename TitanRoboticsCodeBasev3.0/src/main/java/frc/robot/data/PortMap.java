package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    //Gamepad ports
    GAMEPAD(0),
    FRONTRIGHT(0),
    REARRIGHT(1),
    TURNTABLE(2),
    SHOOTER(7),
    FRONTLEFT(8),
    REARLEFT(9),
    
    //Sensor ports
    GYRO(-1);

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}