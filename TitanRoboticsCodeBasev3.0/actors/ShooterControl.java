package frc.robot.actors;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.Timer;


//This class handles all actions related to the shooter system

public class ShooterControl
{
    private final MotorController motor_shooterMotor;
    private final MotorController motor_groundShooter;
    private final MotorController motor_middleShooter;
    private final MotorController motor_shooterGyro;
    

    public ShooterControl()
    {
        motor_shooterMotor = new PWMVictorSPX(PortMap.SHOOTER.portNumber);
        motor_groundShooter = new PWMVictorSPX(PortMap.SHOOTERGROUND.portNumber);
        motor_middleShooter = new PWMVictorSPX(PortMap.SHOOTERMIDDLE.portNumber);
        motor_shooterGyro = new PWMVictorSPX(PortMap.SHOOTERGYRO.portNumber);

    }

    public void shoot(double _speed) //Turns the shooter motor with given speed
    {
        motor_groundShooter.set(_speed);
        motor_middleShooter.set(_speed);
        motor_shooterMotor.set(_speed);
    }
    
    public void shootAim(double runtime, double _speed)
    {
        Timer.reset();
        motor_shooterGyro.set(_speed);
        motor_shooterGyro.set(0);
    }
}