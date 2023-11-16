package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.DriveConstants;
import frc.robot.subsystems.Drivetrain;

// ~10,240 ticks req
// need to account for gearing (mult by 8)
// so it's ~81,920 ticks

public class Turn180 extends CommandBase {
    Drivetrain m_drive;
    WPI_TalonFX leftMotor;
    WPI_TalonFX rightMotor;

    PIDController leftPID;
    PIDController rightPID;

    static final int ticks = 81920;

    public Turn180(Drivetrain m_drive, DriveConstants consts) {
        this.m_drive = m_drive;
        leftMotor = m_drive.getLeftEncoder();
        rightMotor = m_drive.getLeftEncoder();
        addRequirements(m_drive);
        leftPID = new PIDController(consts.kPLinear, consts.kILinear, consts.kDLinear);
        rightPID = new PIDController(consts.kPLinear, consts.kILinear, consts.kDLinear);
        leftPID.setTolerance(consts.kPTolerance, consts.kVTolerance);
        rightPID.setTolerance(consts.kPTolerance, consts.kVTolerance);
    }

    public void initialize() {
        leftMotor.setSelectedSensorPosition(0);
        rightMotor.setSelectedSensorPosition(0);
    }

    public void execute() {
        m_drive.tankDrive(leftPID.calculate(leftMotor.getSelectedSensorPosition(), ticks),
            rightPID.calculate(rightMotor.getSelectedSensorPosition(), -ticks));
    }

    public void end(boolean interrupted) {
        m_drive.tankDrive(0.0, 0.0);
    }

    public boolean isFinished() {
        return leftPID.atSetpoint() && rightPID.atSetpoint();
    }
}
