package com.gourianova.ui;

import javax.swing.*;
import java.awt.*;

public class Box extends JPanel {
    public Box(int x, int y){
    //    setBounds(x*Config.SIZE,y*Config.SIZE,Config.SIZE,Config.SIZE);
        setSize(Config.HEIGHT,Config.HEIGHT);
        setLocation(x*Config.HEIGHT,y*Config.HEIGHT);
        setLayout(null);
        setBackground(Config.BACK);
    }
    public void setColor(int j){
         if (j==0) setBackground(Config.BACK);
         else setBackground(Config.FORE);
    }
}
