package frc.robot;

import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.ButtonMap;
import frc.robot.data.GamePad;

//This class controls all robot functions during Teleop
//It's major role his determining what abstract actions the robot should be taking
//Before offloading tasks to individual handlers such as Drive Control

public class TeleopControl
{
    private final DriveControl driveControl;
    private final ShooterControl shooterControl;
    private final GamePad gamePad;

    private boolean isFiring;

    public TeleopControl()
    {
        driveControl = new DriveControl();
        shooterControl = new ShooterControl();
        gamePad = new GamePad();

        isFiring = false;
    }

    public void execute() //Called in Robot.teleopPeriodic(), Contains a single function for each major system on the robot
    {
        this.driveTrain();
        this.shooter();
    }

    public void shooter() //Controls the shooter--Triggers only ONE execution line
    {
        if(gamePad.getButton(ButtonMap.A))
        {
            this.isFiring = !isFiring;
        }

        this.shooterControl.shoot(1); //EXECUTION LINE
    }

    public void driveTrain() //Controls the drive train--triggers only ONE execution line
    {
        double leftInput = gamePad.getStick(ButtonMap.STICK_LEFTY);
        double rightInput = gamePad.getStick(ButtonMap.STICK_RIGHTY);

        this.driveControl.tankDrive(leftInput, rightInput); //EXECUTiON LINE
    }
    public void mecanumDrive()
    {
        double leftStickX = gamePad.getStick(ButtonMap.STICK_LEFTY);
        double leftStickY
    }

}