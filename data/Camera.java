// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.data;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;

/** Add your docs here. */
public class Camera
{
    private UsbCamera camera;
    private VideoSink server;
    public Camera (int _portNumber) 
    {
        camera = CameraServer.startAutomaticCapture(_portNumber);
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