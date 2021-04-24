// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final double gearRatio = 14.0 / 48.0;
  private final double minAngle = 0;
  private final double maxAngle = 30; // in degrees, furthest angle the hood can adjust to
  private final boolean leftInverted = false;
  private final boolean rightInverted = true;

  private final Servo[] servoMotors = {
    new Servo(Constants.leftServoMotor),
    new Servo(Constants.rightServoMotor)
  };

  /** Creates a new ExampleSubsystem. */
  public Shooter() {
    servoMotors[0].set(0);
    servoMotors[1].set(0);
  }

  public void testServo(double angle) {
    servoMotors[0].setAngle(angle);
  }

  // Angle in degrees
  public void setServosAngle(double angle) {
    if (angle > maxAngle) {
      angle = maxAngle;
    } else if (angle < minAngle) {
      angle = minAngle;
    }
    if (leftInverted) {
      servoMotors[0].setAngle(maxAngle - angle);
    } else {
      servoMotors[0].setAngle(angle);
    }
    if (rightInverted) {
      servoMotors[1].setAngle(maxAngle - angle);
    } else {
      servoMotors[1].setAngle(angle);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
