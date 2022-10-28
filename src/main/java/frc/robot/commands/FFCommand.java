package frc.robot.commands;

import frc.robot.controls.Driver;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class FFCommand extends CommandBase {
  private final Drivetrain m_drive;
  private final DifferentialDriveKinematics m_driveKinematics = new DifferentialDriveKinematics(0.62865);

  /**
   * Creates a new FFCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public FFCommand(Drivetrain drive) {
    m_drive = drive;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xSpeed=Driver.getRawThrottleValue();
    double rot=Driver.getRawTurnValue();
    DifferentialDriveWheelSpeeds wheelSpeeds = m_driveKinematics.toWheelSpeeds(new ChassisSpeeds(xSpeed, 0.0, rot));
    double left=m_drive.feedforward.calculate(wheelSpeeds.leftMetersPerSecond)+m_drive.leftPID.calculate(m_drive.getMotorVelocity("left"), wheelSpeeds.leftMetersPerSecond);
    double right=m_drive.feedforward.calculate(wheelSpeeds.rightMetersPerSecond)+m_drive.rightPID.calculate(m_drive.getMotorVelocity("right"), wheelSpeeds.rightMetersPerSecond);
    m_drive.setMotorVoltage(left, right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
