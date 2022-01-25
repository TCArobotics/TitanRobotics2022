package frc.robot.actors;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.data.PortMap;

//This class handles all actions related to the shooter system

public class ShooterControl
{
    private final MotorController motor_shooterMotor;
    public ShooterControl()
    {
        motor_shooterMotor = new PWMVictorSPX(PortMap.SHOOTER.portNumber);
    }

    public void shoot(double _speed) //Turns the shooter motor with given speed
    {
        motor_shooterMotor.set(_speed);
    }
}