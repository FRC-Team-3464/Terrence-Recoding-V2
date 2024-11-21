// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.RunningIntakeSystems;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Eject extends Command {
  /** Creates a new Eject. */
  private ShooterSubsystem shooterSub;
  private IntakeSubsystem intakeSub;

  public Eject() {
    // Use addRequirements() here to declare subsystem dependencies.
    shooterSub = ShooterSubsystem.getInstance();
    intakeSub = IntakeSubsystem.getInstance();
    addRequirements(shooterSub);
    addRequirements(intakeSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSub.antiShoot();
    intakeSub.ejectBalls();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSub.stopShooter();
    intakeSub.stopIntakes();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
