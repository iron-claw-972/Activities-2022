package frc.robot.controls;

import frc.robot.commands.DoNothing;
import frc.robot.commands.RunUntilEncoderDistanceReached;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivetrain;
import lib.controllers.GameController;
import lib.controllers.GameController.Axis;
import lib.controllers.GameController.Button;

public class Driver {
  private static GameController driver = new GameController(Constants.oi.kDriverJoy);
  private static Drivetrain drive = new Drivetrain(); 

  public static void configureControls() {

    // DONE 3.1: Change the DoNothing() command to one of your commands
    
    Do we not need something like setDefaultCommand for the below line of code?  QUESTION QUESTION QUESTION  QUESTION QUESTION QUESTION  QUESTION QUESTION  QUESTION QUESTION QUESTION

    driver.get(Button.A).whenPressed(new RunUntilEncoderDistanceReached(drive));

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
