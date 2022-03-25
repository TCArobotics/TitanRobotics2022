package frc.robot.data;

// This Enum stores values for all gamepad related inputs
// -1 indicates a imaginary or placeholder value
//Reference a value like so: ButtonMap.A.value

public enum ButtonMap
{
    A(1), //Toggle intake
    B(2), //Activate shooter
    X(3), //Extend climber
    Y(4), //Retract climber
    LB(5), //Change speed for shooter and driver controllers respectively
    RB(6), //Reverse intake, toggle camera views
    BACK(7),
    START(8),
    LSTICK(9),
    RSTICK(10),

    STICK_LEFTX(-1), //Strafe
    STICK_LEFTY(-1), //Forward/backward
    STICK_RIGHTX(-1), //turn
    STICK_RIGHTY(-1),
    TRIGGER_LEFT(-1),
    TRIGGER_RIGHT(-1);

    public int value;
    private ButtonMap(int _value)
    {
        this.value = _value;
    }
}