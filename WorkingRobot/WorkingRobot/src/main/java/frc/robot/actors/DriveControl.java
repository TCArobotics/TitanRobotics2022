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
 
    public DriveControl()
    {
        motor_frontLeft = new PWMVictorSPX(PortMap.FRONTLEFT.portNumber);
        motor_rearLeft = new PWMVictorSPX(PortMap.REARLEFT.portNumber);
        motor_frontRight = new PWMVictorSPX(PortMap.FRONTRIGHT.portNumber);
        motor_rearRight = new PWMVictorSPX(PortMap.REARRIGHT.portNumber);
        motor_frontLeft.setInverted(true);
        motor_rearLeft.setInverted(true);
    }
    
    //drive in a direction / turning direction
    public static void mecanumDrive(double ySpeed, double xSpeed, double zRotation, double speedMultiplier)
    {	
        motor_frontLeft.set(speedMultiplier * (ySpeed - xSpeed - zRotation));
        motor_frontRight.set(speedMultiplier * (ySpeed + xSpeed + zRotation));
        motor_rearLeft.set(speedMultiplier * (ySpeed + xSpeed - zRotation));
        motor_rearRight.set(speedMultiplier * (ySpeed - xSpeed + zRotation));
    }

    public static void tankDrive(double lSpeed, double rSpeed, double speedMultiplier)
    {
        motor_frontLeft.set(speedMultiplier * lSpeed);
        motor_frontRight.set(speedMultiplier * (-rSpeed));
        motor_rearLeft.set(speedMultiplier * lSpeed);
        motor_rearRight.set(speedMultiplier * (-rSpeed));

    }

    //stop all drive motors
    public static void stop()
    {
        mecanumDrive(0, 0, 0, 0);
    }


}