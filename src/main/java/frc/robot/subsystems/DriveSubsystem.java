// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  //assigns the motor positions to a motor, define motors
  private static CANSparkMax leftFront = new CANSparkMax( 5, MotorType.kBrushless);
  private static CANSparkMax leftBack = new CANSparkMax(6, MotorType.kBrushless);
  private static CANSparkMax rightFront = new CANSparkMax(7, MotorType.kBrushless);
  private static CANSparkMax rightBack = new CANSparkMax(8, MotorType.kBrushless);

  // defining the front drive systems
  private static DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);


  private static DriveSubsystem instance = null;

  // sets the left front motor inverted
  public DriveSubsystem() {
    leftFront.setInverted(true);
  }

  public static DriveSubsystem getInstance(){
    if (instance == null){
      instance = new DriveSubsystem();
    }
    return instance;
  }

  // creates tank drive
  public void tankDrive(double left, double right) {
    // prevents stick drift
    if(Math.abs(left) <= 0.07) {
      left = 0;
    }
    if(Math.abs(right)<=0.07){
      right=0;
    }

    // setting the differential drive to tank drive
    drive.tankDrive(left, right);
    // make back motors follow the front
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

  }

  // making arcade drive
  public void arcadeDrive(double speed, double rotation) {
    // sets the differential drive to arcade drive
    drive.arcadeDrive(speed, rotation); 

    // making back motors follow the front
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
  }

  // stops the motor
  public void stopDrive() {
    arcadeDrive(0, 0);
  }

  // gets values
  public double getLeft(){
    return leftFront.get();
  }

  public double getRight() {
    return rightFront.get();
  }

  // sets motor mode
  public void enableMotors(boolean on){
    IdleMode mode;
    if (on) {
      mode = IdleMode.kBrake;
    }
    else{
      mode = IdleMode.kCoast;
    } 
    //set motors to mode
    leftFront.setIdleMode(mode);
    leftBack.setIdleMode(mode);
    rightFront.setIdleMode(mode);
    rightBack.setIdleMode(mode);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
