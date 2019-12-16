package frc.robot.subsystems

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.robot.RobotMap

class Grabber: Subsys {

  val m_piston: DoubleSolenoid = DoubleSolenoid(RobotMap.Ports.grabberPistonA, RobotMap.Ports.grabberPistonB)

  fun set(grab: Boolean) {
    if (grab) m_piston.set(DoubleSolenoid.Value.kForward)
    else m_piston.set(DoubleSolenoid.Value.kReverse)
  }

  fun get(): Boolean {
    return m_piston.get() == DoubleSolenoid.Value.kForward
  }

  override fun updateSmartDashboard() {
    SmartDashboard.putBoolean("Is Grabbing", m_piston.get() == DoubleSolenoid.Value.kForward)
  }

}