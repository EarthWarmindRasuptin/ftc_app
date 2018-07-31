package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "ThomasT")

public class thomasTele extends LinearOpMode
{
    //declare drive motors
    private DcMotor lmotor;
    private DcMotor rmotor;

@Override
    public void runOpMode () throws InterruptedException
    {
        //Init Drive
        lmotor = hardwareMap.dcMotor.get("LeftMotor");
        rmotor = hardwareMap.dcMotor.get("RightMotor");


        //waits for the start button to be pressed
        waitForStart();

        //run this code while in the main OpMode
        while (opModeIsActive())
        {
            //Tank drive
            lmotor.setPower(-gamepad1.left_stick_y);
            rmotor.setPower(-gamepad1.right_stick_y);

//give hardware a chance to catch up
            idle();
        }

    }
}
