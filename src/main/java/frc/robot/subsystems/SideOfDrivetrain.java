package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;


public class SideOfDrivetrain extends SubsystemBase {

  // TODO 2.3: add motors/ motor group
  public final Drivetrain m_drive = new Drivetrain();
  public PhoenixMotorControllerGroup sideofmod;
  public int amount = 60;
  public int mult = 1;
  public SideOfDrivetrain(boolean isLeft) {
    // TODO 2.3: use the boolean isLeft to set if it is left or right
    // TODO 2.3: set up configuration of motors/encoders
    if (isLeft) {sideofmod = m_drive.leftMotors; mult = -1;
      amount=-60;}
    else sideofmod = m_drive.rightMotors;
  }
  public PhoenixMotorControllerGroup getSideOfMod() {return sideofmod;}
  // TODO 2.3: add a function or more to control the drivetrain
  @Override
  public void periodic() {
    // move forward at .3 speed
    sideofmod.set(.3*mult);

    /*
    // oscillator, initial spin depends on isLeft
    if (amount==60) mult=-1;
    if (amount==-60) mult = 1;
    amount += mult;
    sideofmod.set((double)amount/100.0);
    */
  }


}
