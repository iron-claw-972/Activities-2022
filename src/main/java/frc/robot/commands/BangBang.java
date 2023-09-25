package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  // TODO 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  ExampleSubsystem m_subsystem;
  Drivetrain m_drive;
  WPI_TalonFX leftMotor;
  WPI_TalonFX rightMotor;
  int setpoint;
  static double kP = 0.001;

  // TODO 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  public BangBang(Drivetrain m_drive) {
    this.m_drive = m_drive;
    this.leftMotor = m_drive.getLeftEncoder();
    this.rightMotor = m_drive.getRightEncoder();
    this.setpoint = 512;
    addRequirements(m_drive);
    // TODO 2.4: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 2.4: zero encoders before starting
    leftMotor.setSelectedSensorPosition(0);
  }

  public void execute() {
    // TODO 2.4: Make the BangBang control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
    double error = leftMotor.getSelectedSensorPosition() - setpoint;
    // System.out.println(error);
    if (error < 0)
      m_drive.arcadeDrive(kP * error, 0.0);
    else
      m_drive.arcadeDrive(-kP * error, 0.0);
  }

  public void end(boolean interrupted) {
    // TODO 2.4: when the command ends, the motors should stop spinning
    m_drive.arcadeDrive(0.0, 0.0);
  }

  public boolean isFinished() {
    System.out.println(leftMotor.getSelectedSensorPosition());
    // TODO 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    if (java.lang.Math.abs(leftMotor.getSelectedSensorPosition() - setpoint) < 5)
      return true;
    else
      return false;
  }
}
