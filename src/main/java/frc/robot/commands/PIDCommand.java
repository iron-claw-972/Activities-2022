package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PIDCommand extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  public Drivetrain m_drive;

  // TODO 4.2: Add a parameter that asks for the setpoint
  public PIDCommand(Drivetrain subsystem, double setpoint) {
    // TODO 4.2: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
    m_drive = subsystem;
    addRequirements(subsystem);
    m_drive.setPoint(setpoint);
  }

  public void initialize() {
    // TODO 4.2: zero encoders, reset the PID controller, and enable it before starting
    m_drive.leftMotor1.setSelectedSensorPosition(0);
    m_drive.rightMotor1.setSelectedSensorPosition(0);
    m_drive.setpid(true);
  }

  public void execute() {
    // Your PID already is always running in the periodic() function of your subsystem, so there is no need to do anything here.

  }

  public void end(boolean interrupted) {
    // TODO 4.2: when the command ends, the motors should stop spinning
    m_drive.leftMotor1.set(0);
    m_drive.rightMotor1.set(0);
  }

  public boolean isFinished() {
    // TODO 4.2: check if the PID is finished though the PID controler
    return m_drive.pid.atSetpoint();
  }
}
