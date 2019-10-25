/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import frc.robot.RobotMap

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
class OI {

  val gamepad1: Joystick = Joystick(RobotMap.Ports.gamepad1)
  val gamepad2: Joystick = Joystick(RobotMap.Ports.gamepad2)

  init {

  }

  fun getAxisDriver1(port: Int): Double {
    return gamepad1.getRawAxis(port)
  }

  fun getAxisDriver2(port: Int): Double {
    return gamepad2.getRawAxis(port)
  }

}
