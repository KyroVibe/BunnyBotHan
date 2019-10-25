package frc.robot.commands

import frc.robot.Robot
import frc.robot.RobotMap

import edu.wpi.first.wpilibj.command.Command

class MoveArm: Command() {

  init {
    requires(Robot.m_arm)
  }

  override fun execute() {
    var value: Double = Robot.m_oi.getAxisDriver1(RobotMap.Ports.rightTrigger)
    value -= Robot.m_oi.getAxisDriver1(RobotMap.Ports.leftTrigger)

    
  }

  override fun isFinished(): Boolean {
    return false
  }

  override fun end() {

  }

}