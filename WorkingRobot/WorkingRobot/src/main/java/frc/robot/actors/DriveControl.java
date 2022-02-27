package frc.robot.actors;

import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

//This class handles all drive control actions

public class DriveControl
{
    private static MotorController motor_frontLeft;
    private static MotorController motor_rearLeft;
    private static MotorController motor_frontRight;
    private static MotorController motor_rearRight;
    private static double weightMultiplier;
    //private final MecanumDrive robotDrive;

    public DriveControl()
    {
        motor_frontLeft = new PWMVictorSPX(PortMap.FRONTLEFT.portNumber);
        motor_rearLeft = new PWMVictorSPX(PortMap.REARLEFT.portNumber);
        motor_frontRight = new PWMVictorSPX(PortMap.FRONTRIGHT.portNumber);
        motor_rearRight = new PWMVictorSPX(PortMap.REARRIGHT.portNumber);
        motor_frontRight.setInverted(true);
        motor_rearRight.setInverted(true);
        weightMultiplier = 1.1;
        //robotDrive = new MecanumDrive(motor_frontLeft, motor_rearLeft, motor_frontRight, motor_rearRight);
    }
    
    public static void mecanumDrive(double forwardSpeed, double sideSpeed, double zRotation, double speedMultiplier)
    {	
        //robotDrive.driveCartesian(forwardSpeed * speedMultiplier, sideSpeed * speedMultiplier, -zRotation * speedMultiplier);
        motor_frontLeft.set(speedMultiplier * (forwardSpeed + sideSpeed * weightMultiplier - zRotation));
        motor_frontRight.set(speedMultiplier * (forwardSpeed - sideSpeed * weightMultiplier + zRotation));
        motor_rearLeft.set(speedMultiplier * (forwardSpeed - sideSpeed / weightMultiplier - zRotation));
        motor_rearRight.set(speedMultiplier * (forwardSpeed + sideSpeed / weightMultiplier + zRotation));
    }
    public static void stop()
    {
        mecanumDrive(0, 0, 0, 0);
    }

}