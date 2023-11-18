package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SideOfDrivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  // TODO 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  // SideOfDrivetrain m_subsystem;
  Drivetrain m_drive;
  public static final int epsilon = 700;
  public static double abs(double x) {
    if (x<0) x*=-1;
    return x;
  }
  // TODO 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  public BangBang(Drivetrain m_drive) {
    this.m_drive = m_drive;
    addRequirements(this.m_drive);
    // TODO 2.4: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
    
  }

  public void initialize() {
    // TODO 2.4: zero encoders before starting
    m_drive.leftMotor1.setSelectedSensorPosition(0);
    m_drive.rightMotor1.setSelectedSensorPosition(0);
  }

  public void execute() {
    // TODO 2.4: Make the BangBang control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
    if (m_drive.leftMotor1.getSelectedSensorPosition() < 30000) {
      m_drive.leftMotor1.set(.2);
      m_drive.rightMotor1.set(.2);
    }
    else {
      m_drive.leftMotor1.set(-.2);
      m_drive.rightMotor1.set(-.2);
    }
    System.out.println(m_drive.leftMotor1.getSelectedSensorPosition());
  }

  public void end(boolean interrupted) {
    // TODO 2.4: when the command ends, the motors should stop spinning
    m_drive.leftMotor1.set(0);
    m_drive.rightMotor1.set(0);
    System.out.println("this");
  }

  public boolean isFinished() {
    // TODO 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    return (abs(m_drive.leftMotor1.getSelectedSensorPosition()-30000) <= epsilon);
  }
}
