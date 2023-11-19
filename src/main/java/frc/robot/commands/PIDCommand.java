package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class PIDCommand extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  // ExampleSubsystem m_subsystem;
  Drivetrain drive;

  // TODO 4.2: Add a parameter that asks for the setpoint
  public PIDCommand(Drivetrain m_drive, int setpoint) {
    this.drive = m_drive;
    addRequirements(m_drive);
    // TODO 4.2: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 4.2: zero encoders, reset the PID controller, and enable it before starting
    System.out.println("Running PIDCommand");
    drive.sendLinearPidTo(10);
  }

  public void execute() {
    // Your PID already is always running in the periodic() function of your subsystem, so there is no need to do anything here.
  }

  public void end(boolean interrupted) {
    // TODO 4.2: when the command ends, the motors should stop spinning
    drive.releasePids();
  }

  public boolean isFinished() {
    // TODO 4.2: check if the PID is finished though the PID controller
    return drive.getPidLinear().atSetpoint();
  }
}
