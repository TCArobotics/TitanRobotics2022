/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  private static final String kMoveBackAuto = "Move back";
  private static final String kShootAuto = "Move back and shoot";
  private static final String kDeliverAuto = "Deliver ball";
  private static final String kWait0 = "0s";
  private static final String kWait5 = "5s";
  private static final String kWait10 = "10s";
  private String m_autoSelected;
  private String m_autoWait;
  private double startTime;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private final SendableChooser<String> m_chooser2 = new SendableChooser<>();

  private TeleopControl teleopControl;
  private AutonomousControl autonomousControl;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    m_chooser.setDefaultOption("Move Back", kMoveBackAuto);
    m_chooser.addOption("Shoot and move back", kShootAuto);
    m_chooser.addOption("Deliver ball", kDeliverAuto);
    m_chooser2.setDefaultOption("0s", kWait0);
    m_chooser2.addOption("5s", kWait5);
    m_chooser2.addOption("10s", kWait10);
    SmartDashboard.putData("Auto choices", m_chooser);
    SmartDashboard.putData("Auto wait time", m_chooser2);

    teleopControl = new TeleopControl();
    autonomousControl = new AutonomousControl();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() 
  {
    m_autoSelected = m_chooser.getSelected();
    m_autoWait = m_chooser2.getSelected();
    startTime = Timer.getFPGATimestamp();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic()
  {
    System.out.println(Timer.getFPGATimestamp());
    int waitTime;
    switch(m_autoWait)
    {
      case kWait0:
        waitTime = 0;
        break;
      case kWait5:
        waitTime = 5;
        break;
      case kWait10:
        waitTime = 10;
        break;
      default:
        waitTime = 0;
        break;
    }

    switch (m_autoSelected) 
    {
      case kMoveBackAuto:
        // Put custom auto code here
        autonomousControl.moveBackChoice(startTime, waitTime);
        break;
      case kDeliverAuto:
        autonomousControl.deliverBallChoice(startTime, waitTime);
        break;
      case kShootAuto:
        autonomousControl.shootChoice(startTime, waitTime);
        break;
      default:
        autonomousControl.moveBackChoice(startTime, waitTime);
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    teleopControl.execute();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {

  }
}
