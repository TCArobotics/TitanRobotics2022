package frc.robot.data;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.revrobotics.ColorMatch;

public class SensorColor {
  private final I2C.Port i2cPort;
  private final ColorSensorV3 m_colorSensor;
  private final ColorMatch m_colorMatcher;
  private final Color kBlueTarget;
  private final Color kGreenTarget;
  private final Color kRedTarget;
  private final Color kYellowTarget;

  public SensorColor()
  {
    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);
    m_colorMatcher = new ColorMatch();
    kBlueTarget = new Color(0.143, 0.427, 0.429);
    kGreenTarget = new Color(0.197, 0.561, 0.240);
    kRedTarget = new Color(0.561, 0.232, 0.114);
    kYellowTarget = new Color(0.361, 0.524, 0.113);
  }

  public void initiate() {
      m_colorMatcher.addColorMatch(kBlueTarget);
      m_colorMatcher.addColorMatch(kGreenTarget);
      m_colorMatcher.addColorMatch(kRedTarget);
      m_colorMatcher.addColorMatch(kYellowTarget);  
  }

  public void getColor() 
  {
      Color detectedColor = m_colorSensor.getColor();

      /**
       * Run the color match algorithm on our detected color
       */
      String colorString;
      ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

      /*switch(match.color)
      {
        case kBlueTarget:
          colorString = "Blue";
          break;
        case kRedTarget:
          colorString = "Red";
          break;
        case kGreenTarget:
          colorString = "Green";
          break;
        case kYellowTarget:
          colorString = "Yellow";
          break;
        default:
          colorString = "Unknown";
          break;
      }*/
      /**
       * Open Smart Dashboard or Shuffleboard to see the color detected by the 
       * sensor.
       */
      colorString = "M Night Shaymalan";
      SmartDashboard.putNumber("Red", detectedColor.red);
      SmartDashboard.putNumber("Green", detectedColor.green);
      SmartDashboard.putNumber("Blue", detectedColor.blue);
      SmartDashboard.putNumber("Confidence", match.confidence);
      SmartDashboard.putString("Detected Color", colorString);
  }
}