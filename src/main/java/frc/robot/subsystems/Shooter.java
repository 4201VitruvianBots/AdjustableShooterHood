// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  // private final double gearRatio = 14.0 / 48.0;
  private final double minAngle = 0;
  private final double maxAngle = 180; // in degrees, furthest angle the hood can adjust to
  private final boolean leftServoInverted = false;
  private final boolean rightServoInverted = true;

  private final Servo[] servoMotors = { new Servo(Constants.leftServoMotor), new Servo(Constants.rightServoMotor) };

  public Shooter() {
    // servoMotors[0].setAngle(0);
    // servoMotors[1].setAngle(0);
  }

  public void testServo(double angle, int index) {
    if (angle > maxAngle) {
      angle = maxAngle;
    }
    if (angle < minAngle) {
      angle = minAngle;
    }
    servoMotors[index].setAngle(angle);
  }

  // Angle in degrees
  public void setServosAngle(double angle) {
    if (angle > maxAngle) {
      angle = maxAngle;
    } else if (angle < minAngle) {
      angle = minAngle;
    }
    if (leftServoInverted) {
      servoMotors[0].setAngle(maxAngle - angle);
    } else {
      servoMotors[0].setAngle(angle);
    }
    if (rightServoInverted) {
      servoMotors[1].setAngle(maxAngle - angle);
    } else {
      servoMotors[1].setAngle(angle);
    }
  }

  public double getServosAngle(int index) {
    return servoMotors[index].getAngle();
  }

  public void setSpeed(int index, double speed) {
    servoMotors[index].setSpeed(speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("left servo angle", servoMotors[0].getAngle());
    SmartDashboard.putNumber("right servo angle", servoMotors[1].getAngle());
    SmartDashboard.putNumber("Speed Index 0", servoMotors[0].getSpeed());
    SmartDashboard.putNumber("Speed Index 1", servoMotors[1].getSpeed());
    SmartDashboard.putNumber("left servo position", servoMotors[0].getPosition());
    SmartDashboard.putNumber("right servo position", servoMotors[1].getPosition());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
