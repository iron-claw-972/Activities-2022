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
  // the ID should be set in the DriveConstants.java file, here you can access it like Constants.drive.kRightMotor
  WPI_TalonFX leftMotor1 = new WPI_TalonFX(16);
  WPI_TalonFX rightMotor1 = new WPI_TalonFX(34);

  PhoenixMotorControllerGroup leftMotors = new PhoenixMotorControllerGroup(leftMotor1);
  PhoenixMotorControllerGroup rightMotors = new PhoenixMotorControllerGroup(rightMotor1);

  // TODO 4.1: Initialize the PIDController here, including three doubles for the P, I, and D values. You should get these from DriveConstants.
  // TODO 4.1: Also add a double for the setpoint, and a boolean for if the PID is enabled.

  /**
   * Creates a new DriveSubsystem.
   */
  public Drivetrain() {
    leftMotors.setInverted(true);
    
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
    leftMotors.set(leftPower);
    rightMotors.set(rightPower);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param forward the commanded forward movement
   * @param turn the commanded turn rotation
   */
  public void arcadeDrive(double throttle, double turn) {
    // TODO 2.1: write an arcade drive here
  }

  // TODO 4.1: write three functions, one for setting the setpoint, and one for setting whether the pid is enabled. The last one is a function to reset the PID with pid.reset()
}
