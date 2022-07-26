package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Utilities.MathUtils.closestAngle;
import static org.firstinspires.ftc.teamcode.Utilities.OpModeUtils.multTelemetry;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Utilities.PID;

public class Mecanum {

    PID rotationalPID = new PID();

    /**
     * Initializes the robot's necessary subsystems and motors
     */
    public void initMecanum(){

    }

    /**
     * Sets the same power to all four motors
     * @param power
     */
    public void setAllPower(double power){
        /*

                Y O U R   C O D E   H E R E

         */
    }

    /**
     * Sets the power to the motors for driving with a mecanum drivetrain
     * @param power
     */
    public void setDrivePower(double drive, double strafe, double turn, double power){
        /*

                Y O U R   C O D E   H E R E

         */
    }

    /**
     * Resets the motor encoders back to 0
     */
    public void resetMotors(){
    }

    /**
     *
     * @return average of all motor's getCurrentPosition() but each one is absolute valued
     */
    public double getPosition(){
        return 0.0;
    }


    /**
     * Translates the robot autonomously a certain distance known as ticks
     * @param ticks
     */
    public void strafe(double ticks){

        /** TODO: Making a strafe() method. Goal: strafe forwards and backwards
         *  1)  Write a resetMotors() method that takes in no parameters, has no return-type,
         *      and simply calls the setMode() method of each motor with the parameter
         *      STOP_AND_RESET_ENCODERS
         *  2)  Write a getPosition() method that averages the return-value for each motor's
         *      getCurrentPosition() call.
         *  3)  At the top of the strafe() method use our resetMotors() method to reset the motor
         *      encoders to 0
         *  4)  Make a local variable of type double to store our current distance as we strafe.
         *      Let's name it current_distance and set to 0.0 to start out
         *  5)  Make a local variable of type double to store the power we supply to the motors.
         *      For now let's set the power to 0.5. Since we want the ability to travel forwards
         *      AND backwards, we might have a situation in which the number of ticks is negative.
         *      Write logic so that if the ticks are negative, we negate the power to also be
         *      negative.
         *  6)  Now we want to supply power to our robot to move until we've reached our target
         *      distance, ticks. Write a while-loop that will loop ONLY while the current distance,
         *      current_distance, is less than the target distance, ticks. Specifically, since
         *      ticks can be negative, you'll need to check the absolute value of each of these
         *      components otherwise you'll get some weird strafing! In our while-loop we'll be
         *      updating our current position at the start of every loop, and then setting the power
         *      to our motors accordingly. If you'd like it's VERY helpful to log out the current
         *      distance traveled and the actual distance we're traveling to using the multTelemetry
         *      A)  Update current_distance with a call to getPosition()
         *      B)  Use the setAllPower() method to set the power to all motors using the local
         *          power variable you made above the while-loop
         *      C)  Log out the current distance and the distance to travel using multTelemetry's
         *          addData() and update() method
         *          NOTE:   You use the addData() method to add all of your information first,
         *                  and then you call the update() method once after those lines of code
         *                  to actually send that data to the phone
         *  7)  After we finish strafing, use the setAllPower() method to stop every motor from
         *      moving. (So we're supplying a power of 0.0)
         */


        // Reset our encoders to 0
        resetMotors();

        double current_distance = 0;

        // Power is defaulted to 0.5, however if ticks are negative, we need to travel backwards
        double power = 0.5;
        if (ticks < 0) power *= -1;

        while (current_distance < ticks){
            current_distance = getPosition();

            setAllPower(power);

            // Log some data out for debugging
            multTelemetry.addData("Position", current_distance);
            multTelemetry.addData("Distance", ticks);
            multTelemetry.update();
        }
        setAllPower(0);
    }

    /**
     * Rotates the robot autonomously a certain number of degrees
     * @param degrees
     * @param current_angle
     */
    public void turn(double degrees, double current_angle){

        /** TODO: Making a turn() method
         * 1)   Make a PID attribute in the Mecanum class named rotationalPID
         * 2)   Instantiate it in the initMecanum() method
         * 3)   Declare and instatiate a new ElapsedTime at top of turn() method
         * 4)   Use closestAngle() method w/ degrees & current_angle as parameters to calculate
         *      the actual angle we should be going to
         * 5)   Make a while-loop lasting 1 second (up to you how long)
         *      A)  Inside the while-loop update the rotationalPID with the difference between
         *          the degrees and the current_angle.
         *      B)  Supply the resulting PID return-value to the setDrivePower() method where
         *          all parameters are 0.0, EXCEPT for the turn and power parameters. The turn
         *          parameter should be set to the PID return-value and the power should be set to
         *          1.0.
         *      C)  Log out the current angle and your target angle using the multTelemetry's
         *          addData() and update() method!
         * 6)   After the while-loop use setAllPower() method to set all motors to a power of 0.0
         */

        ElapsedTime timer = new ElapsedTime();
        timer.reset();

        degrees = closestAngle(degrees, current_angle);

        while (timer.seconds() < 1){
            // double turn = rotationalPID.update(degrees - current_angle);

            setDrivePower(0, 0, 0.3, 1.0);
        }
        setAllPower(0);
    }


    /**
     * A mathematical function that optimizes the ramping of power to the motors during autonomous
     * strafes.
     * @param position
     * @param distance
     * @param acceleration
     * @return the coefficient [0, 1] of our power
     */
    public static double powerRamp(double position, double distance, double acceleration){
        /*

                Y O U R   C O D E   H E R E

         */
        return 0;
    }
}
