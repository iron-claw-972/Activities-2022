package frc.robot.controls;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.BangBang;
import frc.robot.commands.DoNothing;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivetrain;
import lib.controllers.GameController;
import lib.controllers.GameController.Axis;
import lib.controllers.GameController.Button;

public class Driver {
  private static GameController driver = new GameController(Constants.oi.kDriverJoy);

  public static void configureControls() {
      
    // TODO 3.1: Change the DoNothing() command to one of your commands
    driver.get(Button.A).whenPressed(new BangBang(null));
    Drivetrain m_drive = new Drivetrain();
    // TODO 3.3: Write some more triggers for your commands! Group your commands and functions using at least one of each of these: ParallelCommandGroup, SequentialCommandGroup, ConditionalCommand, PrintCommand, WaitUntilCommand
    new SequentialCommandGroup(new BangBang(null),   );
    
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
