// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterHood;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurnShooterHoodToAngle extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ShooterHood m_shooterHood;
  private final double m_angle;

  /**
   * This is the constructor which sets inputAngle to the double angle
   *
   * @param takes in inputAngle
   */
  public TurnShooterHoodToAngle(ShooterHood shooterHood, double inputAngle) {
    // Use requires() here to declare subsystem dependencies
    // requires(shooterhood);
    m_shooterHood = shooterHood;
    m_angle = inputAngle;

    addRequirements(shooterHood);
  }

  // Called just before this Command runs the first time
  public void initialize() {
  }

  /**
   * takes in a double angle for the motor's position and moves motor to said
   * position
   */
  // Called repeatedly when this Command is scheduled to run
  public void execute() {
    m_shooterHood.setHoodAngle(m_angle);
  }

  /**
   * when the angle of the motor equals the set angle, the command terminates
   */
  // Make this return true when this Command no longer needs to run execute()
  public boolean isFinished() {
    if (m_shooterHood.getHoodAngle() == m_angle)
      return true;
    else
      return false;
  }

  // Called once after isFinished returns true
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}
