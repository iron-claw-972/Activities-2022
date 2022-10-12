package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.util.MotorFactory;

public class RunExtraMotor extends SubsystemBase {
  // DONE 2.3: Rename the subsystem
  // DONE 2.3: make motors and/or sensors 
  WPI_TalonFX extraMotor = MotorFactory.createTalonFX(Constants.drive.kExtraMotor);
  
  // TODO 4.1: Initialize the PIDController here, including three doubles for the P, I, and D values. You should get these from DriveConstants.
  // TODO 4.1: Also add a double for the setpoint, and a boolean for if the PID is enabled.

  public RunExtraMotor() {
    // TODO 4.3: Add the PID you made to shuffle board (you can do this in the Subsystem or ShuffleBoardManager class)
  }

  public void periodic() {
    // TODO 4.1: Periodic runs periodically, so we will update the PID here and set the motors. 
    // If the pid is enabled (a boolean value declared above) then you should set the motors using the pid's calculate() function. Otherwise, it should set the motor power to zero.
    // pid.calculate() takes two values: calculate(processVariable, setpoint). get the process var by getting the encoders, and the setpoint is a variable declared above.
  }


  // DONE 2.3: add some functions that you might use, for example functions to set the motor power
  public void set25PercentPower(){
    extraMotor.set(ControlMode.PercentOutput, 0.25); 
  }

  public void set50PercentPower(){
    extraMotor.set(ControlMode.PercentOutput, 0.5); 
  }

  public void set100PercentPower(){
    extraMotor.set(ControlMode.PercentOutput, 1); 
  }
  // TODO 4.1: write three functions, one for setting the setpoint, and one for setting whether the pid is enabled. The last one is a function to reset the PID with pid.reset()
}
