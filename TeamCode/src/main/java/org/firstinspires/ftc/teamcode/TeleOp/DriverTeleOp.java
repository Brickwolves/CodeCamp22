package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.Controls.JoystickControls.Input.LEFT;
import static org.firstinspires.ftc.teamcode.Controls.JoystickControls.Input.RIGHT;
import static org.firstinspires.ftc.teamcode.Controls.JoystickControls.Value.INVERT_X;
import static org.firstinspires.ftc.teamcode.Controls.JoystickControls.Value.X;
import static org.firstinspires.ftc.teamcode.Controls.JoystickControls.Value.Y;
import static org.firstinspires.ftc.teamcode.Utilities.OpModeUtils.multTelemetry;
import static org.firstinspires.ftc.teamcode.Utilities.OpModeUtils.setOpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Controls.Controller;
import org.firstinspires.ftc.teamcode.DashConstants.Unfixed;
import org.firstinspires.ftc.teamcode.Hardware.RobotKart;

@TeleOp(name="Driver TeleOp", group="Iterative Opmode")
public class DriverTeleOp extends OpMode {

    // Declare OpMode members.
    private ElapsedTime time = new ElapsedTime();
    public RobotKart robot;
    Controller controller;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        setOpMode(this);

        robot = new RobotKart();
        controller = new Controller(gamepad1);

        multTelemetry.addData("Status", "Initialized");
        multTelemetry.update();
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

    /*
                Y O U R   C O D E   H E R E
                                               */


        multTelemetry.addData("Status", "InitLoop");
        multTelemetry.update();
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {




    /*
                Y O U R   C O D E   H E R E
                                               */

        multTelemetry.addData("Status", "Started");
        multTelemetry.update();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        Controller.update();


        double power = .7;
        double drive = controller.get(LEFT, Y);
        double strafe = controller.get(LEFT, INVERT_X);
        double turn = controller.get(RIGHT, X);


        robot.drivetrain.setDrivePower(power, strafe, turn, drive);


    /*
         ----------- L O G G I N G -----------
                                            */
        multTelemetry.addData("Status", "TeleOp Running");
        multTelemetry.addData("Red", robot.color_sensor.getRedCacheValue());
        multTelemetry.addData("Blue", robot.color_sensor.getBlueCacheValue());
        multTelemetry.addData("Green", robot.color_sensor.getGreenCacheValue());
        multTelemetry.update();
    }

    @Override
    public void stop() {

    /*
                Y O U R   C O D E   H E R E
                                               */

    }
}
