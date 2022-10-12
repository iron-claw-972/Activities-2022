package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  // DONE 2.4: replace ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain. change the name to something better
  Drivetrain m_drive;
  double setpointInches; 

  // DONE 2.4: Add a parameter that asks for the setpoint (how far the motor will spin)
  public BangBang(Drivetrain drive, double setpointInches) {
    m_drive = drive;
    this.setpointInches = setpointInches;
    addRequirements(m_drive);
    // DONE 2.4: replace above ExampleSubsystem with your created ExtraSubsystem, or with Drivetrain.
  }

  public void initialize() {
    m_drive.zeroEncoders();
    // DONE 2.4: zero encoders before starting
  }

  public void execute() {
    // DONE 2.4: Make the BangBang control loop with encoders inputs. This should be a basic if statement: if below, spin forward, if above, spin backward
    double leftEncoder = m_drive.getEncoderLeft(); 
    double rightEncoder = m_drive.getEncoderRight(); 
    double circumfrence = 4*Math.PI;
    double averageDistanceInches =((leftEncoder+rightEncoder)/2)/2048*circumfrence; 
    if (averageDistanceInches < setpoint){
      m_drive.arcadeDrive(0.1, 0);
    }
    
    if(averageDistanceInches > setpoint){
      m_drive.arcadeDrive(-0.1,0);

    }
  }

  public void end(boolean interrupted) {
    // DONE 2.4: when the command ends, the motors should stop spinning
    if (isFinished()){
      m_drive.stopArcadeDrive(); 

    }
  }

  public boolean isFinished() {
    // DONE 2.4: decide when it's finished. Check if it's reached the setpoint, or is within a certain range of the setpoint
    double leftEncoder = m_drive.getEncoderLeft(); 
    double rightEncoder = m_drive.getEncoderRight(); 
    double circumfrence = 4*Math.PI;
    double averageDistanceInches =((leftEncoder+rightEncoder)/2)/2048*circumfrence; 
  
    if(averageDistanceInches-setpoint > -1 && averageDistanceInches-setpoint <1 ){
      return true; 
    }

    else{
      return false; 
    }
  }
}
