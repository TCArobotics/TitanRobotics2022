package frc.robot;

import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.ButtonMap;
import frc.robot.data.GamePad;
import frc.robot.data.Gyro;
import frc.robot.data.Map;
import frc.robot.data.PortMap;

//This class controls all robot functions during Teleop
//It's major role his determining what abstract actions the robot should be taking
//Before offloading tasks to individual handlers such as Drive Control

public class TeleopControl
{
    private final DriveControl driveControl;
    private final ShooterControl shooterControl;
    private final GamePad gamePad_0;
    private final GamePad gamePad_1;
    private final Gyro gyro;
    private final Map map;
    private boolean isFiring;
    private double speed;

    public TeleopControl()
    {
        driveControl = new DriveControl();
        shooterControl = new ShooterControl();
        gamePad_0 = new GamePad(PortMap.GAMEPAD_0.portNumber);
        gamePad_1 = new GamePad(PortMap.GAMEPAD_1.portNumber);
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
        this.shooterRotation();
        // System.out.println(ahrs.getYaw());
        // System.out.println(ahrs.getXAccel());
        // System.out.println(ahrs.getXPos());
        // System.out.println(ahrs.getYAccel());
        // System.out.println(ahrs.getYpos());
    }

    public void shooter() //Controls the shooter--Triggers only ONE execution line
    {
        
        if(gamePad_0.getButton(ButtonMap.A))
        {
            this.isFiring = !isFiring;
        }

        this.shooterControl.shoot(isFiring ? 1 : 0);
        
        shooterControl.rotate(gamePad_0.getStick(ButtonMap.TRIGGER_LEFT) - gamePad_0.getStick(ButtonMap.TRIGGER_RIGHT));
    }

    public void shootAim()
    {
        if(gamePad_0.getButton(ButtonMap.Y))
        {
            System.out.println(gyro.getYaw()); //temporary test function
            this.shooterControl.shootAim(5,1);
        }
    }

    public void driveTrain() //Controls the drive train--triggers only ONE execution line
    {
        double leftStickY = gamePad_0.getStick(ButtonMap.STICK_LEFTY);
        double leftStickX = gamePad_0.getStick(ButtonMap.STICK_LEFTX);
        double rightStickX = gamePad_0.getStick(ButtonMap.STICK_RIGHTX);

        if(gamePad_0.getButton(ButtonMap.LB))
        {
            speed = (speed == 1) ? 0.5 : 1;
        }

        this.driveControl.mecanumDrive(leftStickY, leftStickX, rightStickX, speed);
    }
    private double rtGoal()
    {
        return 5;
    }
    public void shooterRotation()
    {
        double rightStickX = gamePad_1.getStick(ButtonMap.STICK_RIGHTX);

        this.shooterControl.rotate(rightStickX);
    }
}