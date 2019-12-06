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

import frc.robot.subsystems.Swerve
import frc.robot.subsystems.Arm

import frc.robot.control.TeleopState

import org.team997coders.spartanlib.helpers.threading.SpartanRunner

class Robot: TimedRobot() {

  companion object {
    val m_runner = SpartanRunner(20)

    val m_gamepad1: Joystick = Joystick(RobotMap.Ports.gamepad1)
    val m_gamepad2: Joystick = Joystick(RobotMap.Ports.gamepad2)
    val m_swerve: Swerve = Swerve()
    val m_arm: Arm = Arm()

    val m_currentTeleopState: TeleopState = TeleopState.DormentState;
  }

  var m_chooser: SendableChooser<String> = SendableChooser()

  override fun robotInit() {
    m_chooser.setDefaultOption("Default Auto", "DEFAULT")
    // m_chooser.addOption("My Auto", MyAutoCommand())
    SmartDashboard.putData("Auto mode", m_chooser)
  }

  override fun robotPeriodic() { }

  override fun disabledInit() { }

  override fun disabledPeriodic () { }
  
  override fun autonomousInit() { }

  override fun autonomousPeriodic() { }

  override fun teleopInit() { }

  override fun teleopPeriodic() {
    when (m_currentTeleopState) {
      TeleopState.ManualControlState -> {
        // Primary:
        
      }
      TeleopState.AssistedControlState -> {
        // TODO: Secondary's controls are setpoint controlled and Primary has some basic drive corrections
      }
      TeleopState.AIControlState -> {
        // TODO: Basically Autonomous
      }
      else -> System.out.println("The current state is " + m_currentTeleopState.name)
    }
  }

  override fun testPeriodic() { }
}
