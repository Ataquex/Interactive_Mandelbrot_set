import fractal.options.MapOptionView;
import mandelbrot.map.MainMapView;
import set.controllable.Controller;

public class main {

    public static void main(String[] arguments){
        MainMapView mainMapView = new MainMapView();
        MapOptionView mapOptionView = new MapOptionView();
        Controller mainController = new Controller(mainMapView, mapOptionView);
    }
}
