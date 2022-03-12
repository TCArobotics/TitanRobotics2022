package frc.robot;

import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.ButtonMap;
import frc.robot.data.GamePad;
import frc.robot.data.Gyro;
import frc.robot.data.PortMap;
import frc.robot.data.Sensor;
import frc.robot.data.Range;
import frc.robot.data.GripPipeline;

//This class controls all robot functions during Teleop
//It's major role his determining what abstract actions the robot should be taking
//Before offloading tasks to individual handlers such as Drive Control

public class TeleopControl
{
    private final Range range;
    private final DriveControl driveControl;
    private final ShooterControl shooterControl;
    private final GamePad gamePad_0;
    private final GamePad gamePad_1;
    private final Gyro gyro;
    private boolean isIntaking;
    private double drivingSpeed;
    private double shootingSpeed;

    public TeleopControl()
    {
        range = new Range();
        driveControl = new DriveControl();
        shooterControl = new ShooterControl();
        gamePad_0 = new GamePad(PortMap.GAMEPAD_0.portNumber);
        gamePad_1 = new GamePad(PortMap.GAMEPAD_1.portNumber);
        gyro = new Gyro();
        isIntaking = false;
        drivingSpeed = .5;
        shootingSpeed = 1;
    }

    public void execute() //Called in Robot.teleopPeriodic(), Contains a single function for each major system on the robot
    {
        //GripPipeline.process(); //Use CameraServer to create Matrix input
        this.driveTrain(gamePad_0);
        this.shooter(gamePad_0);
        // System.out.println(ahrs.getYaw());
        // System.out.println(ahrs.getXAccel());
        // System.out.println(ahrs.getXPos());
        // System.out.println(ahrs.getYAccel());
        // System.out.println(ahrs.getYpos());
        //System.out.println(range.getDistance());
    }

    public void shooter(GamePad _shooterGamePad) //Controls the shooter--Triggers only ONE execution line
    {
        // Determine if the shooter should be firing and alert the shooterControl
        if(_shooterGamePad.getButton(ButtonMap.A))
        {
            this.isIntaking = !isIntaking;
        }

        if(_shooterGamePad.getButton(ButtonMap.LB))
        {
            shootingSpeed = (shootingSpeed == 1) ? 0.5 : 1;
        }

        this.shooterControl.intake(isIntaking ? 2 : 0);

        double leftStickY = -_shooterGamePad.getStick(ButtonMap.STICK_LEFTY);
        double leftStickX = _shooterGamePad.getStick(ButtonMap.STICK_LEFTX);
        this.shooterControl.shoot(leftStickX, leftStickY, shootingSpeed);
    }

    public void driveTrain(GamePad _driverGamePad) //Controls the drive train--triggers only ONE execution line
    {
        double leftStickY = _driverGamePad.getStick(ButtonMap.STICK_LEFTY);
        double leftStickX = _driverGamePad.getStick(ButtonMap.STICK_LEFTX);
        double rightStickX = _driverGamePad.getStick(ButtonMap.STICK_RIGHTX);

        if(_driverGamePad.getButton(ButtonMap.LB))
        {
            drivingSpeed = (drivingSpeed == 1) ? 0.5 : 1;
        }

        this.driveControl.mecanumDrive(leftStickY, leftStickX, rightStickX, drivingSpeed);
    }
}
