package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class PIDCommand extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  Drivetrain m_drive;
  double setpoint;
  // TODO 4.2: Add a parameter that asks for the setpoint
  public PIDCommand(Drivetrain drive, double setpoint) {
    m_drive = drive;
    addRequirements(drive);
    this.setpoint = setpoint;

    // TODO 4.2: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
]
    // TODO 4.2: zero encoders and rest the PID controller before starting
    m_drive.zeroEncoders();
    m_drive.resetPID();

    // TODO 4.2: zero encoders, reset the PID controller, and enable it before starting
  }

  public void execute() {
    // Your PID already is always running in the periodic() function of your subsystem, so there is no need to do anything here.
    
  }

  public void end(boolean interrupted) {
    m_drive.leftMotor1.set(0);
    m_drive.rightMotor1.set(0);
  }

  public boolean isFinished() {
    // TODO 4.2: check if the PID is finished though the PID controler
    if(m_drive.pidController.getSetpoint() == setpoint) return true;
    return false;
  }
}
