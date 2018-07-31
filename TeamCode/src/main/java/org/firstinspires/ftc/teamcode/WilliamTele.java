package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "WilliamT")


public class WilliamTele extends LinearOpMode
{
    //declare drive motors
    private DcMotor DML;
    private DcMotor DMR;
    //declare drive motor
    private Servo CL;
    private Servo CR;
    //Servo constants
    private static final double grab = 1;
    private static final double release = 0;
    //variable
    private boolean bob;


    @Override
    @Disabled
    public void runOpMode() throws InterruptedException
    {
        //Init Drive

        DML = hardwareMap.dcMotor.get("LeftMotor");
        DMR = hardwareMap.dcMotor.get("RightMotor");

        //Init Claw

        CL = hardwareMap.servo.get("ClawServo");

        //default pos
        CL.setPosition(release);

        //Bob default
        bob = false;

        //invert one drive motor so the robot moves forward
        DML.setDirection(DcMotor.Direction.REVERSE);

        // Waits for the start button to be pressed

        waitForStart();

        //run this code while in the main op mode

        while (opModeIsActive())
        {
            //TankDrive

            DML.setPower(-gamepad1.left_stick_y);
            DMR.setPower(-gamepad1.right_stick_y);

            if(gamepad1.y)
            {
               CS.setPosition(grab);
            }
            if(!gamepad1.y)
            {
                CS.setPosition(release);
            }
            if(gamepad1.a & gamepad1.left_bumper & gamepad1.right_bumper)
            {
                bob = true;
            }
            // give hardware a chance to catch up;

            idle();

        }






    }


}
