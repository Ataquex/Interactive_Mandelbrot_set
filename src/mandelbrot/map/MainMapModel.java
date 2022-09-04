package mandelbrot.map;

import FractalSet.MandelbrotSet;

import java.awt.*;

public class MainMapModel {
    private MandelbrotSet mandelbrotSet;

    private Point coordinateOrigin;

    public MainMapModel(Dimension frameDimension){
        mandelbrotSet = new MandelbrotSet(frameDimension);
        coordinateOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
    }

    public void setCoordinateOrigin(int x, int y){
        coordinateOrigin.setLocation(coordinateOrigin.x - x, coordinateOrigin.y - y);
    }

    public Point getCoordinateOrigin(){
        return coordinateOrigin;
    }

    public MandelbrotSet getMandelbrotSet(){
        return mandelbrotSet;
    }
}
