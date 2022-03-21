package frc.robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.GripPipeline; 
import java.util.ArrayList;

//This class controls all robot functions during the Autonomous period

public class AutonomousControl
{
    private final GripPipeline gripPipeline;
    public AutonomousControl()
    {
        gripPipeline = new GripPipeline();
        gripPipeline.filterContoursOutput();
    }

    public void moveBackChoice(double _startTime, double _wait) //Called Periodically during Autonomous
    {
        
        if(Timer.getFPGATimestamp() - _startTime > _wait && Timer.getFPGATimestamp() - _startTime < 2 + _wait)
        {
            DriveControl.mecanumDrive(0, 1, 0, .25);
        }
        else
        {
            DriveControl.stop();
        }
    }
    public void shootChoice(double _startTime, double _wait)
    {
        if(Timer.getFPGATimestamp() - _startTime > _wait && Timer.getFPGATimestamp() - _startTime < 2 + _wait)
        {
            DriveControl.mecanumDrive(0, 1, 0, .25);
            ShooterControl.stop();
        }
        else
        {
            DriveControl.stop();
            if(Timer.getFPGATimestamp() - _startTime > 2 + _wait && Timer.getFPGATimestamp() - _startTime < 5 + _wait)
            {
                ShooterControl.shoot(1);
                ShooterControl.intake(1);
            }
            else
            {
                ShooterControl.stop();
            }
        }
    }
    public void deliverBallChoice(double _startTime, double _wait)
    {

    }
}