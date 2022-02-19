package frc.robot.data;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.data.Range;

//Place holder class for all sensors including literal sensors like gyroscopes and figurative sensors like position tracking

public class Sensor
{
    private final Range range;

    public Sensor()
    {
        range = new Range();
        System.out.println(range.getDistance());
    }
}