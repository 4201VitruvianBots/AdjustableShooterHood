// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utils.RevServo;

public class ShooterHood extends SubsystemBase {
  private double SmartDashboardValue;
  private final RevServo[] ShooterHoodServos = {
    new RevServo(Constants.LeftShooterHoodServo),
    new RevServo(Constants.RightShooterHoodServo)
  };

  public ShooterHood() {
    initShuffleboard();
  }

  public void setHoodAngle(double degree) {
    ShooterHoodServos[0].setAngle(270 - degree);
    ShooterHoodServos[1].setAngle(degree);
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
