package frc.robot.commands;

import frc.robot.constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TestMeter extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  // ExampleSubsystem m_subsystem;
  Drivetrain m_drive;
  WPI_TalonFX motor;

  // TODO 4.2: Add a parameter that asks for the setpoint
  public TestMeter(Drivetrain m_drive) {
    this.m_drive = m_drive;
    this.motor = m_drive.getLeftEncoder();
    addRequirements(m_drive);
  }

  public void initialize() {
    motor.setSelectedSensorPosition(0);
    m_drive.arcadeDrive(0.4, 0.0);
  }

  public void execute() {
    System.out.println(motor.getSelectedSensorPosition());
  }

  public void end(boolean interrupted) {
    // TODO 4.2: when the command ends, the motors should stop spinning
    m_drive.arcadeDrive(0.0, 0.0);
  }

  public boolean isFinished() {
    // TODO 4.2: check if the PID is finished though the PID controler
    return false;
  }
}
