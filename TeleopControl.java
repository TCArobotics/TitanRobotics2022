package frc.robot;

import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.ButtonMap;
import frc.robot.data.GamePad;
import frc.robot.data.Gyro;
import frc.robot.data.Map;

//This class controls all robot functions during Teleop
//It's major role his determining what abstract actions the robot should be taking
//Before offloading tasks to individual handlers such as Drive Control

public class TeleopControl
{
    private final DriveControl driveControl;
    private final ShooterControl shooterControl;
    private final GamePad gamePad;
    private final Gyro gyro;
    private final Map map;
    private boolean isFiring;
    private double speed;

    public TeleopControl()
    {
        driveControl = new DriveControl();
        shooterControl = new ShooterControl();
        gamePad = new GamePad();
        gyro = new Gyro();
        map = new Map(gyro);
        isFiring = false;
        speed = 1;
    }

    public void execute() //Called in Robot.teleopPeriodic(), Contains a single function for each major system on the robot
    {
        this.driveTrain();
        this.shooter();
        this.shootAim();
        // System.out.println(ahrs.getYaw());
       // System.out.println(ahrs.getXAccel());
       // System.out.println(ahrs.getXPos());
       // System.out.println(ahrs.getYAccel());
       // System.out.println(ahrs.getYpos());
    }

    public void shooter() //Controls the shooter--Triggers only ONE execution line
    {
        
        if(gamePad.getButton(ButtonMap.A))
        {
            this.isFiring = !isFiring;
        }

        this.shooterControl.shoot(isFiring ? 1 : 0);
        
        shooterControl.rotate(gamePad.getStick(ButtonMap.TRIGGER_LEFT) - gamePad.getStick(ButtonMap.TRIGGER_RIGHT));
    }

    public void shootAim()
    {
        if(gamePad.getButton(ButtonMap.Y))
        {
            System.out.println(gyro.getYaw()); //temporary test function
            this.shooterControl.shootAim(5,1);
        }
    }

    public void driveTrain() //Controls the drive train--triggers only ONE execution line
    {
        double leftStickY = gamePad.getStick(ButtonMap.STICK_LEFTY);
        double leftStickX = gamePad.getStick(ButtonMap.STICK_LEFTX);
        double rightStickX = gamePad.getStick(ButtonMap.STICK_RIGHTX);

        if(gamePad.getButton(ButtonMap.LB))
        {
            speed = (speed == 1) ? 0.5 : 1;
        }

        this.driveControl.mecanumDrive(leftStickY, leftStickX, rightStickX, speed);
    }
    private double rtGoal()
    {
        return 5;
    }
}