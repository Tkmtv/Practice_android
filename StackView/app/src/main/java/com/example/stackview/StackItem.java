package com.example.stackview;

public class StackItem {
    private String itemText;
    private int index;

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public StackItem(String itemText, int index) {
        this.itemText = itemText;
        this.index = index;
    }
}
