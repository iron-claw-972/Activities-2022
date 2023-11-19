package frc.robot.controls;

import frc.robot.commands.DoNothing;
import frc.robot.commands.DriveOneMeter;
import frc.robot.commands.PIDCommand;
import frc.robot.commands.SpinAround;
import frc.robot.commands.TestMeter;
import frc.robot.commands.Turn180;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivetrain;
import lib.controllers.GameController;
import lib.controllers.GameController.Axis;
import lib.controllers.GameController.Button;

public class Driver {
  private static final GameController driver = new GameController(Constants.oi.kDriverJoy);

  public static void configureControls(Drivetrain m_drive) {
    // TODO 3.1: Change the DoNothing() command to one of your commands
    // driver.get(Button.A).onTrue(new PIDCommand(m_drive, 10240 * 8, Constants.drive));
    driver.get(Button.A).onTrue(new PIDCommand(m_drive, 10240 * 8));

    // TODO 3.3: Write some more triggers for your commands! Group your commands and functions using at least one of each of these: ParallelCommandGroup, SequentialCommandGroup, ConditionalCommand, PrintCommand, WaitUntilCommand
    driver.get(Button.B).onTrue(new Turn180(m_drive, Constants.drive));
    driver.get(Button.X).onTrue(new DriveOneMeter(m_drive, Constants.drive));
    driver.get(Button.Y).onTrue(new SpinAround(m_drive));
    // driver.get(Button.A).onTrue(new TestMeter(m_drive));
  }

  public static double getRawThrottleValue() {
    return driver.get(Axis.LEFT_Y);
  }

  public static double getRawTurnValue() {
    return driver.get(Axis.RIGHT_X);
  }

  public static double getRawLeft() {
    return driver.get(Axis.LEFT_Y);
  }

  public static double getRawRight() {
    return driver.get(Axis.RIGHT_Y);
  }

}
