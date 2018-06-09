package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by O&O on 25-5-2018.
 */

@TeleOp(name = "DriveOnly", group = "Controlled")
//@Disabled

public class DriveOnly extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    // Declare drive motors
    private DcMotor motorLeft = null;
    private DcMotor motorRight = null;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize drive motors
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");

        // If drive motors are given full power, robot would spin because of the motors being in
        // opposite directions. So reverse one
        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorRight.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // Repeatedly run code in here until stop button is pressed
        while(opModeIsActive()) {
            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

             leftPower  = -gamepad1.left_stick_y ;
             rightPower = -gamepad1.right_stick_y ;

            // Send calculated power to wheels
            motorLeft.setPower(leftPower);
            motorRight.setPower(rightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();

            // Give hardware a chance to catch up
//            idle();
        }
    }
}