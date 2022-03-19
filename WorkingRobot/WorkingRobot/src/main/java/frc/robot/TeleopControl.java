package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.ButtonMap;
import frc.robot.data.GamePad;
import frc.robot.data.Gyro;
import frc.robot.data.PortMap;
import frc.robot.data.Sensor;
import frc.robot.data.Range;
import frc.robot.data.GripPipeline;
import frc.robot.data.Camera;
import frc.robot.data.SensorColor;

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
    private final Camera visionCam;
    //private final UsbCamera driverCam;
    //private final VideoSink driverCamServer;
    private final SensorColor sensorColor;
    private int isIntakingDirection;
    private boolean isShooting;
    private int isExtendingDirection;
    private double drivingSpeed;
    private double shootingSpeed;
    private double extensionSpeed;

    public TeleopControl()
    {
        range = new Range();
        driveControl = new DriveControl();
        shooterControl = new ShooterControl();
        sensorColor = new SensorColor();
        //driverCam = CameraServer.startAutomaticCapture(1);
        //driverCamServer = CameraServer.getServer();
        //driverCamServer.setSource(driverCam);
        visionCam = new Camera("VisionCamera", "10.83.34.61", 400, 300);
        gamePad_0 = new GamePad(PortMap.GAMEPAD_0.portNumber);
        gamePad_1 = new GamePad(PortMap.GAMEPAD_1.portNumber);
        gyro = new Gyro();
        isIntakingDirection = 0;
        isShooting = false;
        isExtendingDirection = 0;
        drivingSpeed = .5;
        shootingSpeed = 1;
        extensionSpeed = .5;
    }

    public void execute() //Called in Robot.teleopPeriodic(), Contains a single function for each major system on the robot
    {
        //GripPipeline.process(); //Use CameraServer to create Matrix input
        this.driveTrain(gamePad_0);
        this.shooter(gamePad_1);
        sensorColor.getColor();
        //visionCam.processCamera();
        //visionCam.getGoalDistance();
    }

    public void shooter(GamePad _gamePad) //Controls the shooter--Triggers only ONE execution line
    {
        // Determine if the shooter should be firing and alert the shooterControl
        if(_gamePad.getButton(ButtonMap.A))
        {
            this.isIntakingDirection = (isIntakingDirection != 1) ? 1 : 0;
            this.isShooting = !isShooting;
        }
        if(_gamePad.getButton(ButtonMap.B))
        {
            this.isIntakingDirection = (isIntakingDirection != 1) ? -1 : 0;
        }
        if(_gamePad.getButton(ButtonMap.X))
        {
            this.isExtendingDirection = (isExtendingDirection != 1) ? 1 : 0;
        }
        if(_gamePad.getButton(ButtonMap.Y))
        {
            this.isExtendingDirection = (isExtendingDirection != -1) ? -1 : 0;
        }
        if(_gamePad.getButton(ButtonMap.LB))
        {
            shootingSpeed = (shootingSpeed == 1) ? 0.5 : 1;
        }
        this.shooterControl.extendClimber(isExtendingDirection * extensionSpeed);
        this.shooterControl.shoot(isShooting ? shootingSpeed : 0);
        this.shooterControl.intake(isIntakingDirection * 30);
    }

    public void driveTrain(GamePad _gamePad) //Controls the drive train--triggers only ONE execution line
    {
        double leftStickY = _gamePad.getStick(ButtonMap.STICK_LEFTY);
        double leftStickX = _gamePad.getStick(ButtonMap.STICK_LEFTX);
        double rightStickX = _gamePad.getStick(ButtonMap.STICK_RIGHTX);

        if(_gamePad.getButton(ButtonMap.LB))
        {
            drivingSpeed = (drivingSpeed == 1) ? 0.5 : 1;
        }

        this.driveControl.mecanumDrive(leftStickY, leftStickX, rightStickX, drivingSpeed);
    }

    public void updateDashboard()
    {
        SmartDashboard.putBoolean("Shooting", isShooting);
        SmartDashboard.putNumber("Intake direction", isIntakingDirection);
        SmartDashboard.putNumber("Extending direction", isExtendingDirection);
    }
}