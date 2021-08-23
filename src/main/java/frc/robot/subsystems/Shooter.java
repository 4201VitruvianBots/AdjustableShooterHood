// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private final double gearRatio = 14.0 / 48.0;
  private final double minAngle = 0;
  private final double maxAngle = 180; // in degrees, furthest angle the hood can adjust to
  private final boolean leftInverted = false;
  private final boolean rightInverted = false;

  private final Servo[] servoMotors = { new Servo(Constants.leftServoMotor), new Servo(Constants.rightServoMotor) };

  public Shooter() {
    servoMotors[0].setAngle(0);
    servoMotors[1].setAngle(0);
  }

  public void testServo(double angle, boolean left) {
    if (angle > maxAngle) {
      angle = maxAngle;
    } else if (angle < minAngle) {
      angle = minAngle;
    }
    if (left) {
      servoMotors[0].setAngle(angle);
    } else {
      servoMotors[1].setAngle(angle);
    }
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

  public double getServosAngle(boolean left) {
    return servoMotors[left ? 0 : 1].getAngle();
  }

  public void setServosSpeed(double speed) {
    servoMotors[0].setSpeed(speed);
    servoMotors[1].setSpeed(speed);
  }

  public void setSpeed(double speed, boolean left) {
    SmartDashboard.putNumber("Speed", speed);
    if (left) {
      servoMotors[0].setSpeed(speed);
    } else {
      servoMotors[1].setSpeed(speed);
    }
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("left servo angle", servoMotors[0].getAngle());
    SmartDashboard.putNumber("right servo angle", servoMotors[1].getAngle());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
