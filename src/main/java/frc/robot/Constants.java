/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int kFrontLeftWheelPort = 10;
        public static final int kFrontRightWheelPort = 11;
        public static final int kBackLeftWheelPort = 8;
        public static final int kBackRightWheelPort = 1;
    }
    
    public static final class IntakeConstants {
        public static final int kIntakePort = 7;
        public static final double kIntakeSpeed = -0.8;
    }

    public static final class ShooterConstants {
        public static final int kShooter1Port = 5;
        public static final int kShooter2Port = 6;
        public static final int kIndexPort = 9;

        public static final double kIndexClosedPosition = .5;
        public static final double kIndexOpenPosition = 0;

        public static final double kIdealShotSpeed = -0.9; //ideal motor speed to run the shooter at
        public static final double kTimeToChargeUp = 4; //time in seconds for the shooter to reach ideal speed
    }

    public static final class LiftConstants {
        public static final int kFrontLeftLiftPort = 0;
        public static final int kFrontRightLiftPort = 2;
        public static final int kBackLeftLiftPort = 9;
        public static final int kBackRightLiftPort = 3;

        public static final int kTopLimitSwitchPort = 8;
        public static final int kBottomLimitSwitchPort = 7;
    }

    public static final class SpinnerConstants {
        public static final int kSpinnerPort = 4;

        public static final double kIdealSpinnerSpeed = 1;
    }

    public static final class JoystickConstants {
        public static final int kXStick1 = 0;
        public static final int kYStick1 = 1;
        public static final int kXStick2 = 4;
        public static final int kYStick2 = 5;

        public static final int kJoysick1Port = 0;
        public static final int kJoystick2Port = 1;
    }

    public static final class LimelightConstants {
        public static final double kIdealStrafeValue = 0.4;
        public static final double kIdealForwardValue = 0.2;
        public static final double kIdealRotateValue = 0.15;

        public static final double kIdealAreaValue = 2.5;
        public static final double kAreaRangeValue = 0.3;

        public static final double kP = 0.005;
    }

    public static final class AutoConstants {
        public static final double kAutoShootPower = -0.9;
        public static final double kAutoChargeUpTime = 2;
        public static final double kAutoShootEndTime = 5;

        
    }
}
