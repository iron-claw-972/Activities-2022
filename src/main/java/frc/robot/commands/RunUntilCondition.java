package frc.robot.commands;

import java.time.LocalTime;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


// TODO 2.2: Rename this command to something more relevant
public class RunUntilCondition extends CommandBase {

  private final Drivetrain m_drive;
  private int start;

  public RunUntilCondition(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // TODO 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    System.out.println("initialized");
    start = LocalTime.now().toSecondOfDay();
  }

  public void execute() {
    // TODO 2.2 Put the stuff that should run every cycle here
    System.out.println("running");
    m_drive.arcadeDrive(0.5, 0);
  }

  public void end(boolean interrupted) {
    // TODO 2.2 Put the stuff that should run when the comm and ends/ is finished
    System.out.println("ended");
    m_drive.arcadeDrive(0, 0);
  }

  public boolean isFinished() {
    // TODO 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
    if (LocalTime.now().toSecondOfDay() - start >= 2) {
      return true;
    }
    return false;
  }
}
