package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.StraightDriveSubSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PIDCommand extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  StraightDriveSubSystem m_drive;
  double setpoint;

  // TODO 4.2: Add a parameter that asks for the setpoint
  public PIDCommand(StraightDriveSubSystem subsystem, double setpoint) {
    m_drive = subsystem;
    this.setpoint=setpoint;
    addRequirements(subsystem, Robot.drive);
    // TODO 4.2: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    System.out.println("Initializing PID");
    m_drive.zeroMotors();
    m_drive.resetPid();
    m_drive.setSetPoint(setpoint);
    m_drive.setPidEnabled(true);
    m_drive.m_pid.setTolerance(100);
    // TODO 4.2: zero encoders and reset the PID controller before starting
  }

  public void execute() {

  }

  public void end(boolean interrupted) {
    m_drive.driveStraight(0);
    m_drive.setPidEnabled(false);
    System.out.println("Ending PID"+(interrupted?" (interrupted)":""));
    // TODO 4.2: when the command ends, the motors should stop spinning
  }

  public boolean isFinished() {
    // TODO 4.2: check if the PID is finished though the PID controler
    return m_drive.m_pid.atSetpoint();
  }
}
