package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;


public class SideOfDrivetrain extends SubsystemBase {
  private boolean isLeft;
  private WPI_TalonFX motor;
  public static double motorSpeed = 0.1;

  // TODO 2.3: add motors/ motor group

  public SideOfDrivetrain(boolean isLeft) {
    this.isLeft=isLeft;
    if(this.isLeft){
      motor=new WPI_TalonFX(Constants.drive.kLeftMotor);
    }else{
      motor=new WPI_TalonFX(Constants.drive.kRightMotor);
    }
    // TODO 2.3: use the boolean isLeft to set if it is left or right
    // TODO 2.3: set up configuration of motors/encoders
    motor.setInverted(!isLeft);
  }

  // TODO 2.3: add a function or more to control the drivetrain
  public void setOutput(double throttle){
     motor.set(throttle*motorSpeed);
  }
}
