// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  private final CANSparkMax shooterMotor = new CANSparkMax(10, MotorType.kBrushless);
 
  private static ShooterSubsystem instance = null;
  public final RelativeEncoder shooterEncoder = shooterMotor.getEncoder();

  public ShooterSubsystem() {}

  public static ShooterSubsystem getInstance() {
    if (instance == null) {
      instance = new ShooterSubsystem();
    }  
    return instance;
  }

  public double gSS() {
  //get Shooter Speed :)
  return shooterEncoder.getVelocity();
  }

  public void runShooter() {
    shooterMotor.set(0.75);
  }

  public void stopShooter() {
    shooterMotor.set(0);
  }
//reverse shooter
  public void antiShoot() {
    shooterMotor.set(-0.75);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
