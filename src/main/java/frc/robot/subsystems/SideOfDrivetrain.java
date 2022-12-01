package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;


public class SideOfDrivetrain extends SubsystemBase {

  // TODO 2.3: add motors/ motor group
  WPI_TalonFX motor1;

  public SideOfDrivetrain(boolean isLeft) {
    // TODO 2.3: use the boolean isLeft to set if it is left or right
    if (isLeft) {
      motor1 = MotorFactory.createTalonFX(Constants.drive.kLeftMotor);
    }
    else {
      motor1 = MotorFactory.createTalonFX(Constants.drive.kRightMotor);
    }
    // TODO 2.3: set up configuration of motors/encoders
    setSpeed(0.1);
  }

  // TODO 2.3: add a function or more to control the drivetrain
  public void setSpeed(double power) {
    motor1.set(ControlMode.PercentOutput, power);
  }
}
