package com;
import com.intrefaces.MotorVehicle;
import com.intrefaces.MotorCycle;

import java.sql.Driver;

class Drive implements MotorVehicle, MotorCycle {

    @Override
    public void drive() {
        System.out.println("I am driving");
    }

    @Override
    public int speed(int x) {
        return x;
    }

    @Override
    public int numberOfWheels(int y) {
        return y;
    }

    @Override
    public void hasShield() {
        System.out.println("My Motor vehicle has Wind Shield");
    }

}

class DemoDrive {

    public static void main(String[] args) {
        Drive d=new Drive();
        d.drive();
        System.out.println("I am driving Motor Vehicle with" +d.speed(200) +"Km/h");
        System.out.println("I am driving cycle with" +d.speed(80) +"Km/h");
        System.out.println("Motter Vehicle has"+d.numberOfWheels(4)+"Wheels");
        System.out.println("Cycle has"+d.numberOfWheels(2)+"Wheels");
        d.hasShield();
    }
}
