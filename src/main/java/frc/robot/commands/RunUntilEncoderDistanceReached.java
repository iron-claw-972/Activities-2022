package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Encoder;


// Done 2.2: Rename this command to something more relevant
public class RunUntilEncoderDistanceReached extends CommandBase {

  private final Drivetrain m_drive;

  public RunUntilEncoderDistanceReached(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // Done 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    m_drive.zeroEncoders();
  }

  public double getAvgDistance(){
    // Done 2.2 Put the stuff that should run every cycle here
    double leftEncoder = m_drive.getEncoderLeft();
    double rightEncoder = m_drive.getEncoderRight();
    double circumference = 4*Math.PI;
    double averageDistance = ((leftEncoder + rightEncoder)/2)/2048*circumference;
    return averageDistance;

    if (averageDistance <16){
      m_drive.arcadeDrive(0.1,0);
      
    }
  }

  public void end(boolean interrupted) {
    // Done 2.2 Put the stuff that should run when the command ends/ is finished
    if (isFinished()){
      m_drive.stopArcadeDrive();
    }
  }

  public boolean isFinished() {
    // Done 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
    
  

  return getAvgDistance() >=16; 
  }
  
  }
  }
}