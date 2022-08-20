package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class BangBang extends CommandBase {

  Drivetrain m_drive;

  // TODO 2.4: take in a set point in paramaters
  public BangBang(Drivetrain drive) {
    m_drive = drive;
    addRequirements(drive);
  }

  public void initialize() {
    // TODO 2.4: zero encoders
  }

  public void execute() {
      // TODO 2.4: Make the BangBang control loop with encoders inputs
  }

  public void end(boolean interrupted) {}

  public boolean isFinished() {
    return false;
  }
}
