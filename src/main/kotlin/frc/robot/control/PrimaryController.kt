package frc.robot.control

import frc.robot.Robot
import frc.robot.RobotMap

typealias Prefs = RobotMap.Preferences

class PrimaryController: Controller {

  companion object {
    var isFieldOrientated: Boolean = true
  }

  override fun autoInit() { }

  override fun autoPeriodic() { }

  override fun teleopInit() { }

  override fun teleopPeriodic() {
    when (Robot.m_currentTeleopState) {
      TeleopState.ManualControlState, TeleopState.AssistedControlState -> {

        var f: Double = -Robot.m_gamepad1.getRawAxis(RobotMap.Ports.leftYAxis) * Prefs.driveTranslationModifier
        var s: Double = Robot.m_gamepad1.getRawAxis(RobotMap.Ports.leftXAxis) * Prefs.driveTranslationModifier
        var r: Double = Robot.m_gamepad1.getRawAxis(RobotMap.Ports.rightXAxis) * Prefs.driveRotationModifier

        Robot.m_swerve.setSwerveMixer(f, s, r, isFieldOrientated)

        if (getButtonPressed(RobotMap.Ports.buttonY)) {
          Robot.m_swerve.resetGyro()
        }
      }
      else -> System.out.println("Current State: '" + Robot.m_currentTeleopState.name + "'")
    }
  }

  fun getButtonPressed(button: Int): Boolean {
    return Robot.m_gamepad1.getRawButtonPressed(button)
  }

  fun getButton(button: Int): Boolean {
    return Robot.m_gamepad1.getRawButton(button)
  }

  fun getButtonReleased(button: Int): Boolean {
    return Robot.m_gamepad1.getRawButtonReleased(button)
  }

}