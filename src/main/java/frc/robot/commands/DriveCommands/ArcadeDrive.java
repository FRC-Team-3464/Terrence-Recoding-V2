// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */


// defining variables for the drive subsystem and the controller for later
  private final DriveSubsystem driveSub;
  private final XboxController controller = Constants.OperatorConstants.xbox;


  // adds the requirements for the arcade drive subsystems so that the drive can be used for later
  public ArcadeDrive(DriveSubsystem drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSub = drive;
    addRequirements(driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.

  // 
  @Override
  public void execute() {
    // Using the controller to get the speed and rotation using method from drive subsystem
    driveSub.arcadeDrive(controller.getLeftY()*.5,controller.getRightX()*0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Using method from drive subsystem to stop motors
    driveSub.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
