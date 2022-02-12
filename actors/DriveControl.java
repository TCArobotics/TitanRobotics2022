package frc.robot.actors;

import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

//This class handles all drive control actions

public class DriveControl
{
    private final MotorController motor_frontLeft;
    private final MotorController motor_rearLeft;
    private final MotorController motor_frontRight;
    private final MotorController motor_rearRight;
    private final MecanumDrive robotDrive;

    public DriveControl()
    {
        motor_frontLeft = new PWMVictorSPX(PortMap.FRONTLEFT.portNumber);
        motor_rearLeft = new PWMVictorSPX(PortMap.REARLEFT.portNumber);
        motor_frontRight = new PWMVictorSPX(PortMap.FRONTRIGHT.portNumber);
        motor_rearRight = new PWMVictorSPX(PortMap.REARRIGHT.portNumber);
        motor_frontLeft.setInverted(true);
        motor_rearLeft.setInverted(true);
        robotDrive = new MecanumDrive(motor_frontLeft, motor_rearLeft, motor_frontRight, motor_rearRight);
    }
    
    public void mecanumDrive(double ySpeed, double xSpeed, double zRotation, double speedMultiplier)
    {	
        robotDrive.driveCartesian(ySpeed * speedMultiplier, xSpeed * speedMultiplier, -zRotation * speedMultiplier);
    }
}