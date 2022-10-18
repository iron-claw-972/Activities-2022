package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
//import frc.robot.subsystems.ExampleSubsystem;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  // TODO 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  Drivetrain m_subsystem;

  // TODO 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  Drivetrain d = new Drivetrain();
  int goal = 1000;
  public BangBang(Drivetrain subsystem) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  public void initialize() {
      d.zero();
    // TODO 2.4: zero encoders before starting
  }

  public void execute() {
    // TODO 2.4: Make the BangBang control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
      if(d.getEncoder() < goal)
      {
          d.forward();
      }
      if(d.getEncoder() > goal)
      {
        d.backward();
    
    }
  }

  public void end(boolean interrupted) {
    // TODO 2.4: when the command ends, the motors should stop spinning
    d.stop();
  }

  public boolean isFinished() {
    // TODO 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    if(d.getEncoder() + 0.1 > goal && d.getEncoder() - 0.1 < goal)
    {
      return true;
    }
    return false;
  }
}
