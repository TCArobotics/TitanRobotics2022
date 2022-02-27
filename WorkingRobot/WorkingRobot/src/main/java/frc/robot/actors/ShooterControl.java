package frc.robot.actors;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.data.PortMap;
import frc.robot.data.Camera;
import java.lang.Math;


//This class handles all actions related to the shooter system

public class ShooterControl
{
    private static MotorController motor_shooterMotor;
    private static MotorController motor_groundShooter;
    private static MotorController motor_middleShooter;
    private static MotorController motor_shooterRotation;
    private static Camera cameraShooter;
    

    public ShooterControl()
    {
        motor_shooterMotor = new PWMVictorSPX(PortMap.SHOOTER.portNumber);
        motor_groundShooter = new PWMVictorSPX(PortMap.SHOOTER_GROUND.portNumber);
        motor_middleShooter = new PWMVictorSPX(PortMap.SHOOTER_MIDDLE.portNumber);
        motor_shooterRotation = new PWMVictorSPX(PortMap.SHOOTER_ROTATION.portNumber);
        cameraShooter = new Camera(PortMap.CAMERA_SHOOTER.portNumber);
    }

    public static void shoot(double _speed) //Turns the shooter motor with given speed
    {
        motor_groundShooter.set(_speed);
        motor_middleShooter.set(_speed);
        motor_shooterMotor.set(_speed);
    }

    public static void stop()
    {
        motor_groundShooter.set(0);
        motor_middleShooter.set(0);
        motor_shooterMotor.set(0);
        motor_shooterRotation.set(0);
    }
    
    public static void rotateManual(double _speed)
    {
        motor_shooterRotation.set(_speed);
    }

    public static void rotateLockOn()
    {
        if (cameraShooter.isGoalVisible())
        {
            motor_shooterRotation.set(1);
        }
        else
        {
            if(Math.abs(cameraShooter.getGoalXLocation()) < .1)
            {
                motor_shooterRotation.set(cameraShooter.getGoalXLocation());
            }
        }
    }
}