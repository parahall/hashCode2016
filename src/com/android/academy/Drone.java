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

        return executeSorterTurn(task, instance);
    }

    private DroneInstruction executeDelivererTurn() {
        return null;
    }

    private DroneInstruction executeSorterTurn(SorterTask task, ProblemInstance instance) {
        // calculate task weight;
        int weight = task.getWeight(instance);

        if (weight > instance.droneMaxLoad){
            SorterTask cutoff = splitOrder(task);

        } else {

        }

        return null;
    }

    private SorterTask splitOrder(SorterTask task) {
        // TODO: Implement.
        // this should take the task,
        // split it (mutate it so it will fit)
        // and return the cut off.

        return null;
    }


}
