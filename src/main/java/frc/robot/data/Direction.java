package frc.robot.data;

import com.kauailabs.navx.frc.AHRS;

public class Direction
{
    public class Accelerometer
    {
        public double xSpeed;
        public double zSpeed;
        private AHRS ahrs;
        public Accelerometer()
        {
            this.xSpeed=ahrs.getWorldLinearAccelX();
            this.zSpeed=ahrs.getWorldLinearAccelZ();
        }
    }
    private double Degree;
    private AHRS ahrs;
    public class Gyroscope 
    {
        public Gyroscope()
        {
            
        }
    }
    
    private double Value;
    public class Map
    {
        public Map()
        {
            
        }
    }

    public class Encoder
    {
        public Encoder()
        { 

        }
    }
}