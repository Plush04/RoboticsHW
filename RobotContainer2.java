package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.OpenClawCommand;
import frc.robot.commands.CloseClawCommand;
import frc.robot.subsystems.ClawSubsystem;

public class RobotContainer2 {

    private final ClawSubsystem clawSubsystem;
    private final Joystick joystick;

    public RobotContainer() {
        clawSubsystem = new ClawSubsystem();
        joystick = new Joystick(0);  

        configureButtonBindings();  
    }

    private void configureButtonBindings() {
        
        new JoystickButton(joystick, 1).whenPressed(new OpenClawCommand(clawSubsystem));

        
        new JoystickButton(joystick, 2).whenPressed(new CloseClawCommand(clawSubsystem));
    }

    public ClawSubsystem getClawSubsystem() {
        return clawSubsystem;
    }
}
