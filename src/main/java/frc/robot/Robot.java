// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.text.RuleBasedCollator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import frc.robot.commands.BangBang;
import frc.robot.commands.RunUntilCondition;
import frc.robot.controls.Driver;
import frc.robot.controls.Operator;
import frc.robot.subsystems.Drivetrain;

import frc.robot.util.ShuffleboardManager;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autoCommand;
  public static ShuffleboardManager shuffleboard = new ShuffleboardManager();

  public static Drivetrain drive = new Drivetrain();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

    // This is really annoying so it's disabled
    DriverStation.silenceJoystickConnectionWarning(true);

    shuffleboard.setup();

    // add drive to driver so that it can run commands based on button inputs
    Driver.drive = drive;
    Driver.configureControls();
    Operator.configureControls();



    
    // drive.gogogo();

    
    // TODO 2.1: replace the "new RunCommand" tank drive command with the arcade drive command you have written
    drive.setDefaultCommand(
      //new RunCommand(() -> drive.gogogo(), drive)
      new RunCommand(() -> drive.arcadeDrive(Driver.getRawThrottleValue(), Driver.getRawTurnValue()), drive)
      // new RunCommand(() -> drive.tankDrive(Driver.getRawLeft(), Driver.getRawRight()), drive)
    );
    // TODO 2.2: schadule your new command

     //drive.setDefaultCommand(new RunUntilCondition(drive));
    //CommandScheduler.getInstance().schedule(new RunUntilCondition(drive));
    // RunUntilCondition customCmd = new RunUntilCondition(drive);
    // customCmd.schedule();
    
    // TODO 2.4: replace the command from 2.2 with your new command
    // drive.setDefaultCommand(new BangBang(drive));
    
    
    drive.setDefaultCommand(
      
      new RunCommand(() -> drive.arcadeDrive(Driver.getRawThrottleValue(), Driver.getRawTurnValue()), drive)
    //   // new RunCommand(() -> drive.tankDrive(Driver.getRawLeft(), Driver.getRawRight()), drive)
    );
    // TODO 3.2: Replace the above function with a RunCommand which has a lambda to the arcadeDrive function in drivetrain
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void disabledPeriodic() {
    m_autoCommand = getAutonomousCommand();
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link Robot} class.
   */
  @Override
  public void autonomousInit() {
    if (m_autoCommand != null) {
      m_autoCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // TODO 2.2 put command HERE instead lmao
    //CommandScheduler.getInstance().schedule(new RunUntilCondition(drive));
    CommandScheduler.getInstance().schedule(new BangBang(drive));
    if (m_autoCommand != null) {
      m_autoCommand.cancel();
    }

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return shuffleboard.getAutonomousCommand();
  }
}
