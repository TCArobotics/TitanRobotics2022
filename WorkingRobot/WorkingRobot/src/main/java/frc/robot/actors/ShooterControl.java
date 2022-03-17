package frc.robot.actors;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.data.PortMap;


//This class handles all actions related to the shooter system

public class ShooterControl
{
    private final MotorController motor_shooterMotorIntake;
    private final MotorController motor_shooterMotorLeft;
    private final MotorController motor_shooterMotorRight;
    private final MotorController motor_shooterMotorFront;
    private final MotorController motor_shooterMotorBack;
    private final MotorController motor_climberMotor;
    

    public ShooterControl()
    {
        motor_shooterMotorLeft = new PWMVictorSPX(PortMap.SHOOTER_LEFT.portNumber);
        motor_shooterMotorRight = new PWMVictorSPX(PortMap.SHOOTER_RIGHT.portNumber);
        motor_shooterMotorFront = new PWMVictorSPX(PortMap.SHOOTER_FRONT.portNumber);
        motor_shooterMotorBack = new PWMVictorSPX(PortMap.SHOOTER_BACK.portNumber);
        motor_climberMotor = new PWMVictorSPX(PortMap.CLIMBER.portNumber);
        motor_shooterMotorIntake = new PWMVictorSPX(PortMap.SHOOTER_INTAKE.portNumber);
        motor_shooterMotorRight.setInverted(true);
    }

    public void intake(double _speed)
    {
        motor_shooterMotorIntake.set(-_speed);
    }
    
    public void extendClimber(double _speed)
    {
        motor_climberMotor.set(_speed);
    }

    public void shoot(double _speed)
    {
            motor_shooterMotorBack.set(_speed);
            motor_shooterMotorLeft.set(_speed);
            motor_shooterMotorFront.set(_speed);
            motor_shooterMotorRight.set(_speed);
    }
}