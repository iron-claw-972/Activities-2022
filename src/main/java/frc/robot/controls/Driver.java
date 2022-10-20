package frc.robot.controls;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Robot;
import frc.robot.commands.DoNothing;
import frc.robot.commands.MoveDist;
import frc.robot.commands.PIDCommand;
import frc.robot.commands.RunFor5Seconds;
import frc.robot.constants.Constants;
import lib.controllers.GameController;
import lib.controllers.GameController.Axis;
import lib.controllers.GameController.Button;

public class Driver {
  private static GameController driver = new GameController(Constants.oi.kDriverJoy);

  public static void configureControls() {

    // TODO 3.1: Change the DoNothing() command to one of your commands
    driver.get(Button.A).whenPressed(new RunFor5Seconds(Robot.drive));
    driver.get(Button.X).whenPressed(new ConditionalCommand(new PIDCommand(Robot.drive2, -20000), new PIDCommand(Robot.drive2, 20000), ()->(driver.get(Axis.LEFT_TRIGGER)>0.5)));
    driver.get(Button.B).whenPressed(new ParallelCommandGroup(new PrintCommand("Moving forward 20000\n"), new MoveDist(Robot.drive2, 20000)));
    driver.get(Button.Y).whenPressed(new SequentialCommandGroup(new MoveDist(Robot.drive2, -15000), new RunFor5Seconds(Robot.drive), new WaitUntilCommand(()->(driver.get(Axis.RIGHT_TRIGGER)>0.75)), new MoveDist(Robot.drive2, 20000)));
    // TODO 3.3: Write some more triggers for your commands! Group your commands and functions using at least one of each of these: ParallelCommandGroup, SequentialCommandGroup, ConditionalCommand, PrintCommand, WaitUntilCommand
  }

  public Driver() {
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
