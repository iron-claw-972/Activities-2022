/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import ctre_shims.PhoenixMotorControllerGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;


public class Drivetrain extends SubsystemBase {

  // TODO 1: Create Motor Objects using MotorFactory.createTalonFX(int id)
  // the ID should be set in the DriveConstants.java file, here you can access it like Constants.drive.kRightMotor1
  WPI_TalonFX leftMotor1;
  WPI_TalonFX rightMotor1;
  WPI_TalonFX leftMotor2;
  WPI_TalonFX rightMotor2;

  // TODO 2: Add two instances of PhoenixMotorControllerGroup(leadMotor, motor2), one for each side. 
  PhoenixMotorControllerGroup leftMotors;
  PhoenixMotorControllerGroup rightMotors; 

  /**
   * Creates a new DriveSubsystem.
   */
  public Drivetrain() {
    // TODO 1: This constructor runs when the subsystem is created so you can do some setup here. Make the secondary motors follow the main ones.
    // You can also invert the motors, you often need to invert one side to make the robot drive since the motors on one side are flipped.
    // Examples for how are below, replace the variable motor with your motor variable and make sure you set the right motors! Do not only invert one motor on a side or it may mesh against the other motor
    // motor.setInverted(true);
    // motor.follow(mainMotor);



    // TODO 2: Change all of the setup above. Motors in a group automatically follow each other so do not set them as followers. You can set them inverted as such:
    // leftMotors.setInverted(true);
  }

  /**
   * Drives the robot using tank drive controls
   * Tank drive is slightly easier to code but less intuitive to control, so this is here as an example for now
   * @param leftPower the commanded power to the left motors
   * @param rightPower the commanded power to the right motors
   */
  public void tankDrive(double leftPower, double rightPower) {
    // TODO 2: Instead of setting motors set the MotorControllerGroup, using motorGroup.set(speed)
    leftMotor1.set(ControlMode.PercentOutput, leftPower);
    rightMotor1.set(ControlMode.PercentOutput, rightPower);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param forward the commanded forward movement
   * @param turn the commanded turn rotation
   */
  public void arcadeDrive(double throttle, double turn) {
    
  }
}
