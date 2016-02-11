package com.android.academy;

public class SorterTask {
    public int targetRow;
    public int targetColumn;
    public int orderWeight;

    public int[] itemsQuantity;

    public SorterTask(int row, int col, int[] orderlines, int[] productWeight) {
        targetRow = row;
        targetColumn = col;
        for (int prodIndex : orderlines) {
            orderWeight += productWeight[prodIndex];
        }
        itemsQuantity = new int[orderlines.length];
        System.arraycopy(orderlines, 0, itemsQuantity, 0, orderlines.length);
    }

    public int getWeight() {
        return orderWeight;
    }
}
