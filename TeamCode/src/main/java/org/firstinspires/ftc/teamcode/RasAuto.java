package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Rasputin")



public class RasputinTeleCom extends LinearOpMode
{
    //_declare_drive_motors_\\
    private DcMotor DML;
    private DcMotor DMR;
    //_declare_drive_motor_\\
    private Servo CL;
    private Servo CR;
    //_____servo_const_____\\
    private static final double LGrab  = -1;
    private static final double RGrab  = 1;
    private static final double RRelease = 1;
    private static final double LRelease = 0;
    private static final double LStore = 0;
    private static final double RStore = -1;

    //______trig_const_____\\
    private boolean LT = true;
    private boolean RT = true;
    //_Declare_Pull_motors_\\
    private DcMotor PM;


    @Override
    public void runOpMode() throws InterruptedException
    {
        //_____Int_Motors_____\\
        DML = hardwareMap.dcMotor.get("LeftMotor");
        DMR = hardwareMap.dcMotor.get("RightMotor");
        PM = hardwareMap.dcMotor.get("PullMotor");
        //_____Int_Servos_____\\
        CL = hardwareMap.servo.get("ClawLeftServo");
        CR = hardwareMap.servo.get("ClawRightServo");
        //_____Servo_Dflt_____\\
        CL.setPosition(LRelease);
        CR.setPosition(RRelease);
        //_____Left_Flip______\\
        DML.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        while (opModeIsActive())
        {
            /*_____________Driving_________________*/
            //Forward_And_Back\\
            DML.setPower(-gamepad1.left_stick_y);
            DMR.setPower(-gamepad1.left_stick_y);
            PM.setPower(gamepad1.right_stick_x);


            //_Left_And_Right__\\

            if(gamepad1.left_stick_x <= 0)//Right
            {
                DML.setPower(gamepad1.left_stick_x);
                DMR.setPower(-gamepad1.left_stick_x);
            }
            if(gamepad1.left_stick_x >= 0)//Left
            {
                DML.setPower(gamepad1.left_stick_x);
                DMR.setPower(-gamepad1.left_stick_x);
            }
            /*____________________________________*/


            if(gamepad1.left_trigger==1)
            {
                CL.setPosition(LGrab);
                CR.setPosition(RGrab);
            }
            if(gamepad1.right_trigger==1)
            {
                CL.setPosition(LRelease);
                CR.setPosition(RRelease);
            }




            idle();

        }





    }

















}


