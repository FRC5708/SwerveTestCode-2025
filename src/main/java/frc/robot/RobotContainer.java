package frc.robot;

// import frc.robot.commands.autonCommands.goToL1_from_L4;
// import frc.robot.commands.autonCommands.goToPoint;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import java.io.IOException;

import frc.robot.Constants.Operator;

public class RobotContainer {
  CommandXboxController m_driverController = new CommandXboxController(Operator.kDriverControllerPort);
  DriveSubsystem m_drive;
  // SensorSubsystem m_sensor;
  SendableChooser<Command> autoChooser;

  public RobotContainer() throws IOException {
    m_drive = new DriveSubsystem();
  
    m_drive.setDefaultCommand(
        m_drive.driveCommand(m_driverController::getLeftX, m_driverController::getLeftY,
            m_driverController::getRightX));
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

  public DriveSubsystem getDriveSubsystem() {
    return m_drive;
  }
}
