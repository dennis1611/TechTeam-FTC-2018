package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Denni on 9-6-2018.
 */

@TeleOp(name = "LiftOnly", group = "Controlled")
//@Disabled

public class LiftOnly extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    // Declare drive motors
    private DcMotor motorLift = null;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize drive motors
        motorLift = hardwareMap.get(DcMotor.class, "lift");

//        needed???
//        motorLift.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        while(opModeIsActive()){
            if (gamepad1.left_bumper){
                motorLift.setPower(1);
            }
            if (gamepad1.left_trigger > 0.5){
                motorLift.setPower(-1);
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
