package frc.robot.actors;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.PWMVictorSPX;

//This class handles all drive control actions

public class DriveControl
{
    private final SpeedController motor_frontLeft;
    private final SpeedController motor_rearLeft;
    private final SpeedController motor_frontRight;
    private final SpeedController motor_rearRight;
    private final SpeedControllerGroup motorGroup_left;
    private final SpeedControllerGroup motorGroup_right;
    private final DifferentialDrive robotDrive;

    public DriveControl()
    {
        motor_frontLeft = new PWMVictorSPX(PortMap.FRONTLEFT.portNumber);
        motor_rearLeft = new PWMVictorSPX(PortMap.REARLEFT.portNumber);
        motor_frontRight = new PWMVictorSPX(PortMap.FRONTRIGHT.portNumber);
        motor_rearRight = new PWMVictorSPX(PortMap.REARRIGHT.portNumber);
        motorGroup_left = new SpeedControllerGroup(motor_frontLeft, motor_rearLeft);
        motorGroup_right = new SpeedControllerGroup(motor_frontRight, motor_rearRight);
        robotDrive = new DifferentialDrive(motorGroup_left, motorGroup_right);
    }

    public void tankDrive(double left, double right) //Moves the sets of wheels based on respective inputs
    {
        robotDrive.tankDrive(left, right);
    }
    public void arcadeCurvatureDrive(double speed, double turn) //Moves the sets of wheels with a speed and turning ratio
    {
        if(Math.abs(speed) > 0.1) //When the speed input is low enough, the robot switches to arcade, enabling turns in place
        {
            robotDrive.curvatureDrive(speed, turn, false);
        }
        else
        {
            robotDrive.arcadeDrive(0, turn);
        }
    }
}