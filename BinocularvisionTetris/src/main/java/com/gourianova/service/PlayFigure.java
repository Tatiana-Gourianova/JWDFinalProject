package com.gourianova.service;

import com.gourianova.model.Coord;
import com.gourianova.model.Figures;

import com.gourianova.ui.Box;
import com.gourianova.ui.Config;

public class PlayFigure {
        private Figures figures;
        private Coord coord;
        private Box[][] boxes;
        private boolean isLanded;

        public boolean isLanded(){
    return isLanded;
}
public void setLanded(boolean quest){
    this.isLanded=quest;
}
    public Figures getFigures(){
    return figures;
}
public Coord getCoord(){
    return coord;
}
public void setBoxes(Box[][] boxes){
    this.boxes=boxes;
}
    public PlayFigure () {
        figures= Figures.getRandom();
        coord=new Coord(Config.WIDTH/2,-figures.top.y);
    }


    public void showFigure(Figures figures, Coord at, int color) {
            for (Coord dot : figures.dots) {
                setBoxColor(at.x + dot.x, at.y + dot.y, color);
            }
        }
        public void setBoxColor(int x, int y, int color) {
            if (x < 0 || x >= Config.WIDTH) return;
            if (y < 0 || y >= Config.HEIGHT) return;
            boxes[x][y].setColor(color);
        }
        private boolean canMoveFigure ( int sx, int sy){
            int left = coord.x + sx + figures.top.x;
            if (left < 0) return false;
            int right = coord.x + sx + figures.bottom.x;
            if (right >= Config.WIDTH) return false;
            int down = coord.y + sy + figures.top.y;
            if (down < 0) {
                return false;
                 }
            int up = coord.y + sy + figures.bottom.y;

            if ((up >= Config.HEIGHT)||(boxes[coord.x+sx+1][coord.y+sy+1].getColor()==2))
            {
                setLanded(true);

                return false;
            }

            for (Coord dot: figures.dots)
                if (boxes[coord.x+dot.x+sx][coord.y+dot.y+sy].getColor()!=0){
                    setLanded(true);
                    return false;}

            return true;
        }

        public void moveFigure ( int sx, int sy){
            hideFigure ();
            if (canMoveFigure(sx, sy)) {
                coord = coord.plus(sx, sy);}
            showFigure();
        }

        public void turnFigure () {
            Figures rotated = figures.turnRight();
            if (canMoveFigure(0, 0)) {
                figures = rotated;
            } else if (canMoveFigure(1, 0)) {
                figures = rotated;
                moveFigure(1, 0);
            } else if (canMoveFigure(-1, 0)) {
                figures = rotated;
                moveFigure(-1, 0);
                figures = rotated;
            }
        }


        private void showFigure () {
            showFigure(figures, coord, 1);
        }

        private void hideFigure () {
            showFigure(figures, coord, 0);
        }


}



