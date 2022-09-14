package mandelbrot.map;

import FractalSet.MandelbrotSet;

import java.awt.*;

public class MainMapModel {
    private MandelbrotSet mandelbrotSet;

    private double[] currentMousePositionInMapBefore;
    private double[] currentMousePositionInMapAfter;
    private double[] coordinateOrigin;
    private double coordinateZoomX = 1d;
    private double coordinateZoomY = 1d;

    public MainMapModel(Dimension frameDimension){
        currentMousePositionInMapBefore = new double[] {frameDimension.width/2, frameDimension.height/2};
        currentMousePositionInMapAfter = new double[] {frameDimension.width/2, frameDimension.height/2};
        coordinateOrigin = new double[]{frameDimension.width/2, frameDimension.height/2};
        mandelbrotSet = new MandelbrotSet(frameDimension);
        while ((0 / coordinateZoomX - coordinateOrigin[0]) < -4) {
            setCoordianteZoom(-1, frameDimension.width / 2.001, frameDimension.height / 2);
        }
    }

    public void setCoordinates(int mouseVectorX, int mouseVectorY, int mouseX, int mouseY){
        coordinateOrigin[0] += - mouseVectorX / coordinateZoomX;
        coordinateOrigin[1] += - mouseVectorY / coordinateZoomY;
    }

    public double[] getCoordianteZoom() {
        return new double[] {coordinateZoomX, coordinateZoomY};
    }

    public void setCoordianteZoom(double coordianteZoom, double posX, double posY) {

        currentMousePositionInMapBefore = setCurrentMousePositionInMap(posX, posY);
        if (coordianteZoom < 0){
            coordinateZoomX *= 1.1d;
            coordinateZoomY *= 1.1d;
        } else {
            coordinateZoomX *= 0.9d;
            coordinateZoomY *= 0.9d;
        }
        currentMousePositionInMapAfter = setCurrentMousePositionInMap(posX, posY);

        coordinateOrigin[0] -= (currentMousePositionInMapBefore[0] - currentMousePositionInMapAfter[0]);
        coordinateOrigin[1] -= (currentMousePositionInMapBefore[1] - currentMousePositionInMapAfter[1]);
    }

    private double[] setCurrentMousePositionInMap(double posX, double posY){
        double x = posX / coordinateZoomX - coordinateOrigin[0];
        double y = posY / coordinateZoomY - coordinateOrigin[1];
        return new double[] {x, y};
    }

    public MandelbrotSet getMandelbrotSet(){
        return mandelbrotSet;
    }

    public double[] getCoordinateOrigin(){
        return coordinateOrigin;
    }
}
