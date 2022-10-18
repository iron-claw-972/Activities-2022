package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;


public class SideOfDrivetrain extends SubsystemBase {

  // TODO 2.3: add motors/ motor group
  WPI_TalonFX motor;

  public SideOfDrivetrain(boolean isLeft) {
    // TODO 2.3: use the boolean isLeft to set if it is left or right
      if(isLeft == false)
      {
          motor = new WPI_TalonFX(Constants.drive.kRightMotor);
      }
      else
      {
          motor = new WPI_TalonFX(Constants.drive.kLeftMotor);
      }
    // TODO 2.3: set up configuration of motors/encoders
        
  }

  // TODO 2.3: add a function or more to control the drivetrain
  public void go(double tick)
  {
      if(tick < 1040)
      {
          motor.set(ControlMode.PercentOutput, 0.1 );
      }   
      else
      {
        motor.set(ControlMode.PercentOutput, 0.3 );
      }
  }
  public void banana()
  {
    
      for(int i = 0; i < 10; i++)
      {
        go(motor.getSelectedSensorPosition()); 
      }

  }
}
