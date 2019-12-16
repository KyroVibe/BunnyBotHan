package frc.robot.control

import frc.robot.Robot
import frc.robot.RobotMap

class SecondaryController: Controller {

  override fun autoInit() { }

  override fun autoPeriodic() { }

  override fun teleopInit() { }

  override fun teleopPeriodic() {
    when (Robot.m_currentTeleopState) {
      TeleopState.ManualControlState -> {

        // Intake Control

        var intakeSpeed: Double = 0.0

        if (getButton(RobotMap.Ports.buttonLeftBumper)) {
          intakeSpeed += RobotMap.Preferences.intakeInSpeed
        }
        if (getButton(RobotMap.Ports.buttonRightBumper)) {
          intakeSpeed += RobotMap.Preferences.intakeOutSpeed
        }

        Robot.m_intake

        // Arm Control

        var usedSetpoint: Boolean = false

        if (getButtonPressed(RobotMap.Ports.buttonA)) {

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