// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */
  // These define the inputs/objects used in the code
  private final Spark elevatorMotor = new Spark(2);
  private final DigitalInput topLimitSwitch = new DigitalInput(1);
  private final DigitalInput bottomLimitSwitch = new DigitalInput(0);
  private static ClimberSubsystem instance = null;

  // public static ClimberSub() {

  //  }
  public static ClimberSubsystem getInstance() {
    if (instance == null) {
      instance = new ClimberSubsystem();
    }
    return instance;
  }

  public ClimberSubsystem() {}

  // Method to move the elevator up if it doesn't hit switch.
  public void elevatorUp(){
    if(!topLimitSwitch.get() == true){
      elevatorMotor.set(0);
    } else {
      elevatorMotor.set(-1);
    }
  }
  // Method to move the elevator down if it hits switch.
  public void elevatorDown(){
    if (!bottomLimitSwitch.get() == true){
      elevatorMotor.set(0);
    } else {
      elevatorMotor.set(1);
    }
  }

  // Return top and bottom switch states (true/false)
  public Boolean bottomSwitchState(){
    return bottomLimitSwitch.get();
  }

  public Boolean topSwitchState(){
    return topLimitSwitch.get();
  }

  // Stops the motor when it needs to stop (duh)
  public void stopMotor(){
    elevatorMotor.stopMotor();
  }

  //Function returns the ClimberSubsystem instance
  // public static ClimberSubsystem getInstance(){
  //   if(instance == null) {
  //     instance = mew ClimberSubsystem();
  //   }
  //   return instance:
  // }

  public void periodic() {
    // System.out.println(topLimitSwitch.get());
    System.out.println(bottomLimitSwitch.get());
    // This method will be called once per scheduler run
  }
}
