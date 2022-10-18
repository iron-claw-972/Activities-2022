package frc.robot.commands;

import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.util.MotorFactory;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


// TODO 2.2: Rename this command to something more relevant
public class Runrotations extends CommandBase {

  private final Drivetrain m_drive;
 
  public Runrotations(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // TODO 2.2 Put the stuff that should run at the start, usually to prep for what is in execute
    m_drive.setEncodervalue0();
    System.out.println("zeroed");
  }

  public void execute() {
    // TODO 2.2 Put the stuff that should run every cycle here{

      m_drive.tankDrive(-0.3,-0.3);
      System.out.println(m_drive.getEncodervalues());
  }

  public void end(boolean interrupted) {
    // TODO 2.2 Put the stuff that should run when the command ends/ is finished
    m_drive.tankDrive(0,0);
  }

  public boolean isFinished() {
    // TODO 2.2 return if the comand should stop. This is where you will check your condition for if the command is finished.
    if (m_drive.getEncodervalues() >= 50*2048) System.out.println("finihsed");
    return m_drive.getEncodervalues() >= 50*2048;
  }
}
