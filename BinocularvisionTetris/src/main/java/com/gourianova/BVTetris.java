package com.gourianova;

import com.gourianova.ui.Window;

import javax.swing.*;

public class BVTetris {
    public static void main(String[] args){
        Window window=new Window();
        window.run();
        javax.swing.SwingUtilities.invokeLater(window);
    }
}
