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

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;


public class Drivetrain extends SubsystemBase {

  // TODO 1.1: Create Motor Objects using MotorFactory.createTalonFX(int id)
  // the ID should be set in the DriveConstants.java file, here you can access it like Constants.drive.kRightMotor
  WPI_TalonFX leftMotor1 = new WPI_TalonFX(Constants.drive.kRightMotor);
  WPI_TalonFX rightMotor1 = new WPI_TalonFX(Constants.drive.kLeftMotor);
  // TODO 1.1 if you don't have a second motor skip the second motors
//  WPI_TalonFX leftMotor2;
//  WPI_TalonFX rightMotor2;

  // TODO 1.2: Add two instances of PhoenixMotorControllerGroup(leadMotor, motor2), one for each side. (if you don't have a second motor just make it with with one motor, you wouldn't actually do this but you should still learn about motor controller groups)
  PhoenixMotorControllerGroup leftMotors = new PhoenixMotorControllerGroup(leftMotor1);
  PhoenixMotorControllerGroup rightMotors = new PhoenixMotorControllerGroup(rightMotor1);

  // TODO 4.1: Initialize the PIDController here, including three doubles for the P, I, and D values. You should get these from DriveConstants.
  // TODO 4.1: Also add a double for the setpoint, and a boolean for if the PID is enabled.

  /**
   * Creates a new DriveSubsystem.
   */
  public Drivetrain() {
    // TODO 1.1: This constructor runs when the subsystem is created so you can do some setup here. Make the secondary motors follow the main ones, if you have them.
    // You can also invert the motors, you often need to invert one side to make the robot drive since the motors on one side are flipped.
    // Examples for how are below, replace the variable motor with your motor variable and make sure you set the right motors!
    // motor.setInverted(true);
    // motor.follow(mainMotor);



    // TODO 1.2: Change all of the setup above. Motors in a group automatically follow each other so do not set them as followers. You can set them inverted as such:
    // leftMotors.setInverted(true);

    
    // TODO 4.3: Make sure your PID object is public, or make a function that returns the object, so you can get it in ShuffleBoardManager
  }

  @Override
  public void periodic() {
    // TODO 4.1: Periodic runs periodically, so we will update the PID here and set the motors. 
    // If the pid is enabled (a boolean value declared above) then you should set the motors using the pid's calculate() function. Otherwise, it should set the motor power to zero.
    // pid.calculate() takes two values: calculate(processVariable, setpoint). get the process var by getting the encoders, and the setpoint is a variable declared above.
  }

  /**
   * Drives the robot using tank drive controls
   * Tank drive is slightly easier to code but less intuitive to control, so this is here as an example for now
   * @param leftPower the commanded power to the left motors
   * @param rightPower the commanded power to the right motors
   */
  public void tankDrive(double leftPower, double rightPower) {
    // TODO 1.2: Instead of setting motors set the MotorControllerGroup, using motorGroup.set(speed)
    leftMotors.set(MathUtil.clamp(leftPower, -1, 1) * 0.5);
    rightMotors.set(MathUtil.clamp(rightPower, -1, 1) * 0.5);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param throttle the commanded forward movement [0-1]
   * @param turn the commanded turn rotation [0-1]
   */
  public void arcadeDrive(double throttle, double turn) {
    // TODO 2.1: write an arcade drive here
    throttle = MathUtil.clamp(throttle, -1, 1);
    turn = MathUtil.clamp(turn, -1, 1);
    leftMotors.set((throttle + turn) * 0.2);
    rightMotors.set((throttle - turn) * -0.2);
  }

  public WPI_TalonFX getLeftEncoder() {
    return leftMotor1;
  }

  public WPI_TalonFX getRightEncoder() {
    return rightMotor1;
  }

  // TODO 4.1: write three functions, one for setting the setpoint, and one for setting whether the pid is enabled. The last one is a function to reset the PID with pid.reset()
}
