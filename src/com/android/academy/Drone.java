package com.android.academy;

import java.util.ArrayList;

/**
 * Created by idan on 11/02/16.
 */
public class Drone {

    int id = -1;

    public Drone(int id, int currentRow, int currentCol) {
        this.id = id;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
    }

    public int currentRow;
    public int currentCol;

    public int movmentStartTime;
    public int movmentEndTime;



    public DroneInstruction ExecuteTurn(ProblemInstance instance,
                                        ArrayList<SorterTask> sorterTasks,
                                        ArrayList<DeliveryTask> deliveryTasks){

        // go over delivery tasks.
        // if any are on me, execute 'em.
        int deliveryTaskIndex = -1;
        for (int i = 0; i < deliveryTasks.size(); i ++){
            DeliveryTask task = deliveryTasks.get(i);
            if (task.droneId == this.id){
                deliveryTaskIndex = i;
                break;
            }
        }

        if (deliveryTaskIndex > -1){
            return executeDelivererTurn();
        }

        // No Delivery Task for me!
        // let's be a sorter: Take the first sorter task.
        SorterTask task = sorterTasks.remove(0);

        return executeSorterTurn(sorterTasks, task, instance);
    }

    private DroneInstruction executeDelivererTurn() {
        return null;
    }

    private DroneInstruction executeSorterTurn(ArrayList<SorterTask> sorterTasks, SorterTask task, ProblemInstance instance) {
/*
        // calculate task weight;
        int weight = task.getWeight();

        if (weight > instance.droneMaxLoad){
            SorterTask cutoff = splitOrder(task);
            sorterTasks.add(cutoff);
        }

        // Now, the task "task" is valid to be executed.

        // Find Deliverer:

*/

        // Find the warehouse closest to the destination.
        int closestWarehouseIndex = calcClosestWarehouseIndex(task, instance);

        DroneInstruction instr = prepareOrder(task, closestWarehouseIndex, instance, sorterTasks);


        return instr;
    }

    private DroneInstruction prepareOrder(SorterTask task, int warehouseId, ProblemInstance instance, ArrayList<SorterTask> sorterTasks) {
        int weight = task.getWeight(instance);

        if (weight > instance.droneMaxLoad){
            SorterTask cutoff = splitOrder(task);
            sorterTasks.add(cutoff);
        }



        return null;
    }

    private int calcClosestWarehouseIndex(SorterTask task, ProblemInstance instance) {
        return 0;
    }

    private SorterTask splitOrder(SorterTask task) {
        // TODO: Implement.
        // this should take the task,
        // split it (mutate it so it will fit)
        // and return the cut off.

        return null;
    }


}
