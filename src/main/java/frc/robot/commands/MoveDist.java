package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.StraightDriveSubSystem;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveDist extends CommandBase {

  // TODO 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  StraightDriveSubSystem m_subsystem;
  double dist;
  boolean finished=false;

  // TODO 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  public MoveDist(StraightDriveSubSystem subsystem, double dist) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
    // TODO 2.4: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    m_subsystem.zeroMotors();
    finished=false;
    // TODO 2.4: zero encoders before starting
  }

  public void execute() {
    if(m_subsystem.getDist()<dist&&dist>0){
      m_subsystem.driveStraight(1);
    }else if(m_subsystem.getDist()>dist&&dist<0){
      m_subsystem.driveStraight(-1);
    }else{
      m_subsystem.driveStraight(0);
      finished=true;
    }
    // TODO 2.4: Make the MoveForwardsAndBackwards control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
  }

  public void end(boolean interrupted) {
    m_subsystem.driveStraight(0);
    // TODO 2.4: when the command ends, the motors should stop spinning
  }

  public boolean isFinished() {
    // TODO 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    return finished;
  }
}
