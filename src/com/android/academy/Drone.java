package com.android.academy;

import java.util.ArrayList;

/**
 * Created by idan on 11/02/16.
 */
public class Drone {

    boolean isSorter = true; // ByDefault.

    public int currentRow;
    public int currentCol;

    public int movmentStartTime;
    public int movmentEndTime;

    public DroneInstruction ExecuteTurn(ArrayList<SorterTask> sorterTasks){
        DroneInstruction instruction;

        if (isSorter)
        {
            instruction = executeSorterTurn(sorterTasks);
        } else {
            instruction = executeDelivererTurn();
        }

        return null;
    }

    private DroneInstruction executeDelivererTurn() {
        return null;
    }

    private DroneInstruction executeSorterTurn(ArrayList<SorterTask> sorterTasks) {


        return null;
    }


}
