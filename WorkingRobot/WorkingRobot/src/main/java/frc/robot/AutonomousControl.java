package frc.robot;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.GripPipeline;

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
        
        if(Timer.getFPGATimestamp() - _startTime > _wait && Timer.getFPGATimestamp() - _startTime < 3 + _wait)
        {
            DriveControl.mecanumDrive(0, 1.5, 0, .25);
        }
        else
        {
            DriveControl.stop();
        }
    }
    public void shootChoice(double _startTime, double _wait)
    {
        if(Timer.getFPGATimestamp() - _startTime > _wait && Timer.getFPGATimestamp() - _startTime < 1 + _wait)
        {
            DriveControl.stop();
            ShooterControl.shoot(.9, .9, .9);
            ShooterControl.intake(0);
        }
        else if(Timer.getFPGATimestamp() - _startTime > 1 +_wait && Timer.getFPGATimestamp() - _startTime < 3 + _wait)
        {
            DriveControl.stop();
            ShooterControl.shoot(.9, .9, .9);
            ShooterControl.intake(1);
        }
        else if(Timer.getFPGATimestamp() - _startTime >  3 + _wait && Timer.getFPGATimestamp() - _startTime < 6 + _wait)
        {
            DriveControl.mecanumDrive(0, 1, 0, .5);
            ShooterControl.stop();
        }
        else if(Timer.getFPGATimestamp() - _startTime > 6 + _wait)
        {
            DriveControl.stop();
            ShooterControl.stop();
        }
    }

    public void deliverBallChoice(double _startTime, double _wait)
    {

    }
}