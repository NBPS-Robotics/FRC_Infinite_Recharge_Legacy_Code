package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  // The motors on drive system
  public static CANSparkMax m_frontLeftMotor = new CANSparkMax(DriveConstants.kFrontLeftWheelPort, MotorType.kBrushless);
  public static CANSparkMax m_frontRightMotor = new CANSparkMax(DriveConstants.kFrontRightWheelPort, MotorType.kBrushless);
  public static CANSparkMax m_backLeftMotor = new CANSparkMax(DriveConstants.kBackLeftWheelPort, MotorType.kBrushless);
  public static CANSparkMax m_backRightMotor = new CANSparkMax(DriveConstants.kBackRightWheelPort, MotorType.kBrushless);
  

  private MecanumDrive m_drive = new MecanumDrive(m_frontLeftMotor, m_backLeftMotor, m_frontRightMotor, m_backRightMotor);
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    m_drive.setSafetyEnabled(false);
  }

  /**
   * Drives the robot using base mecanum (y stick 1 = forward, x stick 1 = sideways, x stick 2 = rotation)
   *
   * @param x = speed in x direction
   * @param y = speed in y direction
   * @param c = rotation speed
   */
  public void mecanumDrive(double x, double y, double c) {
    m_drive.driveCartesian(x,-y,c);
  }
  /**
   * Drives the robot using base mecanum (y stick 1 = forward, x stick 1 = sideways, x stick 2 = rotation)
   * This, however, is in relation to the field instead of the robot
   * @param x = speed in x direction
   * @param y = speed in y direction
   * @param c = rotation speed
   * @param theta = navx gyro angle
   */
  public void mecanumDriveGyro(double x, double y, double c, double theta)
  {
      m_drive.driveCartesian(-x, y, c, theta);
  }
}
