package fractal.options;

import set.controllable.Controller;

import javax.swing.*;
import java.awt.*;

public class MapOptionView {
    private JFrame mandelbrotOptionFrame = new JFrame("Options");
    private JPanel mandelbrotOptionPanel = new JPanel();
    private MapOptionModel mapOptionModel = new MapOptionModel();
    private Controller mainController;

    public MapOptionView() {

    }

    public void initOptionGUI(Controller controller){
        mainController = controller;

        mandelbrotOptionFrame.setContentPane(mandelbrotOptionPanel);
        mandelbrotOptionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mandelbrotOptionFrame.setMinimumSize(new Dimension(300, 550));
        mandelbrotOptionPanel.setBackground(Color.MAGENTA);
        mandelbrotOptionFrame.setVisible(true);
    }
}
