// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterHood extends SubsystemBase {
  // private final double gearRatio = 14.0 / 48.0;
  private final boolean ShooterHoodInvertion = false;
  private final Servo ShooterHoodServo = new Servo(Constants.ShooterHoodServo);

  public ShooterHood() {
    // servoMotors[0].setAngle(0);
    // servoMotors[1].setAngle(0);
  }

  public void setHoodAngle(double degrees) {
    if (degrees >= Constants.minHoodValue && degrees <= Constants.maxHoodValue)
      ShooterHoodServo.setAngle(Constants.maxHoodValue - degrees);
    else// drive to nearest limit (> because higher angle means hood moves lower)
    if (Math.abs(this.getHoodAngle() - Constants.minHoodValue) < Math.abs(this.getHoodAngle() - Constants.maxHoodValue))
      ShooterHoodServo.setAngle(Constants.minHoodValue);
    else
      ShooterHoodServo.setAngle(Constants.maxHoodValue);

  }

  public double getHoodAngle() {
    return ShooterHoodServo.getAngle();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("ShooterHoodServo angle", ShooterHoodServo.getAngle());
    SmartDashboard.putNumber("ShooterHoodServo position", ShooterHoodServo.getPosition());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
