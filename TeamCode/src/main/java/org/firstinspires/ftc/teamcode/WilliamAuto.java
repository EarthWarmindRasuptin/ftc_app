package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "WilliamAuto")


public class WilliamAuto extends LinearOpMode
{
    //declare drive motors
    private DcMotor DML;
    private DcMotor DMR;
    //declare drive motor
    private Servo CS;
    private Servo BS;
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

        CS = hardwareMap.servo.get("ClawServo");

        //default pos
        CS.setPosition(release);

        //Bob default
        bob = false;

        //invert one drive motor so the robot moves forward
        DML.setDirection(DcMotor.Direction.REVERSE);

        // Waits for the start button to be pressed

        waitForStart();

        //run this code while in the main op mode

        while (opModeIsActive())
        {

            goFWD(SPEED, 4000);
            Ltrn(SPEED,250);
            goFWD(SPEED,4000);
            Rtrn(SPEED,250);
            goFWD(SPEED,4000);
            hault();

        }







    }

    double SPEED = 1;


    public void goFWD (double power, long time) throws InterruptedException
    {
        DML.setPower(power);
        DMR.setPower(power);
        Thread.sleep(time);
    }
    public void Ltrn (double power, long time) throws InterruptedException
    {
        DML.setPower(-power);
        DMR.setPower(power);
        Thread.sleep(time);

    }
    public void Rtrn (double power, long time) throws InterruptedException
    {
        DML.setPower(power);
        DMR.setPower(-power);
        Thread.sleep(time);

    }
    public void hault () throws InterruptedException
    {
        goFWD( 0,1);

    }

}
