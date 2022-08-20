package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


// TODO 2.2: Rename this command to something more relevent
public class RunUntilCondition extends CommandBase {

  // TODO 2.2: change the class of the subsystem
  private final ExampleSubsystem m_subsystem;

  // TODO 2.2: change the class of the subsystem parameter
  public RunUntilCondition(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  public void initialize() {
    // TODO 2.2 Put the stuff that should run at the start usualy to prep for what is in execute
  }

  public void execute() {
    // TODO 2.2 Put the stuff that should run every cycle here
  }

  public void end(boolean interrupted) {
    // TODO 2.2 Put the stuff that should run when the command ends/ is finished
  }

  public boolean isFinished() {
    // TODO 2.2 return if the comand should stop
    return false;
  }
}
