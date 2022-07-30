package frc.robot.actors;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.data.PortMap;


//This class handles all actions related to the shooter system

public class ShooterControl
{
    private static MotorController motor_shooterMotorIntakeLeft;
    private static MotorController motor_shooterMotorIntakeRight;
    private static MotorController motor_shooterMotorLeft;
    private static MotorController motor_shooterMotorFront;
    private static MotorController motor_shooterMotorBack;
    private static MotorController motor_climberMotor;
    

    public ShooterControl()
    {
        motor_shooterMotorLeft = new PWMVictorSPX(PortMap.SHOOTER_LEFT.portNumber);
        motor_shooterMotorFront = new PWMVictorSPX(PortMap.SHOOTER_FRONT.portNumber);
        motor_shooterMotorBack = new PWMVictorSPX(PortMap.SHOOTER_BACK.portNumber);
        motor_climberMotor = new PWMVictorSPX(PortMap.CLIMBER.portNumber);
        motor_shooterMotorIntakeLeft = new PWMVictorSPX(PortMap.SHOOTER_INTAKE_LEFT.portNumber);
        motor_shooterMotorIntakeRight = new PWMVictorSPX(PortMap.SHOOTER_INTAKE_RIGHT.portNumber);
        motor_shooterMotorIntakeLeft.setInverted(true);
    }

    //turn on intake motors, must be at the same speed to avoid damage
    public static void intake(double _speed)
    {
        motor_shooterMotorIntakeLeft.set(_speed);
        motor_shooterMotorIntakeRight.set(_speed);
    }
    
    //for extending and retracting climber motor
    public static void extendClimber(double _speed)
    {
        motor_climberMotor.set(_speed);
    }

    //turn on shooter motors each with varying power. Default coefficient is 5.
    public static void shoot(double _leftSpeed, double _midSpeed, double _rightSpeed)
    {
            motor_shooterMotorBack.set(5*_midSpeed);
            motor_shooterMotorLeft.set(5*_leftSpeed);
            motor_shooterMotorFront.set(5*_rightSpeed);
    }

    //stop all systems in ShooterControl
    public static void stop()
    {
        shoot(0, 0, 0);
        extendClimber(0);
        intake(0);
    }
}