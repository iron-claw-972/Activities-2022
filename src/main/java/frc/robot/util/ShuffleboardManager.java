package frc.robot.util;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.Robot;

public class ShuffleboardManager {

  SendableChooser<Command> m_autoCommand = new SendableChooser<>();

  ShuffleboardTab m_mainTab = Shuffleboard.getTab("Main");
  ShuffleboardTab m_autoTab = Shuffleboard.getTab("Auto");

  // NetworkTableEntry m_commandScheduler = m_mainTab.add("Command Scheduler", "NULL").getEntry();
  
  public void setup() {
    LiveWindow.disableAllTelemetry(); // LiveWindow is causing periodic loop overruns

    chooserUpdate();

    // TODO 4.3: Add the PID you made to shuffle board (you can do this in the Subsystem or ShuffleBoardManager class)
    m_autoTab.add("Auto Chooser", m_autoCommand);
    m_autoTab.add("drivetrain PID", Robot.drive.pid);
  }

  public Command getAutonomousCommand() {
    return m_autoCommand.getSelected();
  }

  public void chooserUpdate() {
    m_autoCommand.addOption("Do Nothing", new PrintCommand("This will do nothing!"));
    // TODO 4.3: add your autonomous command to the auto command chooser
    m_autoCommand.addOption("pidcommand", new  frc.robot.commands.PIDCommand(Robot.drive,3000.0));
  }

  public void loadCommandSchedulerShuffleboard(){
    // CommandScheduler.getInstance().onCommandInitialize(command -> m_commandScheduler.setString(command.getName() + " initialized."));
    // CommandScheduler.getInstance().onCommandInterrupt(command -> m_commandScheduler.setString(command.getName() + " interrupted."));
    // CommandScheduler.getInstance().onCommandFinish(command -> m_commandScheduler.setString(command.getName() + " finished."));
  }

}
