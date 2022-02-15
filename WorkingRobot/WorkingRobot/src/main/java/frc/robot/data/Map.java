package frc.robot.data;

import java.lang.Math;

public class Map 
{
    private Gyro gyro;

    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;

    public Map(Gyro _gyro)
    {
        gyro = _gyro;
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;
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
