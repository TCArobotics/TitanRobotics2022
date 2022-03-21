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

    public static void intake(double _speed)
    {
        motor_shooterMotorIntakeLeft.set(_speed);
        motor_shooterMotorIntakeRight.set(_speed);
    }
    
    public static void extendClimber(double _speed)
    {
        motor_climberMotor.set(_speed);
    }

    public static void shoot(double _speed)
    {
            motor_shooterMotorBack.set(5*_speed);
            motor_shooterMotorLeft.set(5*_speed);
            motor_shooterMotorFront.set(5*_speed);
    }
    public static void stop()
    {
        shoot(0);
        extendClimber(0);
        intake(0);
    }
}