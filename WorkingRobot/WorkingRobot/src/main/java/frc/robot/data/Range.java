package frc.robot.data;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Range
{
  //private final Ultrasonic ultrasonicSensor;
    private AnalogInput m_US;
    public Range ()
    {
       m_US = new AnalogInput(0);
    }

    public double getDistance()
    {
        double sensorValue = m_US.getVoltage();
        final double scaleFactor = 1/(5./1024.); //scale converting voltage to distance
        double distance = 5*sensorValue*scaleFactor; //converts raw data to mm?  
        double distanceReal = distance / 25.4; //convert the distances to inches
        return (distanceReal); 
    }
}