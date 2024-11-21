// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class Shoot extends Command {
  /** Creates a new ShootCommand. */
  
  private ShooterSubsystem shooterSub;
  private IntakeSubsystem intakeSub;
  double velo;

  public Shoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    shooterSub = ShooterSubsystem.getInstance();
    intakeSub = IntakeSubsystem.getInstance();
    // this hahahah means velocity
    addRequirements(shooterSub);
    addRequirements(intakeSub);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSub.runShooter();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    velo = shooterSub.gSS();
    if (velo >= 2000){
      intakeSub.runIntakes();
      
    }
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
