package org.firstinspires.ftc.teamcode.Hardware;

import org.firstinspires.ftc.teamcode.Hardware.Sensors.Color_Sensor;
import org.firstinspires.ftc.teamcode.Hardware.Sensors.IMU;

public class RobotKart {

    public Mecanum drivetrain;
    public IMU imu;
    public Color_Sensor color_sensor;

    public RobotKart(){
        drivetrain = new Mecanum();
        imu = new IMU("imu");
        color_sensor = new Color_Sensor();

        color_sensor.init("color");

    }


}
