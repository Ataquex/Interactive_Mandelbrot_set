import FractalSet.MandelbrotSet;
import fractal.options.MapOptionView;
import mandelbrot.map.MainMapView;

import javax.swing.*;

public class Controller {
    private MainMapView mainMapView;
    private MapOptionView mapOptionView;

    public Controller(MainMapView mainMapView, MapOptionView mapOptionView){
        this.mainMapView = mainMapView;
        this.mapOptionView = mapOptionView;

        this.initMandelbrotSet();
    }

    public void initMandelbrotSet(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainMapView.initMainMapGUI();
                mapOptionView.initOptionGUI();
            }
        });
    }
}
