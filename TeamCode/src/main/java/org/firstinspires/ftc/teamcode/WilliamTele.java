package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "WilliamT")


public class WilliamTele extends LinearOpMode
{
    //declare drive motors
    private DcMotor DML;
    private DcMotor DMR;

    @Override
    public void runOpMode() throws InterruptedException
    {
        //Init Drive

        DML = hardwareMap.dcMotor.get("LeftMotor");
        DMR = hardwareMap.dcMotor.get(("RightMotor");


        // Waits for the start button to be pressed
        waitForStart();

        //run this code while in the main op mode
        while (opModeIsActive())
        {
            //tankdrive
            DML.setPower(-gamepad1.left_stick_y);
            DMR.setPower(-gamepad1.right_stick_y);





            // give hardware a chance to catch up;
            idle();

        }






    }


}
