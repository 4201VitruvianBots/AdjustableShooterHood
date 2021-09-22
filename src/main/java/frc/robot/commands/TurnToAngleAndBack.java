// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import frc.robot.subsystems.Shooter;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// /** An example command that uses an example subsystem. */
// public class TurnToAngleAndBack extends CommandBase {
//   @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//   private final Shooter m_shooter;
//   private double m_startingAngle;
//   private final double m_angle;
//   private double m_startTime;

//   /**
//    * Creates a new ExampleCommand.
//    *
//    * @param subsystem The subsystem used by this command.
//    */
//   public TurnToAngleAndBack(Shooter shooter, double angle) {
//     m_shooter = shooter;
//     m_angle = angle;
//     // Use addRequirements() here to declare subsystem dependencies.
//     addRequirements(shooter);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     m_startTime = Timer.getFPGATimestamp();
//     m_startingAngle = m_shooter.getServosAngle(false);
//     //m_shooter.testServo(m_angle, false);
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     m_shooter.testServo(m_angle, true);
//     //m_shooter.setSpeed(Math.sin(Timer.getFPGATimestamp() - m_startTime), true);
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     m_shooter.testServo(m_startingAngle, true);
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return Timer.getFPGATimestamp() - m_startTime >= 2;
//   }
// }
