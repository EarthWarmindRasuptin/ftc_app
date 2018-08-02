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
    private static final double Grab  = 1;
    private static final double Release = 0;
    //______trig_const_____\\
    private float LT = 1;


    @Override
    public void runOpMode() throws InterruptedException
    {
        //_____Int_Motors_____\\
        DML = hardwareMap.dcMotor.get("LeftMotor");
        DMR = hardwareMap.dcMotor.get("RightMotor");
        //_____Int_Servos_____\\
        CL = hardwareMap.servo.get("ClawLeftServo");
        CR = hardwareMap.servo.get("ClawRightServo");
        //_____Servo_Dflt_____\\
        CL.setPosition(Release);
        CR.setPosition(Release);
        //_____Left_Flip______\\
        DML.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        while (opModeIsActive())
        {
            /*_____________Driving_________________*/
            //Forward_And_Back\\
            DML.setPower(-gamepad1.left_stick_y);
            DMR.setPower(-gamepad1.right_stick_y);


            //_Left_And_Right__\\

            if(gamepad1.left_stick_x < 0)//Right
            {
                DML.setPower(-gamepad1.left_stick_x);
                DMR.setPower(gamepad1.left_stick_x);
            }
            if(gamepad1.left_stick_x > 0)//Left
            {
                DML.setPower(gamepad1.left_stick_x);
                DMR.setPower(-gamepad1.left_stick_x);
            }
            /*____________________________________*/


            if(gamepad1.left_trigger)
            {
                CL.setPosition(Grab);
                CR.setPosition(Grab);
            }
            if(gamepad1.left_trigger)
            {
                CL.setPosition(Release);
                CR.setPosition(Release);
            }

            idle();

        }





    }

















}


