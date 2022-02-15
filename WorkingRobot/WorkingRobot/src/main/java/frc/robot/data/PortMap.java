package frc.robot.data;

//This enum contains all port numbers
//Reference a port number like so: PortMap.GAMEPAD.portNumber

public enum PortMap
{
    GAMEPAD_0(0),
    CAMERA_SHOOTER(1181),  //first camera at 1181, second at 1182 etc.
    GAMEPAD_1(1),
    FRONTRIGHT(1),//new board port 1, old board port 0
    REARRIGHT(0),//new board port 0, old board port 1
    TURNTABLE(2),
    SHOOTER(13),
    FRONTLEFT(3), //new board port 3, old board port 7
    REARLEFT(2), //new board port 2, old board port 6
    SHOOTER_GROUND(11),
    SHOOTER_MIDDLE(12),
    SHOOTER_ROTATION(5); 
    

    public int portNumber;
    private PortMap(int _portNumber)
    {
        this.portNumber = _portNumber;
    }
}