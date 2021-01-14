package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    private  CANSparkMax m_intake = new CANSparkMax(IntakeConstants.kIntakePort, MotorType.kBrushless);

    /**
     * this is the class for the intake
     * thats it its really simple
     */
    public IntakeSubsystem() {

    }
    /**
     * will i keep the name as succ? probably
     * can you change it? no.
     * @param speed = speed at which succage occurs
     */
    public void succ(double speed) {
        m_intake.set(speed);
    }
}