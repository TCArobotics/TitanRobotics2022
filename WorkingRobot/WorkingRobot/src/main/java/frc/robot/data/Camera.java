package frc.robot.data;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import frc.robot.data.GripPipeline;
import edu.wpi.first.cscore.UsbCamera;

/*import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;*/


/** Add your docs here. */
public class Camera
{
    private UsbCamera camera;
    private VideoSink server;
    public Camera (int _portNumber) 
    {
        
    }
    public double getGoalYLocation()
    {
        
        //placeholder code
        return -1;
    }
    public double getGoalXLocation()
    {
        //placeholder code
        return -1;
    }
    public boolean isGoalVisible()
    {
        //placeholder code
        return false;
    }
}
