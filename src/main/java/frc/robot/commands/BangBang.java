package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ExtraMotor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  // TODO 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  Drivetrain m_subsystem;
  double m_distance;
  // TODO 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  public BangBang(Drivetrain subsystem, double distance) {
    m_subsystem = subsystem;
    m_distance = distance;
    addRequirements(subsystem);
    // TODO 2.4: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 2.4: zero encoders before starting
    m_subsystem.getEncodervalues();
  }

  public void execute() {
    // TODO 2.4: Make the BangBang control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
    while(m_distance != m_subsystem.getEncodervalues()){
      if (m_distance<m_subsystem.getEncodervalues())
        m_subsystem.tankDrive(-0.1, -0.1);
      if (m_distance>m_subsystem.getEncodervalues())
        m_subsystem.tankDrive(0.1, 0.1);
  }

  public void end(boolean interrupted) {
    // TODO 2.4: when the command ends, the motors should stop spinning
    m_subsystem.tankDrive(0, 0);
  }

  public boolean isFinished() {
    // TODO 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    
    return m_subsystem.getEncodervalues()==m_distance+-50;
  }
}
