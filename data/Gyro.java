package frc.robot.data;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class Gyro {
    private final AHRS ahrs;

    public Gyro()
    {
        ahrs = new AHRS(SPI.Port.kMXP);
    }
    public boolean isConnected()
    {
        return ahrs.isConnected();
    }
    public double getXAccel()
    {
        return this.ahrs.getWorldLinearAccelX();
    }
    public double getYAccel()
    {
        return this.ahrs.getWorldLinearAccelY();
    }
    public double getYaw()
    {
        return this.ahrs.getYaw();
    }
    public double getXPos()
    {
        return this.ahrs.getDisplacementX();
    }
    public double getYpos()
    {
        return this.ahrs.getDisplacementY();
    }

}
