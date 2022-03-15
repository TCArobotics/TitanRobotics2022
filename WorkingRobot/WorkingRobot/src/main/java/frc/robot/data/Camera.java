package frc.robot.data;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import frc.robot.data.GripPipeline;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobotBase;


/** Add your docs here. */
public class Camera
{
    private UsbCamera camera;
    private CvSink cvSink;
    private CvSource outputStream;
    Mat source;
    Mat output;
    public Camera (int _portNumber) 
    {
        camera = CameraServer.startAutomaticCapture();
        camera.setResolution(800,600);
        cvSink = CameraServer.getVideo();
        outputStream = CameraServer.putVideo("ShooterCam", 800, 600);
        source = new Mat();
        output = new Mat();
    }

    public Mat getVideoAsMat()
    {
        cvSink.grabFrame(source);
        Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
        return output;
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
