package com.android.academy;

import java.util.ArrayList;

public class Solver {
    public static ArrayList<DroneInstruction> solve(ProblemInstance instance) {
        ArrayList<DroneInstruction> instuctions = new ArrayList<>();

        ArrayList<SorterTask> sorterTasks = new ArrayList<>();

        


        ArrayList<DeliveryTask> DeliveryTasks = new ArrayList<>();

        ArrayList<Drone> drones = new ArrayList<>();

        for (int i = 0; i < instance.numberOfDrowns; i++){
            Drone drone = new Drone();
            drone.currentRow = instance.warehouses[0].row;
            drone.currentCol = instance.warehouses[0].col;
            drones.add(drone);
        }









        return instuctions;
    }
}
