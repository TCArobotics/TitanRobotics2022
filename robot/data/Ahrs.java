package frc.robot.data;

import com.kauailabs.navx.frc.AHRS;

public class Ahrs {
    private final AHRS ahrs;

    public Ahrs()
    {
        ahrs = new AHRS();
        System.out.println(ahrs.isConnected());
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
