package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;


// TODO 2.2: Rename this command to something more relevant
public class AutoDrive extends CommandBase {

  private final Drivetrain m_drive;
  static final int RUN_MILLIS = 1000;
  long endAt;

  public AutoDrive(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // TODO 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    long startTime = System.currentTimeMillis();
    this.endAt = startTime + RUN_MILLIS;
  }

  public void execute() {
    // TODO 2.2 Put the stuff that should run every cycle here
    m_drive.arcadeDrive(1.0, 0.0);
  }

  public void end(boolean interrupted) {
    // TODO 2.2 Put the stuff that should run when the command ends/ is finished
    m_drive.arcadeDrive(0.0, 0.0);
  }

  public boolean isFinished() {
    // TODO 2.2 return if the command should stop. This is where you will check your condition for if the command is finished.
    return System.currentTimeMillis() >= this.endAt;
  }
}
