package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// I think this is the auto command
// TODO 2.2: Rename this command to something more relevant
public class RunUntilCondition extends CommandBase {

  private final Drivetrain m_drive;

  public RunUntilCondition(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }
  private int num_cycles_done;
  public void initialize() {
    // TODO 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    num_cycles_done = 0;
    // m_drive.arcadeDrive(0,.3);
  }

  public void execute() {
    // TODO 2.2 Put the stuff that should run every cycle here
    
    if (num_cycles_done < 20)m_drive.arcadeDrive(.3,0);
    num_cycles_done++;
  }

  public void end(boolean interrupted) {
    // TODO 2.2 Put the stuff that should run when the command ends/ is finished
  }

  public boolean isFinished() {
    // TODO 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
    if (num_cycles_done > 20){
      this.end(false);
      return true;
    }
    return false;
  }
}
