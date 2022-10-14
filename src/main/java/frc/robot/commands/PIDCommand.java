package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PIDCommand extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  ExampleSubsystem m_subsystem;
  double setpoint;

  // TODO 4.2: Add a parameter that asks for the setpoint
  public PIDCommand(ExampleSubsystem subsystem, double setpoint) {
    m_subsystem = subsystem;
    this.setpoint=setpoint;
    addRequirements(subsystem);
    // TODO 4.2: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 4.2: zero encoders and rest the PID controller before starting
  }

  public void execute() {
    // TODO 4.2: Make the PID control loop
  }

  public void end(boolean interrupted) {
    // TODO 4.2: when the command ends, the motors should stop spinning
  }

  public boolean isFinished() {
    // TODO 4.2: check if the PID is finished though the PID controler
    return false;
  }
}
