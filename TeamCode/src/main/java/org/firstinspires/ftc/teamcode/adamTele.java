package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "AdamT")

public class adamTele extends LinearOpMode {

    //declare drive motors
    private DcMotor motorL;
    private DcMotor motorR;

   @Override
   public void runOpMode() throws InterruptedException {
       //Initiate Drive Motors
       motorL = hardwareMap.dcMotor.get("LeftMotor");
       motorR = hardwareMap.dcMotor.get("RightMotor");

       //Wait for start button to be pressed
      waitForStart();

      //Run this code while in the main op mode
      while (opModeIsActive()) {
          //tank drive
          motorL.setPower(-gamepad1.left_stick_y);
          motorR.setPower(-gamepad1.right_stick_y);

          //Giving hardware chance to catch up
        idle();

      }

   }

}
