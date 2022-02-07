package frc.robot.data;

import com.kauailabs.navx.frc.AHRS;

public class Ahrs {
    private final AHRS ahrs;

    public Ahrs()
    {
        ahrs = new AHRS();
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
}
