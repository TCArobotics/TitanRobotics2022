package frc.robot.data;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import frc.robot.data.GripPipeline;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.cscore.AxisCamera;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobotBase;
import org.opencv.core.Rect;


/** Add your docs here. */
public class Camera
{
    private AxisCamera camera;
    private CvSink cvSink;
    private CvSource outputStream;
    private GripPipeline gripPipeline;
    private Rect rect;
    Mat source;
    Mat output;
    public Camera (String _name, String _host, int _xRes, int _yRes) 
    {
        camera = CameraServer.addAxisCamera(_name, _host);
        camera.setResolution(_xRes, _yRes);
        camera.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
        cvSink = CameraServer.getVideo();
        outputStream = CameraServer.putVideo(_name, _xRes, _yRes);
        gripPipeline = new GripPipeline();
        source = new Mat();
        output = new Mat();
    }

    public void processCamera()
    {
        cvSink.grabFrame(source);
        Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
        gripPipeline.process(output);
        rect = Imgproc.boundingRect(gripPipeline.filterContoursOutput().get(0));
    }

    public double getGoalYLocation()
    {
        if(!gripPipeline.filterContoursOutput().isEmpty())
        {
            return rect.y + (rect.height / 2);
        }
        else
        {
            return -1;
        }
    }
    public double getGoalXLocation()
    {
        if(!gripPipeline.filterContoursOutput().isEmpty())
        {
            return rect.x + (rect.width / 2);
        }
        else
        {
            return -1;
        }
    }
    //horizontal field of view 67 degrees, upper hub is 4 ft
    public double getGoalDistance()
    {
        if(!gripPipeline.filterContoursOutput().isEmpty())
        {
            return  rect.width;
        }
        else
        {
            return -1;
        }
    }
    public boolean isGoalVisible()
    {
        this.processCamera();
        return false;
    }
}
