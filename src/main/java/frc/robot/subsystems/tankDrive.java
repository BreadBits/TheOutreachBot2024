// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class tankDrive extends SubsystemBase {
  /** Creates a new tankDrive. */
  private CANSparkMax driveMotorR1;
  private CANSparkMax driveMotorR2;
  private CANSparkMax driveMotorL1;
  private CANSparkMax driveMotorL2;
  public tankDrive() {
    driveMotorR1 = new CANSparkMax(1,MotorType.kBrushless);
    driveMotorR2 = new CANSparkMax(2,MotorType.kBrushless); 
    driveMotorL1 = new CANSparkMax(4,MotorType.kBrushless);
    driveMotorL2 = new CANSparkMax(6,MotorType.kBrushless); 
    this.driveMotorR1.restoreFactoryDefaults();
    this.driveMotorR2.restoreFactoryDefaults();
    this.driveMotorL1.restoreFactoryDefaults();
    this.driveMotorL2.restoreFactoryDefaults();
    this.driveMotorR1.setSmartCurrentLimit(30);
    this.driveMotorR2.setSmartCurrentLimit(30);
    this.driveMotorL1.setSmartCurrentLimit(30);
    this.driveMotorL2.setSmartCurrentLimit(30);
    this.driveMotorR2.follow(driveMotorR1);
    this.driveMotorL2.follow(driveMotorL1);
    //this.driveMotorL1.follow(driveMotorR1);
    this.driveMotorR1.burnFlash();
    this.driveMotorR2.burnFlash();
    this.driveMotorL1.burnFlash();
    this.driveMotorL2.burnFlash();
    this.driveMotorR1.setInverted(false);
    this.driveMotorR2.setInverted(false);
    this.driveMotorL1.setInverted(true);
    this.driveMotorL2.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void run(double turnSpd, double forwardSpd){
    driveMotorR1.set(forwardSpd);
    driveMotorL1.set(power);
  }

  public void stop(){
    this.driveMotorR1.set(0);
    this.driveMotorR2.set(0);
    this.driveMotorL1.set(0);
    this.driveMotorL2.set(0);
  }
}
