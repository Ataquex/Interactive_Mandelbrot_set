package set.controllable;

import fractal.options.MapOptionView;
import mandelbrot.map.MainMapModel;
import mandelbrot.map.MainMapView;

import javax.swing.*;

public class Controller {
    private MainMapView mainMapView;
    private MapOptionView mapOptionView;
    private Controller self = this;

    public Controller(MainMapView mainMapView, MapOptionView mapOptionView){
        this.mainMapView = mainMapView;
        this.mapOptionView = mapOptionView;

        this.initMandelbrotSet();
    }

    public void initMandelbrotSet(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainMapView.initMainMapGUI(self);
                mapOptionView.initOptionGUI(self);
            }
        });
    }

    public void updateSet(MainMapModel viewModel){
        viewModel.getMandelbrotSet().paintFractal(viewModel.getCoordinateOrigin(), viewModel.getCoordianteZoom(), 100);
        displayNewSet();
    }

    private void displayNewSet(){
        mainMapView.displayNewSet();
    }
}
