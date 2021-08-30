// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TurnShooterHoodToAngle;
import frc.robot.subsystems.ShooterHood;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  static Joystick leftJoystick = new Joystick(Constants.leftJoystick);
  static Joystick rightJoystick = new Joystick(Constants.rightJoystick);
  static Joystick xBoxController = new Joystick(Constants.xBoxController);
  private final ShooterHood m_shooterHood = new ShooterHood();

  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_shooter);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

  }

  public void teleOp() {
    // m_shooterHood.setHoodAngle(leftJoystick.getRawAxis(0) * 270);
    if (leftJoystick.getRawAxis(0) < 0.05 && leftJoystick.getRawAxis(0) > -0.05) {
      m_shooterHood.stopHoodServos();
    } else {
      m_shooterHood.setHoodSpeed(leftJoystick.getRawAxis(0));
    }
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return new SequentialCommandGroup(new TurnShooterHoodToAngle(m_shooterHood,
    // 1), new WaitCommand(2),
    // new TurnShooterHoodToAngle(m_shooterHood, 1));
    return new WaitCommand(0);
  }
}
