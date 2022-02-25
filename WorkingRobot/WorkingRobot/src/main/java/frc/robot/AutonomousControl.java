package frc.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.actors.DriveControl;

//This class controls all robot functions during the Autonomous period

public class AutonomousControl
{   
    public double startingTime;
    public AutonomousControl()
    {
        startingTime = Timer.getFPGATimestamp();
    }

    public void init()
    {
        startingTime = Timer.getFPGATimestamp();
    }
    public void execute() //Called Periodically during Autonomous
    {
        //System.out.println(Timer.getFPGATimestamp() - startingTime);
        if(Timer.getFPGATimestamp() - startingTime < 2.5)
        {
            DriveControl.mecanumDrive(-1, 0, 0, .25);
        }
        else
        {
            DriveControl.stop();
        }
    }
}