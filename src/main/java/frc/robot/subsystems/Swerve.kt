package frc.robot.subsystems;

import org.team997coders.spartanlib.swerve.SwerveDrive
import org.team997coders.spartanlib.swerve.module.SwerveModule
import org.team997coders.spartanlib.swerve.module.TorqueModule
import frc.robot.RobotMap

class Swerve : SwerveDrive(1.0, 1.0) {

  /**
   * 1 | 0
   * -----
   * 2 | 3
   */
  init {

    modules.plus(TorqueModule(0, RobotMap.Ports.azimuthIDs[0], RobotMap.Ports.driveIDs[0], RobotMap.Ports.encoderIDs[0],
      RobotMap.Values.encoderZeros[0], RobotMap.Values.modulePs[0], RobotMap.Values.moduleIs[0], RobotMap.Values.moduleDs[0]))

    modules.plus(TorqueModule(1, RobotMap.Ports.azimuthIDs[1], RobotMap.Ports.driveIDs[1], RobotMap.Ports.encoderIDs[1],
      RobotMap.Values.encoderZeros[1], RobotMap.Values.modulePs[1], RobotMap.Values.moduleIs[1], RobotMap.Values.moduleDs[1]))

    modules.plus(TorqueModule(2, RobotMap.Ports.azimuthIDs[2], RobotMap.Ports.driveIDs[2], RobotMap.Ports.encoderIDs[2],
      RobotMap.Values.encoderZeros[2], RobotMap.Values.modulePs[2], RobotMap.Values.moduleIs[2], RobotMap.Values.moduleDs[2]))

    modules.plus(TorqueModule(3, RobotMap.Ports.azimuthIDs[3], RobotMap.Ports.driveIDs[3], RobotMap.Ports.encoderIDs[3],
      RobotMap.Values.encoderZeros[3], RobotMap.Values.modulePs[3], RobotMap.Values.moduleIs[3], RobotMap.Values.moduleDs[3]))

    System.out.println("Module Count: " + modules.size);

  }

  override fun initDefaultCommand() { }

}