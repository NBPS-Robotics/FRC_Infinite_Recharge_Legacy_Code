package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;

//this command will drive a robot for a specified amount of time
public class DriveForwardTime extends CommandBase {
    private final DriveSubsystem m_drive;
    private final double m_time;
    private final double m_speed;
    private Timer timer = new Timer();

    /**
     * 
     * @param time = time to drive forward
     * @param speed = speed to drive
     * @param drive = drive system
     */
    public DriveForwardTime(double time, double speed, DriveSubsystem drive) {
        m_time = time;
        m_speed = speed;
        m_drive = drive;
    }
    /**
     * reset timer, turn on power
     */
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }
    public void execute()
    {
        m_drive.mecanumDrive(0,m_speed,0);
    }
    /**
     * make sure power is turned off in the end
     */
    @Override
    public void end(boolean interrupted)
    {
        m_drive.mecanumDrive(0, 0, 0);
    }
    /**
     * check to see if current time elapsed is greater than the time provided
     * if yes, end the commandS
     */
    @Override
    public boolean isFinished() {
        return timer.get() >= m_time;
    }
}