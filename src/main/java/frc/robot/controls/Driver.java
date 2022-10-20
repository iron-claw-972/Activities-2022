package frc.robot.controls;

import frc.robot.commands.DoNothing;
import frc.robot.constants.Constants;
import lib.controllers.GameController;
import lib.controllers.GameController.Axis;
import lib.controllers.GameController.Button;

public class Driver {
  private static GameController driver = new GameController(Constants.oi.kDriverJoy);

  public static void configureControls() {

    // TODO 3.1: Change the DoNothing() command to one of your commands
       driver.get(Button.A).whenPressed(new BangBang(robot.DriveTrain, 2000));

    // TODO 3.3: Write some more triggers for your commands! Group your commands and functions using at least one of each of these: ParallelCommandGroup, SequentialCommandGroup, ConditionalCommand, PrintCommand, WaitUntilCommand
    //in sequential  write wait until, then bang bang, then print command
    driver.get(Button.B).whenPressed(new ParallelCommandGroup (
       (new BangBang(robot.DriveTrain, 2000)))
       new PrintCommand("robot")
       );

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
