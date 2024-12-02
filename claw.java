package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {

    private final DoubleSolenoid clawSolenoid;

    public ClawSubsystem() {
        // Initialize the DoubleSolenoid with the ports from Constants
        clawSolenoid = new DoubleSolenoid(Constants.clawSolenoidForwardPort, Constants.clawSolenoidReversePort);
    }

    // Method to open the claw (extend the solenoid)
    public void openClaw() {
        clawSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    // Method to close the claw (retract the solenoid)
    public void closeClaw() {
        clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    public void periodic() {
        // This method runs once per scheduler cycle (used for periodic updates if needed)
    }
}
