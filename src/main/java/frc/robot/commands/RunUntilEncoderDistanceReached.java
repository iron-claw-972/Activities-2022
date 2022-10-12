package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

// DONE 2.2: Rename this command to something more relevant
public class RunUntilEncoderDistanceReached extends CommandBase {

  private final Drivetrain m_drive;

  public RunUntilEncoderDistanceReached(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // DONE 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    m_drive.zeroEncoders();
  }

  public void execute() {
    // DONE 2.2 Put the stuff that should run every cycle here
    double leftEncoder = m_drive.getEncoderLeft(); 
    double rightEncoder = m_drive.getEncoderRight(); 
    double circumfrence = 4*Math.PI;
    double averageDistance =((leftEncoder+rightEncoder)/2)/2048*circumfrence; 
    if (averageDistance <16){
      m_drive.arcadeDrive(0.5, 0);
    }
    
  }

  public void end(boolean interrupted) {
    //DONE 2.2 Put the stuff that should run when the command ends/ is finished
    if (isFinished()){
      m_drive.stopArcadeDrive(); 
    }
  }

  public boolean isFinished() {
    //DONE 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
        
    double leftEncoder = m_drive.getEncoderLeft(); 
    double rightEncoder = m_drive.getEncoderRight(); 
    double circumfrence = 4*Math.PI;
    double averageDistance =((leftEncoder+rightEncoder)/2)/2048*circumfrence; 

    if (averageDistance >=15){
     return true; 
    }
    else{
      return false; 
    }
  }
}
