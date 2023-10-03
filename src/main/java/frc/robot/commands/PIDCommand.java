package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PIDCommand extends CommandBase {

  // TODO 4.2: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  // ExampleSubsystem m_subsystem;
  Drivetrain m_drive;
  static final double kP = 0.0001;
  static final double kI = 0.000001;
  static final double kD = 0.0;
  int setpoint;
  PIDController pid;
  WPI_TalonFX motor;

  // TODO 4.2: Add a parameter that asks for the setpoint
  public PIDCommand(Drivetrain m_drive, int setpoint) {
    this.m_drive = m_drive;
    this.motor = m_drive.getLeftEncoder();
    this.setpoint = setpoint;
    addRequirements(m_drive);
    pid = new PIDController(kP, kI, kD);
    pid.setTolerance(10, 5);
    // TODO 4.2: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 4.2: zero encoders, reset the PID controller, and enable it before starting
    motor.setSelectedSensorPosition(0);
  }

  public void execute() {
    // Your PID already is always running in the periodic() function of your subsystem, so there is no need to do anything here.
    // I'll add it anyway, cause I didn't make a subsystem
    m_drive.arcadeDrive(pid.calculate(motor.getSelectedSensorPosition(), setpoint), 0.0);
    System.out.println(pid.getPositionError());
    // System.out.println(motor.getSelectedSensorPosition());
  }

  public void end(boolean interrupted) {
    // TODO 4.2: when the command ends, the motors should stop spinning
    m_drive.arcadeDrive(0.0, 0.0);
  }

  public boolean isFinished() {
    // TODO 4.2: check if the PID is finished though the PID controler
    return pid.atSetpoint();
  }
}
