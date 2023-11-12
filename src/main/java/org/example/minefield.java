package org.example;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class minefield implements MouseListener {
    JFrame f;
    Button[][] board = new Button[10][10];
    int openButton;

    public void mineField() {

        openButton = 0;
        f = new JFrame("MaineField");
        f.setSize(800, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(10, 10));

        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                Button b = new Button(row, col);

                f.add(b);
                b.addMouseListener(this);
                board[row][col] = b;

            }

        }
        generatemine();
        upDateCount();
        //printMine();

        f.setVisible(true);
    }

    private void generatemine() {
        int i = 0;
        while (i < 10) {

            int randRow = (int) (Math.random() * board.length);
            int randCol = (int) (Math.random() * board[0].length);


            while (board[randRow][randCol].isMine()) {

                randRow = (int) (Math.random() * board.length);
                randCol = (int) (Math.random() * board[0].length);

            }
            board[randRow][randCol].setMine(true);

            i++;
        }


    }

    public void print() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isMine()) {
                    board[row][col].setIcon(new ImageIcon("F:\\develop\\kodlama vakti\\MineField\\mine.png"));
                }else {

                    board[row][col].setText(Integer.toString(board[row][col].getCount()));
                    board[row][col].setEnabled((false));
                }
            }
        }
    }
public void printMine(){
    for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board[0].length; col++) {
            if (board[row][col].isMine()) {
                board[row][col].setIcon(new ImageIcon("F:\\develop\\kodlama vakti\\MineField\\mine.png"));

            }
        }
    }

}
    public void upDateCount() {
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (board[row][col].isMine()) {
                    counting(row, col);

                }
            }
        }
    }

    public void counting(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int k = col - 1; k <= col + 1; k++) {
                try {
                    int value = board[i][k].getCount();
                    board[i][k].setCount(++value);


                } catch (Exception e) {

                }
            }
        }
    }

    public void open(int row, int col) {
        if (row < 0 || row >= board.length | col < 0 || col >= board[0].length || board[row][col].getText().length() > 0 || board[row][col].isEnabled() == false) {
            return;
        } else if (board[row][col].getCount() != 0) {
            board[row][col].setText(board[row][col].getCount() + "");
            board[row][col].setEnabled(false);
            openButton++;
        } else {
            openButton++;
            board[row][col].setEnabled(false);
            open(row - 1, col);
            open(row + 1, col);
            open(row, col - 1);
            open(row, col + 1);


        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Button b = (Button) e.getComponent();
        if (e.getButton() == 1) {
            //System.out.println("sol tık");
            if (b.isMine()) {
                JOptionPane.showMessageDialog(f, "Mayına Bastınız Oyun Bitti !");
                print();
            } else {
                open(b.getRow(), b.getCol());
                if (openButton == (board.length * board[0].length - 10)) {
                    JOptionPane.showMessageDialog(f, "oyunu kazandınız !");
                }
            }

        } else if (e.getButton() == 3) {
           // System.out.println("sağ tık");
            if (!b.isFlag()) {
                b.setIcon((new ImageIcon("F:\\develop\\kodlama vakti\\MineField\\Flag.png")));
                b.setFlag(true);

            } else {
                b.setIcon(null);
                b.setFlag(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

