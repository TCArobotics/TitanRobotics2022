package frc.robot.data;

import edu.wpi.first.wpilibj.AnalogInput;

public class Range
{
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