package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.time.LocalTime;


// TODO 2.2: Rename this command to something more relevant
public class DriveForThreeSeconds extends CommandBase {

  private int start;

  private final Drivetrain m_drive;

  public DriveForThreeSeconds(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    start = LocalTime.now().toSecondOfDay();
  }

  public void execute() {
    m_drive.arcadeDrive(0.2, 0);
  }

  public void end(boolean interrupted) {
    
  }

  public boolean isFinished() {
    if (LocalTime.now().toSecondOfDay() - start >= 3) {
      return true;
    }
    return false;
  }
}
