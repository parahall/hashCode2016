package com.android.academy;

public class SorterTask {
    public int targetRow;
    public int targetColumn;

    public int[] itemsQuantity;

    public SorterTask(int row, int col, int[] orderlines) {
        targetRow = row;
        targetColumn = col;
        itemsQuantity = new int[orderlines.length];
        System.arraycopy(orderlines, 0, itemsQuantity, 0, orderlines.length);
    }

    public int getWeight(ProblemInstance instance) {
        return -1;
    }
}
