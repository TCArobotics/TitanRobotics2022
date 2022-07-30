package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.actors.DriveControl;
import frc.robot.actors.ShooterControl;
import frc.robot.data.ButtonMap;
import frc.robot.data.GamePad;
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
    private final UsbCamera driverCam;
    private final UsbCamera shooterCam;
    private final VideoSink camServer;
    private double isIntakingDirection;
    private boolean isShooting;
    private double isExtendingDirection;
    private double drivingSpeed;
    private double shootingSpeed;
    private double intakingSpeed;
    private double extensionSpeed;

    public TeleopControl()
    {
        driveControl = new DriveControl();
        shooterControl = new ShooterControl();
        driverCam = CameraServer.startAutomaticCapture(0);
        shooterCam = CameraServer.startAutomaticCapture(1);
        camServer = CameraServer.getServer();
        camServer.setSource(driverCam);
        gamePad_0 = new GamePad(PortMap.GAMEPAD_0.portNumber);
        gamePad_1 = new GamePad(PortMap.GAMEPAD_1.portNumber);
        isIntakingDirection = 0;
        isShooting = false;
        isExtendingDirection = 0;
        drivingSpeed = 1;
        shootingSpeed = 1;
        intakingSpeed = 0.5;
        extensionSpeed = 1;
    }

    public void execute() //Called in Robot.teleopPeriodic(), Contains a single function for each major system on the robot
    {
        this.driveTrain(gamePad_0);
        this.shooter(gamePad_1);
        this.updateDashboard();
    }

    //controls shooter, intake, and climber
    public void shooter(GamePad _gamePad)
    {
        if(_gamePad.getButton(ButtonMap.A))
        {
            this.isIntakingDirection = (isIntakingDirection != 1) ? 1 : 0;
        }
        if(_gamePad.getButton(ButtonMap.B))
        {
            this.isShooting = !isShooting;
        }
        if(_gamePad.getButton(ButtonMap.RB))
        {
            this.isIntakingDirection = (isIntakingDirection != -1) ? -1 : 0;
            this.isShooting = false;
        }
        if(_gamePad.getButton(ButtonMap.X))
        {
            this.isExtendingDirection = (isExtendingDirection != 1) ? 1 : 0;
        }
        if(_gamePad.getButton(ButtonMap.Y))
        {
            this.isExtendingDirection = (isExtendingDirection != -3) ? -3 : 0;
        }
        if(_gamePad.getButton(ButtonMap.LB))
        {
            //shootingSpeed = (shootingSpeed == 1) ? .5 : 1;
            intakingSpeed = (intakingSpeed == .7) ? .5 : .7;
        }
        double leftStickX = _gamePad.getStick(ButtonMap.STICK_LEFTX);
        double rightStickY = _gamePad.getStick(ButtonMap.STICK_RIGHTY);

        this.shooterControl.extendClimber(isExtendingDirection * extensionSpeed);
        this.shooterControl.shoot(isShooting ? shootingSpeed: 0, isShooting ? shootingSpeed +  1.4 * leftStickX : 0, isShooting ? shootingSpeed - 1.4 * leftStickX : 0);
        this.shooterControl.intake(isIntakingDirection * intakingSpeed);
    }

    //Controls the drive train
    public void driveTrain(GamePad _gamePad)
    {
        double leftStickY = _gamePad.getStick(ButtonMap.STICK_LEFTY);
        double leftStickX = _gamePad.getStick(ButtonMap.STICK_LEFTX);
        double rightStickY = _gamePad.getStick(ButtonMap.STICK_RIGHTY);
        double rightStickX = _gamePad.getStick(ButtonMap.STICK_RIGHTX);

        if(_gamePad.getButton(ButtonMap.LB))
        {
            drivingSpeed = (drivingSpeed == 1) ? 0.5 : 1;
        }
        this.driveControl.tankDrive(leftStickY, rightStickY, drivingSpeed);
    }

    //puts important values on the dashboard
    public void updateDashboard()
    {
        SmartDashboard.putBoolean("Shooting", isShooting);
        SmartDashboard.putNumber("Intake direction", isIntakingDirection);
        SmartDashboard.putNumber("Extending direction", isExtendingDirection);
        SmartDashboard.putNumber("Shooting Speed", shootingSpeed);
        SmartDashboard.putNumber("Driving Speed", drivingSpeed);
    }
}