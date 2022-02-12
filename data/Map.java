package frc.robot.data;

import java.lang.Math;

public class Map 
{
    private Gyro gyro;

    public Map(Gyro _gyro)
    {
        gyro = _gyro;
    }
    
    public double calculatePosition()
    {

        //return gyro.getXPos();
        return gyro.getYPos();
        
    }

    public double dgoal()
    {
        return 5;
    }
    public double tgoal()
    {
        return 4;
    }

}
