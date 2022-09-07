package mandelbrot.map;

import FractalSet.MandelbrotSet;

import java.awt.*;

public class MainMapModel {
    private MandelbrotSet mandelbrotSet;

    private Point saveOriginalOrigin;
    private Point coordinateOrigin;
    private Point coordinateCurrentCenterFocusRelativeToOrigin;
    private double coordianteZoom = 0d;
    private double coordinateFromX = -2d;
    private double coordinateFromY = -2d;
    private double coordinateToX = 2d;
    private double coordinateToY = 2d;

    public MainMapModel(Dimension frameDimension){
        saveOriginalOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
        mandelbrotSet = new MandelbrotSet(frameDimension);
        coordinateOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
        coordinateCurrentCenterFocusRelativeToOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
    }

    public Point getCoordinateOrigin(){
        return coordinateOrigin;
    }

    public void setCoordinateOrigin(int x, int y){
        coordinateOrigin.setLocation(coordinateOrigin.x - x, coordinateOrigin.y - y);
        coordinateCurrentCenterFocusRelativeToOrigin.setLocation(coordinateOrigin.x - saveOriginalOrigin.x, coordinateOrigin.y - saveOriginalOrigin.y);
    }

    public double getCoordianteZoom() {
        return ((coordianteZoom / 100) + 1);
    }

    public void setCoordianteZoom(double coordianteZoom) {
        this.coordianteZoom = this.coordianteZoom + (coordianteZoom * (-1));
        if (this.coordianteZoom < 0){
            this.coordianteZoom++;
        }
    }

    public MandelbrotSet getMandelbrotSet(){
        return mandelbrotSet;
    }

    public Point getCoordinateCurrentCenterFocusRelativeToOrigin(){
        return coordinateCurrentCenterFocusRelativeToOrigin;
    }

    public Point getSaveOriginalOrigin(){
        return saveOriginalOrigin;
    }
}
