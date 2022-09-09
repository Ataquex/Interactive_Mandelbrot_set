package mandelbrot.map;

import FractalSet.MandelbrotSet;

import java.awt.*;

public class MainMapModel {
    private MandelbrotSet mandelbrotSet;

    private double[] saveOriginalOrigin;
    private double[] coordinateCurrentCenterFocusRelativeToOrigin;
    private double[] currentMousePosition;
    private double[] currentMousePositionInMapBefore;
    private double[] currentMousePositionInMapAfter;
    private double[] coordinateOrigin;
    private double[] saveCoordinatesScaled = new double[] {-2d, -2d, 2d, 2d};
    private double[] coordinatesScaled = new double[] {-2d, -2d, 2d, 2d};
    private Dimension frameDimension;
    private double coordinateZoomX = 1d;
    private double coordinateZoomY = 1d;

    public MainMapModel(Dimension frameDimension){
        this.frameDimension = frameDimension;
        currentMousePosition = new double[] {0, 0};
        currentMousePositionInMapBefore = new double[] {0, 0};
        currentMousePositionInMapAfter = new double[] {0, 0};
        saveOriginalOrigin = new double[]{frameDimension.width/2, frameDimension.height/2};
        coordinateOrigin = new double[]{frameDimension.width/2, frameDimension.height/2};
        coordinateCurrentCenterFocusRelativeToOrigin = new double[]{frameDimension.width/2, frameDimension.height/2};
        mandelbrotSet = new MandelbrotSet(frameDimension);
    }

    public void setCoordinates(int mouseVectorX, int mouseVectorY, int mouseX, int mouseY){
        currentMousePosition[0] = mouseX;
        currentMousePosition[1] = mouseY;

        coordinateOrigin[0] += - mouseVectorX / coordinateZoomX;
        coordinateOrigin[1] += - mouseVectorY / coordinateZoomY;

        coordinateCurrentCenterFocusRelativeToOrigin[0] = (coordinateOrigin[0] - saveOriginalOrigin[0]);
        coordinateCurrentCenterFocusRelativeToOrigin[1] = (coordinateOrigin[1] - saveOriginalOrigin[1]);

        //setCurrentMousePositionInMap(mouseX, mouseY);

        //System.out.println("coordinateOrigin = " + coordinateOrigin[0] + " " + coordinateOrigin[1] + "        currentMousePosition = " + currentMousePosition[0] + " " + currentMousePosition[1] + "        coordinateCurrentCenterFocusRelativeToOrigin = " + coordinateCurrentCenterFocusRelativeToOrigin[0] + " " + coordinateCurrentCenterFocusRelativeToOrigin[1]);
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

        currentMousePosition[0] = posX;
        currentMousePosition[1] = posY;

        coordinateOrigin[0] -= (currentMousePositionInMapBefore[0] - currentMousePositionInMapAfter[0]);
        coordinateOrigin[1] -= (currentMousePositionInMapBefore[1] - currentMousePositionInMapAfter[1]);

        setCoordinatesScaled();
        //System.out.println("x1: " + coordinatesScaled[0] + "   y1: " + coordinatesScaled[1] + "   x2: " + coordinatesScaled[2] + "   y2: " + coordinatesScaled[3] + "                         zoomX: " + coordinateZoomX + "   zoomY: " + coordinateZoomY);
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

    private double[] setCurrentMousePositionInMap(double posX, double posY){
        double x = posX / coordinateZoomX - coordinateOrigin[0];
        double y = posY / coordinateZoomY - coordinateOrigin[1];
        return new double[] {x, y};
    }

    public MandelbrotSet getMandelbrotSet(){
        return mandelbrotSet;
    }

    public double[] getCoordinateCurrentCenterFocusRelativeToOrigin(){
        return coordinateCurrentCenterFocusRelativeToOrigin;
    }

    public double[] getSaveOriginalOrigin(){
        return saveOriginalOrigin;
    }

    public double[] getCoordinateOrigin(){
        return coordinateOrigin;
    }

    public double[] getCurrentMousePosition(){
        return currentMousePosition;
    }
}
