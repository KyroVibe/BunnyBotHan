/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
    
package frc.robot

import org.team997coders.spartanlib.helpers.PIDConstants

import frc.robot.control.TeleopState;
    
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
object RobotMap {

  object Ports {

    val gamepad1: Int = 0
    val gamepad2: Int = 1

    val leftXAxis: Int = 0
    val leftYAxis: Int = 1
    val rightXAxis: Int = 4
    val rightYAxis: Int = 5

    val rightTrigger: Int = 3
    val leftTrigger: Int = 2

    val buttonA: Int = 1
    val buttonB: Int = 2
    val buttonX: Int = 3
    val buttonY: Int = 4

    val armTalon: Int = 9
    val bunnyVictor: Int = 10

    /**
     * 1 | 0
     * -----
     * 2 | 3
     */
    val azimuthIDs: Array<Int> = arrayOf(1, 3, 5, 7)
    val driveIDs: Array<Int> = arrayOf(2, 4, 6, 8)
    val encoderIDs: Array<Int> = arrayOf(0, 1, 2, 3)

  }

  object Values {

    val wheelBase: Double = 1.0
    val trackWidth: Double = 1.0

    /**
     * 1 | 0
     * -----
     * 2 | 3
     */
    val encoderZeros: Array<Double> = arrayOf(0.0, 0.0, 0.0, 0.0)
    val moduleAzimuthConstants: Array<PIDConstants> = arrayOf(
      PIDConstants(0.0, 0.0, 0.0),
      PIDConstants(0.0, 0.0, 0.0),
      PIDConstants(0.0, 0.0, 0.0),
      PIDConstants(0.0, 0.0, 0.0)
    )
    val moduleDriveConstants: Array<PIDConstants> = arrayOf(
      PIDConstants(0.0, 0.0, 0.0),
      PIDConstants(0.0, 0.0, 0.0),
      PIDConstants(0.0, 0.0, 0.0),
      PIDConstants(0.0, 0.0, 0.0)
    )

  }

  object Preferences {

    val teleopState: TeleopState = TeleopState.AssistedControlState

    val intakeInSpeed: Double = 0.75
    val intakeOutSpeed: Double = 0.9

    val driveTranslationModifier: Double = 0.8
    val driveRotationModifier: Double = 1.0

  }

}
