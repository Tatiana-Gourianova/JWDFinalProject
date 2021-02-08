package com.gourianova.ui;

import javax.swing.*;

import com.gourianova.model.Coord;
import com.gourianova.service.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Window extends JFrame implements Runnable {
    private Box[][] boxes;
    private PlayFigure play;
    public PlayFigure getPlay() {
        return play;
    }
    public void setPlay(PlayFigure play) {
        this.play=play;
    }
    public Box[][] getBoxes() {
        return boxes;
    }

    public Window() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        initForm();
        initBoxes();
        addKeyListener(new KeyAdapter());
        play = new PlayFigure();
        play.setBoxes(boxes);
        addFigure(play);
        TimeAdapter timeAdapter = new TimeAdapter();
        Timer timer=new Timer(1000, timeAdapter);
        timer.start();
        showFigure(1);
    }

    public void initBoxes() {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                add(boxes[x][y]);
            }
        }
    }

    public void setBoxColor(int x, int y, int color) {
        if (x < 0 || x >= Config.WIDTH) return;
        if (y < 0 || y >= Config.HEIGHT) return;
        boxes[x][y].setColor(color);
    }

    public void addFigure(PlayFigure play) {
        setPlay(play);



    }




    public void initForm() {

        setSize(Config.WIDTH * Config.HEIGHT + Config.SIZE, Config.HEIGHT * Config.HEIGHT + Config.HEIGHT + Config.WIDTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("BinocularVisionTetris");
        setVisible(true);

    }
    public void movePlay ( int sx, int sy){
        hideFigure ();
        play.moveFigure(sx,sy);
        showFigure(1);
    }
    public void showFigure(int color) {
        for (Coord dots : play.getFigures().dots) {
            setBoxColor(play.getCoord().x + dots.x, play.getCoord().y + dots.y, color);
        }
    }

    private void hideFigure() {
        showFigure(0);
    }

    public void run() {

        repaint();

    }

    class KeyAdapter implements KeyListener {
        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            hideFigure();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                   movePlay(-1, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    movePlay(+1, 0);
                    break;//coord=new Coord(coord.x+1,coord.y);break;
                case KeyEvent.VK_DOWN:
                    movePlay(0, +1);
                    break;//
                case KeyEvent.VK_UP:
                    movePlay(0, -1);
                    break;//
                case KeyEvent.VK_SPACE:
                    play.turnFigure();
                    //     figure.turnLeft();break;
                    //     case KeyEvent.VK_3:figure.turnRight();break;
            }
            showFigure(1);
        }

        public void keyReleased(KeyEvent e) {

        }


    }

    public class TimeAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            play.moveFigure(0,1);
        }
    }

}


