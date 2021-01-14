package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.SpinnerConstants;

public class SpinnerSubsystem extends SubsystemBase {
    private CANSparkMax m_spinner = new CANSparkMax(SpinnerConstants.kSpinnerPort, MotorType.kBrushless);

    /**
     * this is the class for the intake
     * thats it its really simple
     */
    public SpinnerSubsystem() {

    }
    /**
     * will i keep the name as succ? probably
     * can you change it? no.
     * @param speed = speed at which succage occurs
     */
    public void spin(double speed) {
        m_spinner.set(speed);
    }
}