package frc.robot.data;

import edu.wpi.first.wpilibj.Ultrasonic;


public class Range
{
    private final Ultrasonic ultrasonicSensor;
    public Range (int _pingChannel, int _echoChannel)
    {
        ultrasonicSensor = new Ultrasonic(_pingChannel, _echoChannel);
    }

    public double getDistance()
    {
        return ultrasonicSensor.getRangeInches();
    }
}