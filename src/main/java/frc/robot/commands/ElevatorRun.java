// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberSubsystem;

public class ElevatorRun extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private ClimberSubsystem climberSub;
  private boolean climberDirection;
  
  /** Creates a new ElevatorUp. */
  public ElevatorRun(Boolean direction) {
    // Use addRequirements() here to declare subsystem dependencies.
    climberSub = ClimberSubsystem.getInstance();

    climberDirection = direction;
    addRequirements(climberSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (climberDirection) {
      climberSub.elevatorUp();
    }
    else {
      climberSub.elevatorDown();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climberSub.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
