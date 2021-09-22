/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterHood;

/**
 * An example command that uses an example subsystem.
 */
public class SetHood extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ShooterHood m_ShooterHood;
  private final int m_ShootingPosition;
  private final double TrenchHoodAngle = 30;
  private final double LineHoodAngle = 60;
  private final double TargetHoodAngle = 0;

  /**
   * Creates a new ExampleCommand.
   *
   */
  public SetHood(ShooterHood shooterHood, int ShooterPosition) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_ShooterHood = shooterHood;
    m_ShootingPosition = ShooterPosition;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    switch (m_ShootingPosition) {
      case 0:
        // Shooting from the trench
        m_ShooterHood.setHoodAngle(TrenchHoodAngle);
        break;
      case 1:
        // Shooting from the initiation line
        m_ShooterHood.setHoodAngle(LineHoodAngle);
        break;
      case 2:
        // Shooting from the initiation line
        m_ShooterHood.setHoodAngle(TargetHoodAngle);
        break;
      default:
        break;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // switch (m_ShootingPosition) {
    //   case 0:
    //     // Shooting from the trench
    //     m_ShooterHood.setHoodAngle(TrenchHoodAngle);
    //     break;
    //   case 1:
    //     // Shooting from the initiation line
    //     m_ShooterHood.setHoodAngle(LineHoodAngle);
    //     break;
    //   case 2:
    //     // Shooting from the initiation line
    //     m_ShooterHood.setHoodAngle(TargetHoodAngle);
    //     break;
    //   default:
    //     break;
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ShooterHood.setHoodAngle(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (false);
  }
}
