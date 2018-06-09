package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Denni on 9-6-2018.
 */

@TeleOp(name = "ServosOnly", group = "Controlled")
//@Disabled

public class ServosOnly extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private Servo servoLeft = null;
    private Servo servoRight = null;
    boolean open = true;

    @Override
    public void runOpMode() throws InterruptedException {

        servoLeft = hardwareMap.get(Servo.class, "servoLeft");
        servoRight = hardwareMap.get(Servo.class, "servoRight");

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        while (opModeIsActive()){
            if (gamepad1.right_bumper){
                if (open=true){
                    servoLeft.setPosition(0.2);
                    servoRight.setPosition(0.2);
                    open=false;
                } else if(open=false){
                    servoLeft.setPosition(0);
                    servoRight.setPosition(0);
                    open=true;
                }
            }
        }
    }
}