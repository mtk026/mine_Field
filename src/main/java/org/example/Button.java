package org.example;

import javax.swing.*;

public class Button extends JButton {
    private int row;
    private int col;
    private int count;
    private boolean mine;
    private boolean flag;


    public Button(int row, int col) {
        this.setRow(row);
        this.setCol(col);
        this.setCount(count);
        this.setMine(false);
        this.setFlag(false);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}



