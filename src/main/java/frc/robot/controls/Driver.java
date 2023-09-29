package frc.robot.controls;

import frc.robot.commands.DoNothing;
import frc.robot.commands.PIDCommand;
import frc.robot.commands.Turn180;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivetrain;
import lib.controllers.GameController;
import lib.controllers.GameController.Axis;
import lib.controllers.GameController.Button;

public class Driver {
  private static GameController driver = new GameController(Constants.oi.kDriverJoy);

  public static void configureControls(Drivetrain m_drive) {
    // TODO 3.1: Change the DoNothing() command to one of your commands
    driver.get(Button.A).whenPressed(new PIDCommand(m_drive, 512));
    driver.get(Button.B).whenPressed(new Turn180(m_drive));
    driver.get(Button.X).whenPressed(new DoNothing());
    driver.get(Button.Y).whenPressed(new DoNothing());

    // TODO 3.3: Write some more triggers for your commands! Group your commands and functions using at least one of each of these: ParallelCommandGroup, SequentialCommandGroup, ConditionalCommand, PrintCommand, WaitUntilCommand
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
