package com.swervedrivespecialties.exampleswerve.commands;

import com.swervedrivespecialties.exampleswerve.Robot;
import com.swervedrivespecialties.exampleswerve.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.frcteam2910.common.math.Vector2;

public class DriveCommand extends Command {

    public DriveCommand() {
        requires(DrivetrainSubsystem.getInstance());
    }

    @Override
    protected void execute() {
        double forward = -Robot.getOi().getPrimaryJoystick().getRawAxis(1);
        // Square the forward stick to apply a better motion curve
        forward = Math.copySign(Math.pow(forward, 2.0), forward);

        double strafe = -Robot.getOi().getPrimaryJoystick().getRawAxis(0);
        // Square the forward stick to apply a better motion curve
        strafe = Math.copySign(Math.pow(strafe, 2.0), strafe);

        double rotation = -Robot.getOi().getPrimaryJoystick().getRawAxis(4);
        // Square the forward stick to apply a better motion curve
        rotation = Math.copySign(Math.pow(rotation, 2.0), rotation);

        // Pass translational velocity as vector and rotational velocity. Field-oriented
        DrivetrainSubsystem.getInstance().holonomicDrive(new Vector2(forward, strafe), rotation, true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
