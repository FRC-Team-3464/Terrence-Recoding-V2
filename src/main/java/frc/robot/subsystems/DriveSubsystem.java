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
  
  private CANSparkMax leftFront = new CANSparkMax(4, MotorType.kBrushless);
  private CANSparkMax rightFront = new CANSparkMax(5, MotorType.kBrushless);
  private CANSparkMax leftBack = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax rightBack = new CANSparkMax(3, MotorType.kBrushless);
    // leftFront = RobotMap.leftFront, 
    // leftBack = RobotMap.leftBack, 
    // rightFront = RobotMap.rightFront, 
    // rightBack = RobotMap.rightBack;
  public DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);

  public DriveSubsystem(){ 
      leftFront.setInverted(true);
      
  }

  public void tankDrive(double left, double right){
    if (Math.abs(left) < 0.07) {
      left = 0;
      
    }
    if (Math.abs(right) < 0.07) {
      right = 0;  
      
    }
     
    drive.tankDrive(left,right);
    leftBack.set(leftFront.get());
    rightBack.set(rightFront.get());
  }

  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
    leftBack.set(leftFront.get());
    rightBack.set(rightFront.get());
  }

public void stopDrive(){
  arcadeDrive(0, 0); 
}

  public double getLeft(){
    return leftFront.get();
  }

  public double getRight(){
    return rightFront.get();
  }
  
  public void enableMotors(boolean on){
    IdleMode mode;
    if (on) {
      mode = IdleMode.kBrake;
    }
    else{
      mode = IdleMode.kCoast;
    } 
    leftFront.setIdleMode(mode);
    leftBack.setIdleMode(mode);
    rightFront.setIdleMode(mode);
    rightBack.setIdleMode(mode);
  }

  @Override
  public void periodic() {
  }
}
