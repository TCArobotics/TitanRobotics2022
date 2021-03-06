package frc.robot.data;

import edu.wpi.first.wpilibj.XboxController;
import java.util.HashMap;
import edu.wpi.first.wpilibj.Timer;

//This class process all gamepad inputs into a form usable by TeleopControl

public class GamePad
{
    private XboxController xboxController;
    private HashMap<ButtonMap, Double> buttons;
    private double debouncePeriod = 0.25; //The time before a button is allowed to be pressed again in seconds
    public GamePad()
    {
        this.xboxController = new XboxController(PortMap.GAMEPAD.portNumber);
        this.buttons = new HashMap<ButtonMap, Double>();
        init();
    }

    private void init()
    {
        for(ButtonMap i : ButtonMap.values())
        {
            buttons.put(i, Timer.getFPGATimestamp()); //Fill the dictionary with an item for each button with the current time
        }
    }

    public boolean getButton(ButtonMap button) //Input a ButtonMap button name and receive whether it is pressed (Debounced)
    {
        if(!xboxController.getRawButton(button.value))
        {
            return false;
        }
        double currentTime = Timer.getFPGATimestamp();
        if(currentTime - buttons.get(button) > this.debouncePeriod)
        {
            buttons.replace(button, currentTime);
            return true;
        }
        return false;
    }

    public double getStick(ButtonMap stickAxis) //Input the ButtonMap name and axis and receive its value, double between -1 and 1
    {
        switch(stickAxis)
        {
            case STICK_LEFTX:
                return xboxController.getLeftX();
            case STICK_LEFTY:
                return xboxController.getLeftY();
            case STICK_RIGHTX:
                return xboxController.getRightX();
            case STICK_RIGHTY:
                return xboxController.getRightY();
            default:
                return 0;
        }
    }
}