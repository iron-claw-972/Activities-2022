package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;

public class SpinAround extends CommandBase {
    Drivetrain m_drive;
    WPI_TalonFX leftMotor;
    WPI_TalonFX rightMotor;

    PIDController leftPID;
    PIDController rightPID;

    static final int ticks = 10 * 8 * 2048;

    public SpinAround(Drivetrain m_drive) {
        this.m_drive = m_drive;
        leftMotor = m_drive.getLeftEncoder();
        rightMotor = m_drive.getLeftEncoder();
    }

    public void initialize() {
        leftMotor.setSelectedSensorPosition(0);
        rightMotor.setSelectedSensorPosition(0);
        m_drive.arcadeDrive(0, 1.0);
    }

    public void execute() {}

    public void end(boolean interrupted) {
        m_drive.arcadeDrive(0.0, 0.0);
    }

    public boolean isFinished() {
        return Math.abs(leftMotor.getSelectedSensorPosition()) > ticks && Math.abs(rightMotor.getSelectedSensorPosition()) > ticks;
    }
}
