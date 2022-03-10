package frc.robot.data;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import frc.robot.data.GripPipeline;

/** Add your docs here. */
public class Camera
{
    private UsbCamera camera;
    private VideoSink server;
    public Camera (int _portNumber) 
    {
        camera = CameraServer.startAutomaticCapture();
        server = CameraServer.getServer();
        server.setSource(camera);
        camera.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
        
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
