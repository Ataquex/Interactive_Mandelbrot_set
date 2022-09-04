package mandelbrot.map;

import FractalSet.MandelbrotSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMapView {
    private JFrame mandelbrotMainFrame = new JFrame("Mandelbrot set");
    private JPanel mandelbrotMainPanel = new JPanel(null);
    private MainMapModel mainMapModel = new MainMapModel();

    private Dimension windowSize = new Dimension(1920, 1080);

    public MainMapView(){

    }

    public void initMainMapGUI(){
        mandelbrotMainFrame.setContentPane(mandelbrotMainPanel);
        mandelbrotMainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mandelbrotMainFrame.setSize(windowSize);
        mandelbrotMainFrame.setResizable(false);
        mandelbrotMainPanel.setBackground(Color.yellow);

        mandelbrotMainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });
        mandelbrotMainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }
        });

        mandelbrotMainFrame.setVisible(true);
    }
}
