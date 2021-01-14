package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSubsystem;

import frc.robot.Constants.LiftConstants;

public class LiftSafely extends CommandBase {
    private final LiftSubsystem m_lift;
    private final DigitalInput topLimit, bottomLimit;
    private final DoubleSupplier m_speed;

    /**
     * The point of this class is to stop the lift from going too far using limit switches 
     * These switches are placed at the top and bottom of the range of the lift, and when triggered, stop the robot from proceeding further
     * They are only capable of outputing two states: on and off
     * @param lift = the lift that we are using 
     * @param speed = the speed at which we are lifting
     */
    public LiftSafely(LiftSubsystem lift, DoubleSupplier speed) {
        m_lift = lift;
        m_speed = speed;
        //in this, we declare the limit switches in order to stop the motors from going to far
        topLimit = new DigitalInput(LiftConstants.kTopLimitSwitchPort);
        bottomLimit = new DigitalInput(LiftConstants.kBottomLimitSwitchPort);
        //make sure we have this
        addRequirements(m_lift);
    }
    /**
     * This function is rather simple
     * If a limit switch is triggered, restrict the motion to only being able to proceed in the opposite direction
     */
    public void execute()
    {
        double adjustedSpeed = m_speed.getAsDouble();
        
        if(!topLimit.get())
            adjustedSpeed = Math.max(0, adjustedSpeed);
        
        else if(!bottomLimit.get())
            adjustedSpeed = Math.min(adjustedSpeed, 0);
        
            
        m_lift.lift(-adjustedSpeed);
    }


}