package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.ShooterConstants;

public class ShootWithIndex extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_shooter;
  private Timer timer = new Timer();

  /**
   * Creates our shoot with index command
   * The idea of this command is to automatically charge up the shooter, open the index,
   * let the balls shoot out, and, after the command is done being called, close the index and
   * power down the shooter
   * @param shooter = the shooter
   */
  public ShootWithIndex(ShooterSubsystem shooter) {
    m_shooter = shooter;
    addRequirements(shooter);
  }

  //start charging up the motor and start the timer
  @Override
  public void initialize() {
      timer.reset();
      timer.start();
      m_shooter.shoot(ShooterConstants.kIdealShotSpeed);
  }
 
  //this waits until the shooter is charged up, then launches the balls
  @Override
  public void execute() {
      if(timer.get() >= ShooterConstants.kTimeToChargeUp)
      {
        m_shooter.moveIndex(ShooterConstants.kIndexOpenPosition);
      }
  }

  //When the command is over, turn off the shooter and close the index servo
  @Override
  public void end(boolean interrupted) {
      m_shooter.shoot(0);
      m_shooter.moveIndex(ShooterConstants.kIndexClosedPosition);
  }

  //Command is controlled by driver, doesnt need to end on its own
  @Override
  public boolean isFinished() {
    return false;
  }
}
