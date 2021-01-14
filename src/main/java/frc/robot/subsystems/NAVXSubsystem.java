package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;


public class NAVXSubsystem extends SubsystemBase {
    //its the navx 
    private AHRS navx = new AHRS(SerialPort.Port.kMXP);

    //now in a subsystem
    public NAVXSubsystem() {
        navx.reset();
    }

    public double getAngle()
    {
        return navx.getAngle();
    }

    public void reset()
    {
        navx.reset();
    }

}

