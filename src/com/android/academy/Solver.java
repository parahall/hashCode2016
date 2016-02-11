package com.android.academy;

import java.util.ArrayList;

/**
 * Created by idan on 11/02/16.
 */
public class Solver {
    public static ArrayList<DroneInstruction> solve(ProblemInstance instance) {

        // Prepare

        ArrayList<DroneInstruction> instuctions = new ArrayList<>();

        ArrayList<SorterTask> sorterTasks = new ArrayList<>();
        for (Order order : instance.orders) {
            sorterTasks.add(new SorterTask(order.row, order.col, order.orderlines));
        }

        ArrayList<DeliveryTask> deliveryTasks = new ArrayList<>();

        ArrayList<Drone> drones = new ArrayList<>();

        for (int i = 0; i < instance.numberOfDrowns; i++){
            Drone drone = new Drone();
            drone.currentRow = instance.warehouses[0].row;
            drone.currentCol = instance.warehouses[0].col;
            drones.add(drone);
        }



        // Write instructions
        boolean stillGoing = true;
        while (stillGoing && (sorterTasks.size() > 0 || deliveryTasks.size() > 0)){



        }

        return instuctions;
    }
}
