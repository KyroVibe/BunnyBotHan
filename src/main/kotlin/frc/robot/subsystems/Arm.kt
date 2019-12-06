package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem

import frc.robot.RobotMap

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.ControlMode

class Arm {

  val m_armMotor: WPI_TalonSRX = WPI_TalonSRX(RobotMap.Ports.armTalon)

  init {
    m_armMotor.setNeutralMode(NeutralMode.Brake)
  }

  fun setSpeed(speed: Double) {
    m_armMotor.set(ControlMode.PercentOutput, speed)
  }

  fun setNeurtalMode(brake: Boolean) {
    if (brake) m_armMotor.setNeutralMode(NeutralMode.Brake)
    else m_armMotor.setNeutralMode(NeutralMode.Coast)
  }

}