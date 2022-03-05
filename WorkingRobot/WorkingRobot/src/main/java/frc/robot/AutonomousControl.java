package frc.robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.actors.DriveControl;

//This class controls all robot functions during the Autonomous period

public class AutonomousControl
{

    public AutonomousControl()
    {

    }

    public void execute() //Called Periodically during Autonomous
    {
        if(Timer.getFPGATimestamp() < 2)
        {
            DriveControl.mecanumDrive(0, 1, 0, .25);
        }
        else
        {
            DriveControl.stop();
        }
    }
}