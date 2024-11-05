// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.RunningIntakeSystems;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem; 
public class IntakeRunBoth extends Command {
  private IntakeSubsystem intakeSub;

  public IntakeRunBoth() {
    // Use addRequirements() here to declare subsystem dependencies.
    intakeSub = IntakeSubsystem.getInstance();
    addRequirements(intakeSub); 
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  //creates a override to run the intakes
  @Override
  public void execute() {
    intakeSub.runIntakes();
  }

  // Called once the command ends or is interrupted.
  //creates a override that stops the in takes from running
  @Override
  public void end(boolean interrupted) {
    intakeSub.stopIntakes();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
