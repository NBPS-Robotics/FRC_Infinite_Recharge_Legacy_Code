package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NAVXSubsystem;

//import com.kauailabs.navx.frc.AHRS;




//this command will drive the robot plus or minus a given degree
public class DriveToAngle extends CommandBase {
    private final DriveSubsystem m_drive;
    private double m_angle;
    private final double m_speed1, m_speed2;
    private final double m_deadzone1, m_deadzone2;
    private NAVXSubsystem navx;

    /**
     * We set up this class with a few variables
     * @param angle = the angle we will be traveling to (ex if we are at 180 and want to turn 90 degrees to the right, we would put 90. the initial angle does not matter for this class)
     * @param speed = the speed at which we will be turning
     * @param drive = the drive subsystem
     * @param deadzone = the zone in between which we can turn off (see isFinished)
     */
    public DriveToAngle(DriveSubsystem drive, NAVXSubsystem p_navx, double angle) {
        m_angle = angle;
        m_drive = drive;
        navx = p_navx;
        m_speed1 = 0.5;
        m_deadzone1 = 20;
        m_speed2 = 0.2;
        m_deadzone2 = 2;
    }

    /**
     * The basic way we run this class is that while we are below the target angle, we turn
     * basically, if the angle is less than our current angle, we turn left
     * and if greater, we turn right
     * if we are at the angle already (only possible if you put 0 for the angle) we do nothing
     */
    @Override
    public void initialize() {
        
        
    }
    @Override
    public void execute() {
        if(m_angle - m_deadzone1 < navx.getAngle() && m_angle + m_deadzone1 > navx.getAngle())
        {
            if(m_angle - m_deadzone2 < navx.getAngle() && m_angle + m_deadzone2 > navx.getAngle())
                isFinished();
            else if(m_angle - m_deadzone2 < navx.getAngle())
                m_drive.mecanumDrive(0, 0, -m_speed2);
            else
                m_drive.mecanumDrive(0, 0, m_speed2);
        }
        else if(m_angle - m_deadzone1 < navx.getAngle())
            m_drive.mecanumDrive(0, 0, -m_speed1);
        else
            m_drive.mecanumDrive(0, 0, m_speed1);
    }

    /**
     * Make sure we tell the wheels to stop spinning once we are done
     */
    @Override
    public void end(boolean interrupted)
    {
        m_drive.mecanumDrive(0, 0, 0);
    }
    /**
     * basically, this gives us a small range of angles to be in between while turning
     * while turning at higher speeds, we tend to overshoot or undershoot by small
     * amounts that really wouldnt have much of an affect on the auto as a whole
     * However, these angles can lead to oscilation, where the robot violently jerks
     * back and forth trying to reach the angle
     * To prevent this, we set a small safe zone defined by m_deadzone
     */
    @Override
    public boolean isFinished() {
        if(m_angle - m_deadzone2 < navx.getAngle() && m_angle + m_deadzone2 > navx.getAngle())
            return true;
        return false;
    }
}