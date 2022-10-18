package frc.robot.controls;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.commands.BangBang;
import frc.robot.commands.DoNothing;
import frc.robot.commands.Runrotations;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivetrain;
import lib.controllers.GameController;
import lib.controllers.GameController.Axis;
import lib.controllers.GameController.Button;

public class Driver {
  private static GameController driver = new GameController(Constants.oi.kDriverJoy);
  static Drivetrain drive = new Drivetrain();
  public static void configureControls() {

    // TODO 3.1: Change the DoNothing() command to one of your commands
    driver.get(Button.A).whenPressed(new Runrotations(drive).andThen(new PrintCommand("A finished")));

    // TODO 3.3: Write some more triggers for your commands! Group your commands and functions using at least one of each of these: ParallelCommandGroup, SequentialCommandGroup, ConditionalCommand, PrintCommand, WaitUntilCommand
    driver.get(Button.B).whenPressed(new ParallelCommandGroup(
      new SequentialCommandGroup(
        new WaitUntilCommand(driver.get(Button.X)::getAsBoolean),
        new Runrotations(drive),
        new BangBang(drive, 10000)
      ),
      new PrintCommand("Hi")
    )
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
