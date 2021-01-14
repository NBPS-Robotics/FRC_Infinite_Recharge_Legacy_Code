package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
    private CANSparkMax m_shooter = new CANSparkMax(ShooterConstants.kShooter1Port, MotorType.kBrushless);
    //private WPI_TalonSRX m_shooter2 = new WPI_TalonSRX(ShooterConstants.kShooter2Port);
    private Servo m_index = new Servo(ShooterConstants.kIndexPort);

    /**
     * this is the shooter class
     * we have two motors for the shooting, but since they always follow eachother, we just have shooter2 follow shooter 
     * also, index is a servo that moves up or down depending on if we want the servo to go in or not
     */
    /*public ShooterSubsystem() {
        m_shooter2.follow(m_shooter);
    }*/
    /**
     * @param speed = speed to shoot at
     */
    public void shoot(double speed)
    {
        m_shooter.set(speed);
    }
    /**
     * 
     * @param position = position for index servo to be at
     */
    public void moveIndex(double position)
    {
        m_index.set(position);
    }
}