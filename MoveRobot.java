package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeDriveSubsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro; // Assuming we're using a gyro for the turn

public class MoveRobot extends CommandBase {

    private final ArcadeDriveSubsystem arcadeDriveSubsystem;
    private final Gyro gyro;  
    private long startTime;
    private boolean hasMovedForward;

    public AutonomousCommand(ArcadeDriveSubsystem arcadeDriveSubsystem, Gyro gyro) {
        this.arcadeDriveSubsystem = arcadeDriveSubsystem;
        this.gyro = gyro;  
        addRequirements(arcadeDriveSubsystem);
    }

    
    public void initialize() {
        startTime = System.currentTimeMillis();  // Get the start time when the command begins
        hasMovedForward = false;  
        
    }

    @Override
    public void execute() {
        long elapsedTime = System.currentTimeMillis() - startTime;  
        // Move forward for 15 seconds
        if (!hasMovedForward && elapsedTime < 15000) {
            // assumes arcadedrive inputs the x and y pos of the joystick instead of the joystick itself
            arcadeDriveSubsystem.arcadeDrive(0.5, 0);  
        }
        // Turn 180 degrees after moving forward for 15 seconds
        else if (elapsedTime >= 15000 && Math.abs(gyro.getAngle()) < 180) {
            arcadeDriveSubsystem.arcadeDrive(0, 0.5);  
            hasMovedForward = true;  // Indicate that the robot has moved forward
        }
        // Stop after the robot has turned 180 degrees
        else {
            arcadeDriveSubsystem.arcadeDrive(0, 0);  // Stop the robot
        }
    }
}
