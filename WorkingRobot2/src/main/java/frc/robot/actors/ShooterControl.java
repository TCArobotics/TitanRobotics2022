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
    

    public ShooterControl()
    {
        motor_shooterMotorLeft = new PWMVictorSPX(PortMap.SHOOTER_LEFT.portNumber);
        motor_shooterMotorRight = new PWMVictorSPX(PortMap.SHOOTER_RIGHT.portNumber);
        motor_shooterMotorFront = new PWMVictorSPX(PortMap.SHOOTER_FRONT.portNumber);
        motor_shooterMotorBack = new PWMVictorSPX(PortMap.SHOOTER_BACK.portNumber);
        motor_shooterMotorIntake = new PWMVictorSPX(PortMap.SHOOTER_INTAKE.portNumber);
        motor_shooterMotorFront.setInverted(true);
        motor_shooterMotorLeft.setInverted(true);
    }

    public void intake(double _speed)
    {
        motor_shooterMotorIntake.set(-_speed);
    }
    
    public void shoot(double _leftStickX, double _leftStickY, double _speed) //0 = forward, counterclockwise positive
    {
        motor_shooterMotorFront.set((_leftStickY > 0) ? _leftStickY * _speed : 0);
        motor_shooterMotorLeft.set((_leftStickX < 0) ? _leftStickX * _speed : 0);
        motor_shooterMotorBack.set((_leftStickY < 0) ? _leftStickY * _speed : 0);
        motor_shooterMotorRight.set((_leftStickX > 0) ? _leftStickX * _speed : 0);
    }
}