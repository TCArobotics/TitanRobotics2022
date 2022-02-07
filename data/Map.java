package frc.robot.data;

import java.lang.Math;

public class Map 
{
    private Ahrs ahrs;

    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;

    public Map(Ahrs _ahrs)
    {
        ahrs = _ahrs;
        xPosition = 0;
        yPosition = 0;
        xVelocity = 0;
        yVelocity = 0;
    }
    
    public void calculatePosition()
    {
        
    }
}
