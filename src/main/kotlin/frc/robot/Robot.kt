/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj.Joystick

import frc.robot.subsystems.*

import frc.robot.control.*

import org.team997coders.spartanlib.helpers.threading.SpartanRunner

class Robot: TimedRobot() {

  companion object {
    val m_runner = SpartanRunner(20)

    val m_gamepad1: Joystick = Joystick(RobotMap.Ports.gamepad1)
    val m_gamepad2: Joystick = Joystick(RobotMap.Ports.gamepad2)
    val m_swerve: Swerve = Swerve()
    val m_arm: Arm = Arm()
    val m_intake: Intake = Intake()

    val m_controllers: Array<Controller> = arrayOf(PrimaryController(), SecondaryController())

    val m_currentTeleopState: TeleopState = TeleopState.DormentState
  }

  var m_chooser: SendableChooser<String> = SendableChooser()

  override fun robotInit() {
    m_chooser.setDefaultOption("Default Auto", "DEFAULT")
    // m_chooser.addOption("My Auto", MyAutoCommand())
    SmartDashboard.putData("Auto mode", m_chooser)
  }

  override fun robotPeriodic() {
    m_swerve.updateSmartDashboard()
    m_arm.updateSmartDashboard()
    m_intake.updateSmartDashboard()
  }

  override fun disabledInit() { }

  override fun disabledPeriodic () { }
  
  override fun autonomousInit() {
    m_controllers.forEach { it.autoInit() }
  }

  override fun autonomousPeriodic() {
    m_controllers.forEach { it.autoPeriodic() }
  }

  override fun teleopInit() {
    m_controllers.forEach { it.teleopInit() }
  }

  override fun teleopPeriodic() {
    m_controllers.forEach { it.teleopPeriodic() }
  }

}
