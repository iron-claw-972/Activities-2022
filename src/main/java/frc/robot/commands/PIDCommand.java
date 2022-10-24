package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PIDCommand extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  Drivetrain m_drive;

  // TODO 4.2: Add a parameter that asks for the setpoint
  public PIDCommand(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
    // TODO 4.2: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 4.2: zero encoders and rest the PID controller before starting
    m_drive.setEncoderPosition(0);
    m_drive.resetPID();
  }

  public void execute() {
    m_drive.periodic();
  }

  public void end(boolean interrupted) {
    m_drive.stateOfPID(false);
  }

  public boolean isFinished() {
    if (m_drive.pidEnabled){
      return true;
    }
    return false;
  }
}
