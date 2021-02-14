package com.gourianova.binocularvision.apps.tetris;

import com.gourianova.binocularvision.apps.tetris.ui.Window;

public class BVTetris {
    public void run(){
        Window window=new Window();
        window.run();
        javax.swing.SwingUtilities.invokeLater(window);
    }
}
