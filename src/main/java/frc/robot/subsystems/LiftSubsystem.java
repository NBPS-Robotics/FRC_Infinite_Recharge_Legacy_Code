package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.LiftConstants;

public class LiftSubsystem extends SubsystemBase {
    //creation of the motors for the lift
    private CANSparkMax m_frontRightMotor = new CANSparkMax(LiftConstants.kFrontRightLiftPort, MotorType.kBrushless);
    private CANSparkMax m_backRightMotor = new CANSparkMax(LiftConstants.kBackRightLiftPort, MotorType.kBrushless);
    private CANSparkMax m_frontLeftMotor = new CANSparkMax(LiftConstants.kFrontLeftLiftPort, MotorType.kBrushless);
    private CANSparkMax m_backLeftMotor = new CANSparkMax(LiftConstants.kBackLeftLiftPort, MotorType.kBrushless);

    //create a new LiftSubsystem
    public LiftSubsystem() {
        //due to how the lift works, front and back motors always mirror eachother
        //therefore, we can make them follow eachother to save time 
        m_backRightMotor.follow(m_frontRightMotor);
        m_backLeftMotor.follow(m_frontLeftMotor);
    }

    /**
     * Moves the lift up and down
     * @param speed = whatever speed it should run at
     */
    public void lift(double speed)
    {
        //motors are inverted on the right side, therefore negative speed
        m_frontRightMotor.set(-speed);
        m_frontLeftMotor.set(speed);
    }

}

