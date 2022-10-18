package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;

import java.beans.Encoder;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  // TODO 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  Drivetrain m_drive;
  double target;
  double speed;
  boolean forward;

  // TODO 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  public BangBang(Drivetrain drive, double targetA) {
    m_drive = drive;
    addRequirements(drive);
    target = targetA;
    speed = 0.5;
    forward = true;
    // TODO 2.4: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 2.4: zero encoders before starting
    m_drive.setEncoderPosition(0.0);
  }

  public void execute() {
    // TODO 2.4: Make the BangBang control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
    m_drive.arcadeDrive(speed, 0);
    if (m_drive.getEncoderPosition(true) > target && forward) {
      forward = false;
      speed = -(speed-0.05);
    }
    else if (m_drive.getEncoderPosition(true) < target && !forward) {
      forward = true;
      speed = -(speed+0.05);
    }
  }

  public void end(boolean interrupted) {
    // TODO 2.4: when the command ends, the motors should stop spinning
    m_drive.arcadeDrive(0, 0);
  }

  public boolean isFinished() {
    // TODO 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    if (Math.abs(m_drive.getEncoderPosition(true) - target) < 1) {
      return true;
    }
    return false;
  }
}