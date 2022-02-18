package frc.robot;

import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import java.rmi.server.RemoteObjectInvocationHandler;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.actors.DriveControl;



//This class controls all robot functions during the Autonomous period

public class AutonomousControl
{
    private final DriveControl driveControl;
    

    public  AutonomousControl(DriveControl driveControl)
    {
        this.driveControl =driveControl;
       
    }
   

    public void execute() //Called Periodically during Autonomous
    {
        Timer.getFPGATimestamp();
        System.out.println(Timer.getFPGATimestamp());
        
        if(Timer.getFPGATimestamp() <= 15)
        {
            this.driveControl.mecanumDrive(1,1,0,1);

        }
    }
}