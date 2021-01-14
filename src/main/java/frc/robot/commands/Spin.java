package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinnerSubsystem;

public class Spin extends CommandBase {
    SpinnerSubsystem m_spinner = new SpinnerSubsystem();
    private final double m_speed;

    public Spin(SpinnerSubsystem spinner, double speed) {
        m_spinner = spinner;
        m_speed = speed;
        addRequirements(spinner);
    }
    @Override
    public void execute() {
        m_spinner.spin(m_speed);
    }
    @Override
    public void end(boolean interrupted) {
        m_spinner.spin(0);
    }
    
}