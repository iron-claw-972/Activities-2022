package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class ExtraMotor extends SubsystemBase {
  // TODO 2.3: make motors and/or sensors 
  WPI_TalonFX extramotor = new WPI_TalonFX(Constants.drive.kextraMotor);

  // TODO 4.1: Initialize the PIDController here, including three doubles for the P, I, and D values. You should get these from DriveConstants.
  // TODO 4.1: Also add a double for the setpoint, and a boolean for if the PID is enabled.

  public ExtraMotor() {
    // TODO 4.3: Add the PID you made to shuffle board (you can do this in the Subsystem or ShuffleBoardManager class)
  }

  public void periodic() {
    // TODO 4.1: Periodic runs periodically, so we will update the PID here and set the motors. 
    // If the pid is enabled (a boolean value declared above) then you should set the motors using the pid's calculate() function. Otherwise, it should set the motor power to zero.
    // pid.calculate() takes two values: calculate(processVariable, setpoint). get the process var by getting the encoders, and the setpoint is a variable declared above.
  }


  // TODO 2.3: add some functions that you might use, for example functions to set the motor power
 public void setmotor(double power){
  extramotor.set(power);

 }
 public double getEncodervalues(){
  extramotor.setSelectedSensorPosition(0);
  return extramotor.getSelectedSensorPosition();

}

  // TODO 4.1: write three functions, one for setting the setpoint, and one for setting whether the pid is enabled. The last one is a function to reset the PID with pid.reset()
}