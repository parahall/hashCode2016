package com.android.academy;

public class SorterTask {
    public int targetRow;
    public int targetColumn;

    public int[] itemsQuantity;

    public SorterTask(int row, int col, int[] orderlines) {
        targetRow = row;
        targetColumn = col;
        itemsQuantity = orderlines;
    }
}
