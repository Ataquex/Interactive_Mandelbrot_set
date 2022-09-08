package mandelbrot.map;

import FractalSet.MandelbrotSet;

import java.awt.*;

public class MainMapModel {
    private MandelbrotSet mandelbrotSet;

    private Point saveOriginalOrigin;
    private Point coordinateOrigin;
    private Point coordinateCurrentCenterFocusRelativeToOrigin;
    private Point currentMousePosition;
    private Dimension frameDimension;
    private double[] saveCoordinatesScaled = new double[] {-2d, -2d, 2d, 2d};
    private double[] coordinatesScaled = new double[] {-2d, -2d, 2d, 2d};
    private double coordinateZoomX = 1d;
    private double coordinateZoomY = 1d;

    public MainMapModel(Dimension frameDimension){
        this.frameDimension = frameDimension;
        currentMousePosition = new Point();
        saveOriginalOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
        mandelbrotSet = new MandelbrotSet(frameDimension);
        coordinateOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
        coordinateCurrentCenterFocusRelativeToOrigin = new Point(frameDimension.width/2, frameDimension.height/2);
    }

    public Point getCoordinateOrigin(){
        return coordinateOrigin;
    }

    public void setCoordinates(int mouseVectorX, int mouseVectorY, int mouseX, int mouseY){
        currentMousePosition.setLocation(mouseX, mouseY);
        coordinateOrigin.setLocation(coordinateOrigin.x - mouseVectorX, coordinateOrigin.y - mouseVectorY);
        coordinateCurrentCenterFocusRelativeToOrigin.setLocation(coordinateOrigin.x - saveOriginalOrigin.x, coordinateOrigin.y - saveOriginalOrigin.y);

        System.out.println("coordinateOrigin = " + coordinateOrigin + "        currentMousePosition = " + currentMousePosition + "        coordinateCurrentCenterFocusRelativeToOrigin = " + coordinateCurrentCenterFocusRelativeToOrigin);
    }

    public double[] getCoordianteZoom() {
        return new double[] {coordinateZoomX, coordinateZoomY};
    }

    public void setCoordianteZoom(double coordianteZoom) {
        if (coordianteZoom < 0){
            coordinateZoomX *= 1.01d;
            coordinateZoomY *= 1.01d;
        } else {
            coordinateZoomX *= 0.99d;
            coordinateZoomY *= 0.99d;
        }

        setCoordinatesScaled();
        System.out.println("x1: " + coordinatesScaled[0] + "   y1: " + coordinatesScaled[1] + "   x2: " + coordinatesScaled[2] + "   y2: " + coordinatesScaled[3] + "                         zoomX: " + coordinateZoomX + "   zoomY: " + coordinateZoomY);
    }

    public double[] getCoordinatesScaled(){
        return coordinatesScaled;
    }

    private void setCoordinatesScaled(){
        this.coordinatesScaled[0] = saveCoordinatesScaled[0] * coordinateZoomX;
        this.coordinatesScaled[1] = saveCoordinatesScaled[1] * coordinateZoomY;
        this.coordinatesScaled[2] = saveCoordinatesScaled[2] * coordinateZoomX;
        this.coordinatesScaled[3] = saveCoordinatesScaled[3] * coordinateZoomY;
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
