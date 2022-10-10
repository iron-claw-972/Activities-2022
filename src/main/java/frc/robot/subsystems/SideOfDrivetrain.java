package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;
import java.time.LocalTime;
import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;


public class SideOfDrivetrain extends SubsystemBase {

  private boolean side;
  public boolean isRunning;
  // TODO 2.3: add motors/ motor group
  WPI_TalonFX motor = new WPI_TalonFX(Constants.drive.kRightMotor);

  public SideOfDrivetrain(boolean isLeft) {
    // TODO 2.3: use the boolean isLeft to set if it is left or right
    // TODO 2.3: set up configuration of motors/encoders
    side = isLeft;
  }

  // TODO 2.3: add a function or more to control the drivetrain
  public void dance() {
    isRunning = true;
    int time = LocalTime.now().toSecondOfDay();
    int startTime = time;
    float power = 0.2f;
    while (LocalTime.now().toSecondOfDay() - startTime <= 6) {
      if (LocalTime.now().toSecondOfDay() - time >= 1) {
        motor.set(ControlMode.PercentOutput, power);
        power += 0.1f;
        time = LocalTime.now().toSecondOfDay();
      }
    }
    isRunning = false;
  }
}
