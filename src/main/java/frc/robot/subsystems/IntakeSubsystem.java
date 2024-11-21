// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  // initializing the upper and lower sparkMaxes
  private final Spark lowerMotor = new Spark(0);
  private final Spark upperMotor = new Spark(1);

  private static IntakeSubsystem instance = null;

  // sets the catagory for the intake sub
  public IntakeSubsystem() {}

  public static IntakeSubsystem getInstance() {
    if (instance == null) {
      instance = new IntakeSubsystem();
    }  
    return instance;
  }

  // specifies bottom intake
  public void runIntakeBottom() {
    lowerMotor.set(-0.25);
  }
  // this runs both intake systems
  public void runIntakes() {
    upperMotor.set(-0.325);
    lowerMotor.set(-0.25);
  }
  // this will spit out the ball through the bottom
  public void ejectBalls() {
    upperMotor.set(0.29);
    lowerMotor.set(0.27);
  }

  //stops the motors
  public void stopIntakes() {
    upperMotor.set(0); 
    lowerMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
