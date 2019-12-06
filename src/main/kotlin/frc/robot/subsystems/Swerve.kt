package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort

import org.team997coders.spartanlib.swerve.SwerveDrive
import org.team997coders.spartanlib.swerve.module.SwerveModule
import org.team997coders.spartanlib.swerve.module.TorqueModule
import org.team997coders.spartanlib.commands.UpdateModule
import org.team997coders.spartanlib.helpers.SwerveMixerData

import com.kauailabs.navx.frc.AHRS

import frc.robot.RobotMap
import frc.robot.Robot

typealias Ports = RobotMap.Ports
typealias Values = RobotMap.Values

class Swerve : SwerveDrive(Values.wheelBase, Values.trackWidth) {

  var m_gyro: AHRS? = null

  /**
   * 1 | 0
   * -----
   * 2 | 3
   */
  init {

    modules.drop(modules.size)

    modules.plus(TorqueModule(0, Ports.azimuthIDs[0], Ports.driveIDs[0], Ports.encoderIDs[0],
      Values.encoderZeros[0], Values.moduleAzimuthConstants[0], Values.moduleDriveConstants[0]))

    modules.plus(TorqueModule(1, Ports.azimuthIDs[1], Ports.driveIDs[1], Ports.encoderIDs[1],
      Values.encoderZeros[1], Values.moduleAzimuthConstants[1], Values.moduleDriveConstants[1]))

    modules.plus(TorqueModule(2, Ports.azimuthIDs[2], Ports.driveIDs[2], Ports.encoderIDs[2],
      Values.encoderZeros[2], Values.moduleAzimuthConstants[2], Values.moduleDriveConstants[2]))

    modules.plus(TorqueModule(3, Ports.azimuthIDs[3], Ports.driveIDs[3], Ports.encoderIDs[3],
      Values.encoderZeros[3], Values.moduleAzimuthConstants[3], Values.moduleDriveConstants[3]))

    modules[1].invertDrive(true, true)

    for (i in modules.indices) {
      modules[i].setDriveBrakeMode(true)
      Robot.m_runner.AddAction(UpdateModule(modules[i], this))
    }

    try {
      m_gyro = AHRS(SerialPort.Port.kUSB)
    } catch (e: Exception) {
      System.out.println("Well uwu, it seems that you forgot to plug in the fucking Navx")
    }

    m_gyro?.reset()
      
  }

  fun setSwerveMixer(f: Double, s: Double, r: Double, fieldOrientated: Boolean) {

    var dat: SwerveMixerData?

    if (fieldOrientated) {
      dat = this.getSwerveData(f, s, r, getAngle())
    } else {
      dat = this.getSwerveData(f, s, r)
    }

    setSwerveInput(dat)
  }

  fun resetGyro() {
    m_gyro?.reset()
  }

  fun getAngle(): Double {
    var theta: Float = m_gyro?.getYaw() ?: 0f
    while (theta < 0) {
      theta += 360
    }
    while (theta >= 360) {
      theta -= 360
    }
    return theta.toDouble()
  }

  override fun initDefaultCommand() { }

}