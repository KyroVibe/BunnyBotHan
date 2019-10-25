package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem

import frc.robot.RobotMap

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.ControlMode

class Arm: Subsystem() {

  val arm: WPI_TalonSRX = WPI_TalonSRX(RobotMap.Ports.armTalon)

  init {
    arm.setNeutralMode(NeutralMode.Brake)
  }

  fun setSpeed(speed: Double) {
    arm.set(ControlMode.PercentOutput, speed)
  }

  override fun initDefaultCommand() {

  }

}