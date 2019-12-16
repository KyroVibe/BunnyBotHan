package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem

import frc.robot.RobotMap

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.SensorCollection
import com.ctre.phoenix.motorcontrol.FeedbackDevice

class Arm: Subsys {

  val m_armMotor: WPI_TalonSRX = WPI_TalonSRX(RobotMap.Ports.armTalon)
  
  var m_sensorCollection: SensorCollection? = null

  init {
    m_armMotor.setNeutralMode(NeutralMode.Brake)
    m_sensorCollection = SensorCollection(m_armMotor)
    m_armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10)
  }

  fun setSpeed(speed: Double) {
    m_armMotor.set(ControlMode.PercentOutput, speed)
  }

  fun setNeurtalMode(brake: Boolean) {
    if (brake) m_armMotor.setNeutralMode(NeutralMode.Brake)
    else m_armMotor.setNeutralMode(NeutralMode.Coast)
  }

  fun getTopLimit(): Boolean {
    return m_sensorCollection?.isFwdLimitSwitchClosed() ?: false
  }

  fun getEncoder(): Int {
    return m_armMotor.getSelectedSensorPosition(0)
  }

  override fun updateSmartDashboard() {

  }

}