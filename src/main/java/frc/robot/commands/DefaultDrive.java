package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A command to drvie the robot using mecanum with joystick input
 */

public class DefaultDrive extends CommandBase {
    private final DriveSubsystem m_drive;
    private final DoubleSupplier m_x;
    private final DoubleSupplier m_y;
    private final DoubleSupplier m_c;

    public DefaultDrive(DriveSubsystem subsystem, DoubleSupplier x, DoubleSupplier y, DoubleSupplier c)
    {
        m_drive = subsystem;
        m_x = x;
        m_y = y;
        m_c = c;
        addRequirements(m_drive);
    }

    public void execute() {
        m_drive.mecanumDrive(m_x.getAsDouble(), m_y.getAsDouble(), m_c.getAsDouble());
    }
}