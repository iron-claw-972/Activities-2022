package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;


// TODO 2.2: Rename this command to something more relevant
public class DriveUntilX extends CommandBase {

  private final Drivetrain m_drive;
  private int timer;

  public DriveUntilX(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // TODO 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    m_drive.tankDrive(1, 1);
    timer = 5;
  }

  public void execute() {
    // TODO 2.2 Put the stuff that should run every cycle here
    timer--;
  }

  public void end(boolean interrupted) {
    // TODO 2.2 Put the stuff that should run when the command ends/ is finished
      m_drive.tankDrive(0, 0);
  }

  public boolean isFinished() {
    // TODO 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
    return (timer == 0);
  }
}
