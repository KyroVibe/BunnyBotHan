package frc.robot.control

import edu.wpi.first.wpilibj.Joystick

interface Controller {

  fun autoInit()
  fun autoPeriodic()
  fun teleopInit()
  fun teleopPeriodic()
  
}