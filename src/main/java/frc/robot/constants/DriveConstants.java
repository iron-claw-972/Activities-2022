package frc.robot.constants;

public class DriveConstants {

  public static final int kRightMotor = 34;
  public static final int kLeftMotor = 16;
  // TODO 1.1: Add the other motor port, kLeftMotor, and if you have them, kRightMotor2, kLeftMotor2, the same as above.
  // All of the ports should be public (so they can be accessed anywhere) and final (so they don't change)
  // find the ID through the motor label, electrical spreadsheet, or phoenix tuner (ask us for help)
  

  // TODO 4.1: Add three constants for P, I, and D values. A good starting point is zero for I and D, and a very small value for P
  // If you are using your own subsystem then do not make the constants here, make them in a new constants file! Then, go to constants.java and make a public static final instance of your constants file
  public static final double kPLinear = 0.001;
  public static final double kILinear = 0.0;
  public static final double kDLinear = 0.0;

  public static final double kPRot = 0.001;
  public static final double kIRot = 0.0;
  public static final double kDRot = 0.0;

  public static final int kPTolerance = 10;
  public static final int kVTolerance = 5;
  public static final int kMeter = 53000;
}
