package mandelbrot.map;

import FractalSet.MandelbrotSet;

import java.awt.*;

public class MainMapModel {
    private MandelbrotSet mandelbrotSet;

    private Point coordinateOrigin;
    private float coordianteZoom = 0;

    public MainMapModel(Dimension frameDimension){
        mandelbrotSet = new MandelbrotSet(frameDimension);
        coordinateOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
    }

    public Point getCoordinateOrigin(){
        return coordinateOrigin;
    }

    public void setCoordinateOrigin(int x, int y){
        coordinateOrigin.setLocation(coordinateOrigin.x - x, coordinateOrigin.y - y);
    }

    public float getCoordianteZoom() {
        return (coordianteZoom / 10);
    }

    public void setCoordianteZoom(float coordianteZoom) {
        this.coordianteZoom = this.coordianteZoom + (coordianteZoom * (-1));
        if (this.coordianteZoom < 1){
            this.coordianteZoom++;
        }
    }

    public MandelbrotSet getMandelbrotSet(){
        return mandelbrotSet;
    }
}
