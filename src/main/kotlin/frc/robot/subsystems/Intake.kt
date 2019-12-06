package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.ControlMode

import frc.robot.RobotMap

class Intake {

  val m_intakeMotor: WPI_VictorSPX = WPI_VictorSPX(RobotMap.Ports.bunnyVictor)

  init {
    m_intakeMotor.setNeutralMode(NeutralMode.Brake)
  }

  fun setSpeed(speed: Double) {
    m_intakeMotor.set(ControlMode.PercentOutput, speed)
  }

}