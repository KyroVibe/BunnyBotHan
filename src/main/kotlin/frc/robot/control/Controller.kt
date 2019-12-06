package frc.robot.control

import edu.wpi.first.wpilibj.Joystick

interface Controller {

  fun autoInit()
  fun autoPeriodic()
  fun teleopInit()
  fun teleopPeriodic()

  fun onButtonPressed(gamepad: Joystick, button: Int, exec: Runnable) {
    if (gamepad.getRawButtonPressed(button)) exec.run()
  }

  fun onButtonHeld(gamepad: Joystick, button: Int, exec: Runnable) {
    if (gamepad.getRawButton(button)) exec.run()
  }
  
}