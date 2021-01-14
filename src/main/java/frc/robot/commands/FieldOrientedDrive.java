package frc.robot.commands;

import java.util.function.DoubleSupplier;



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A command to drvie the robot using mecanum with joystick input 
 * This drives in relation to the field, not the robot itsef
 */

public class FieldOrientedDrive extends CommandBase {
    private final DriveSubsystem m_drive;
    private final DoubleSupplier m_x;
    private final DoubleSupplier m_y;
    private final DoubleSupplier m_c;
    private final DoubleSupplier m_theta;
    

    public FieldOrientedDrive(DriveSubsystem subsystem, DoubleSupplier x, DoubleSupplier y, DoubleSupplier c, DoubleSupplier theta)
    {
        m_drive = subsystem;
        m_x = x;
        m_y = y;
        m_c = c;
        m_theta = theta;
        addRequirements(m_drive);
    }
    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        m_drive.mecanumDriveGyro(m_x.getAsDouble(), m_y.getAsDouble(), m_c.getAsDouble(), m_theta.getAsDouble());
    }
}