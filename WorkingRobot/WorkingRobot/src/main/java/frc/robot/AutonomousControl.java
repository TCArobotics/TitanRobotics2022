package frc.robot;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;

//This class controls all robot functions during the Autonomous period

public class AutonomousControl
{
    public AutonomousControl()
    {
        
    }
    //3 choices: move back, shoot and move back, and deliver ball

    //move back for 3 seconds
    public void moveBackChoice(double _startTime, double _wait)
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

    //shoot for 3 seconds, using 1 second to rev up the motor. Move back for 3 seconds.
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

    //not used
    public void deliverBallChoice(double _startTime, double _wait)
    {

    }
}