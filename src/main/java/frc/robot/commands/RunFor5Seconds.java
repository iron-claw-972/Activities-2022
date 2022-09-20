package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


// TODO 2.2: Rename this command to something more relevant
public class RunFor5Seconds extends CommandBase {

  private final Drivetrain m_drive;

  public RunFor5Seconds(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  private int timer;
  public void initialize() {
    timer=0;
    // TODO 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
  }

  public void execute() {
    timer++;
    m_drive.arcadeDrive(0, 1);
    // TODO 2.2 Put the stuff that should run every cycle here
  }

  public void end(boolean interrupted) {
    timer=0;
    m_drive.setDefaultCommand(
      new ArcadeDrive(m_drive)
    );

    // TODO 2.2 Put the stuff that should run when the command ends/ is finished
  }

  public boolean isFinished() {
    // TODO 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
    return timer>100;
  }
}
