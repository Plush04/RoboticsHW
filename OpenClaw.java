package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class OpenClaw extends CommandBase {

    private final ClawSubsystem clawSubsystem;

    public OpenClawCommand(ClawSubsystem clawSubsystem) {
        this.clawSubsystem = clawSubsystem;
        addRequirements(clawSubsystem);
    }

    
    public void initialize() {
        clawSubsystem.openClaw(); // Open the claw
    }

    
    public boolean isFinished() {
        return true; // Command is finished once the claw is opened
    }
}
