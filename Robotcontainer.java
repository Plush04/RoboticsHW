package frc.robot;

import frc.robot.subsystems.ArcadeDriveSubsystem;
import frc.robot.commands.AutonomousCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
    
    private final ArcadeDriveSubsystem arcadeDriveSubsystem;
    private final Joystick joystick;
    private final Command autonomousCommand;

    public RobotContainer() {
        joystick = new Joystick(0);  // Initialize joystick on port 0
        arcadeDriveSubsystem = new ArcadeDriveSubsystem(joystick);

        autonomousCommand = new AutonomousCommand(arcadeDriveSubsystem); // Initialize autonomous command

        configureButtonBindings();
    }


    public Command getAutonomousCommand() {
        return autonomousCommand;
    }
}
