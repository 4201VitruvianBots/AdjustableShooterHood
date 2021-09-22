// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterHood extends SubsystemBase {
  private double SmartDashboardValue;
  private final Servo[] ShooterHoodServos = { new Servo(Constants.LeftShooterHoodServo),
  new Servo(Constants.RightShooterHoodServo) };

  public ShooterHood() {
    initShuffleboard();
  }

  public void setHoodAngle(double degrees, boolean left) {
    double LeftShooterHoodServoGoal = degrees;
    double RightShooterHoodServoGoal = Constants.maxHoodValue - degrees;
    double LeftShooterHoodServoAngleEstimate = 0;
    double RightShooterHoodServoAngleEstimate = 0;

    if (degrees >= Constants.minHoodValue && degrees <= Constants.maxHoodValue) {
      LeftShooterHoodServoGoal = degrees;
      RightShooterHoodServoGoal = Constants.maxHoodValue - degrees;
    }
    if (degrees < Constants.minHoodValue) {
      LeftShooterHoodServoGoal = Constants.minHoodValue;
      RightShooterHoodServoGoal = Constants.maxHoodValue;
    }
    if (degrees > Constants.maxHoodValue) {
      // ShooterHoodServos[0].setAngle(Constants.maxHoodValue);
      // ShooterHoodServos[1].setAngle(Constants.minHoodValue);
      LeftShooterHoodServoGoal = Constants.maxHoodValue;
      RightShooterHoodServoGoal = Constants.minHoodValue;
    }

    // ShooterHoodServos[0].setAngle(Constants.minHoodValue);
    // ShooterHoodServos[1].setAngle(Constants.minHoodValue);
    if (left) {
      ShooterHoodServos[0].setAngle(LeftShooterHoodServoGoal);
     } else {
      ShooterHoodServos[1].setAngle(RightShooterHoodServoGoal);
     }

    // while ((LeftShooterHoodServoAngleEstimate != LeftShooterHoodServoGoal)
    //     && (RightShooterHoodServoAngleEstimate != RightShooterHoodServoGoal)) {
    //   ShooterHoodServos[0].setAngle(LeftShooterHoodServoAngleEstimate + 1);
    //   ShooterHoodServos[1].setAngle(RightShooterHoodServoAngleEstimate - 1);
    // }
  }

  public double getHoodAngle() {
    return ShooterHoodServos[0].getAngle();
  }

  public void setHoodAngleToSmartDashboardValue() {
    ShooterHoodServos[0].setAngle(SmartDashboardValue);
    // ShooterHoodServos[1].setAngle(Constants.maxHoodValue - SmartDashboardValue);
  }

  public double getHoodAngleSmartDashboardValue() {
    return SmartDashboardValue;
  }

  private void initShuffleboard() {
    SmartDashboardTab.putNumber("ShooterHood", "HoodAngle", getHoodAngle());
  }

  private void updateShuffleboard() {
    SmartDashboard.putNumber("HoodAngle", getHoodAngle());
    SmartDashboardTab.putNumber("ShooterHood", "left angle", ShooterHoodServos[0].getAngle());
    SmartDashboardTab.putNumber("ShooterHood", "right angle", ShooterHoodServos[1].getAngle());
  }

  public void updateShooterAngles() {
    SmartDashboardValue = SmartDashboardTab.getNumber("ShooterHood", "HoodAngle", -1);
  }

  @Override
  public void periodic() {
    updateShuffleboard();
    updateShooterAngles();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
