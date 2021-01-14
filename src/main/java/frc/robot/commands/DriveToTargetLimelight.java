package frc.robot.commands;

//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.NAVXSubsystem;
import frc.robot.Constants.LimelightConstants;
//import edu.wpi.first.wpilibj.SerialPort;

/**
 * A command to drvie the robot using mecanum with joystick input
 */

public class DriveToTargetLimelight extends CommandBase {
    private final DriveSubsystem m_drive;
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ta = table.getEntry("ta");
    double x, a, error, current, straighten;
    NAVXSubsystem navx;

    public DriveToTargetLimelight(DriveSubsystem subsystem, NAVXSubsystem p_navx)
    {
        navx = p_navx;
        m_drive = subsystem;
    }
    @Override
    public void initialize() {
        current = navx.getAngle();
    }
    @Override
    public void execute() {
        error = current - navx.getAngle();
        straighten = error * LimelightConstants.kP;
        x = tx.getDouble(0.0);
        a = ta.getDouble(0.0);
        if(x >= 1)
            m_drive.mecanumDrive(LimelightConstants.kIdealStrafeValue, -straighten, 0);
        else if(x <= -1)
            m_drive.mecanumDrive(-LimelightConstants.kIdealStrafeValue, -straighten, 0);
        else
        {
            if(a <= LimelightConstants.kIdealAreaValue-LimelightConstants.kAreaRangeValue)
                m_drive.mecanumDrive(0, -LimelightConstants.kIdealForwardValue, 0);
            else if(a >= LimelightConstants.kIdealAreaValue+LimelightConstants.kAreaRangeValue)
                m_drive.mecanumDrive(0, LimelightConstants.kIdealForwardValue, 0);
        
        }
    }
    @Override
    public void end(boolean interrupetd) {
        m_drive.mecanumDrive(0, 0, 0);
    }
    @Override
    public boolean isFinished() {
        return (x<=1&&x>=-1&&a >= LimelightConstants.kIdealAreaValue-LimelightConstants.kAreaRangeValue&&a <= LimelightConstants.kIdealAreaValue+LimelightConstants.kAreaRangeValue);
    }
}