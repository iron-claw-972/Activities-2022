package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SideOfDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  // TODO 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  Drivetrain m_drive;
  double setpoint;
  
  // TODO 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  public BangBang(Drivetrain subsystem, double setpoint) {
    m_drive = subsystem;
    addRequirements(subsystem);
    this.setpoint = setpoint;
    // TODO 2.4: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    // TODO 2.4: zero encoders before starting
    m_drive.zeroEncoders();

  }

  public void execute() {
    // TODO 2.4: Make the BangBang control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
   
    if(m_drive.getEncoderValue() < setpoint){
      m_drive.tankDrive(0.2, 0.2);
    }
    else if (m_drive.getEncoderValue() > setpoint){
      m_drive.tankDrive(-0.2, -0.2);
    }
    
  }

  public void end(boolean interrupted) {
    // TODO 2.4: when the command ends, the motors should stop spinning
    m_drive.tankDrive(0, 0);
  }

  public boolean isFinished() {
    // TODO 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    if(m_drive.getEncoderValue() < setpoint + 100.0 && m_drive.getEncoderValue() > setpoint - 100.0) return true;
    return false;
  }
}
