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
    private final Timer gyroTime;
    private double gyroTIMMIE;
    

    public ShooterControl()
    {
        motor_shooterMotor = new PWMVictorSPX(PortMap.SHOOTER.portNumber);
        motor_groundShooter = new PWMVictorSPX(PortMap.SHOOTERGROUND.portNumber);
        motor_middleShooter = new PWMVictorSPX(PortMap.SHOOTERMIDDLE.portNumber);
        motor_shooterGyro = new PWMVictorSPX(PortMap.SHOOTERGYRO.portNumber);
        gyroTime = new Timer();
        gyroTIMMIE = gyroTime.get();

    }

    public void shoot(double _speed) //Turns the shooter motor with given speed
    {
        motor_groundShooter.set(_speed);
        motor_middleShooter.set(_speed);
        motor_shooterMotor.set(_speed);
    }
    public double shootTime()
    {
        gyroTIMMIE = gyroTime.get();
        return gyroTIMMIE;
    }
    
    public void shootAim(double runtime, double _speed)//Sets up a motor to turn the shooter 
    {

        if(gyroTime.hasElapsed(runtime + gyroTIMMIE))
        {
            motor_shooterGyro.set(0);
        }
        else
        {
            motor_shooterGyro.set(_speed);
        }
        
    }
}