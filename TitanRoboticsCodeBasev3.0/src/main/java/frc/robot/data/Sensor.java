package frc.robot.data;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

//Place holder class for all sensors including literal sensors like gyroscopes and figurative sensors like position tracking

public class Sensor
{
    AHRS gyro;
    public Sensor()
    {
        gyro = new AHRS(SPI.Port.kMXP);
    }
}