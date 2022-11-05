package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


// TODO 2.2: Rename this command to something more relevant
public class RunUntilCondition extends CommandBase {

  private final Drivetrain m_drive;
  private double startTime;

  public RunUntilCondition(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // TODO 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    startTime = Timer.getFPGATimestamp();
  }

  public void execute() {
    // TODO 2.2 Put the stuff that should run every cycle here
    double time = startTime - Timer.getFPGATimestamp();

    if (time == 3) {
      m_drive.arcadeDrive(0.2, 0);
    }
  }

  public void end(boolean interrupted) {
    // TODO 2.2 Put the stuff that should run when the command ends/ is finished
  }

  public boolean isFinished() {
    // TODO 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
    return false;
  }
}
