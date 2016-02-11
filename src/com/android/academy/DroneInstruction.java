package com.android.academy;

public class DroneInstruction {

    private DroneInstruction(){ /* Use Static Factory Methods! */}

    public int droneId;
    public String action;
    public String params;

    public static DroneInstruction makeLoad(int droneId, int warehouseId, int productType, int quantity){
        DroneInstruction i = new DroneInstruction();
        i.droneId = droneId;
        i.action = "L";
        i.params = "" + warehouseId + " " + productType + " " + quantity;
        return i;
    }

    public static DroneInstruction makeUnload(int droneId, int warehouseId, int productType, int quantity){
        DroneInstruction i = new DroneInstruction();
        i.droneId = droneId;
        i.action = "U";
        i.params = "" + warehouseId + " " + productType + " " + quantity;
        return i;
    }

    public static DroneInstruction makeDrop(int droneId, int orderId, int productType, int quantity){
        DroneInstruction i = new DroneInstruction();
        i.droneId = droneId;
        i.action = "D";
        i.params = "" + orderId + " " + productType + " " + quantity;
        return i;
    }

    public static DroneInstruction makeWait(int droneId, int turns){
        DroneInstruction i = new DroneInstruction();
        i.droneId = droneId;
        i.action = "W";
        i.params = "" + turns;
        return i;
    }

    public String toLine(){
        return String.format("%d %s %s", droneId, action, params);
    }

}
