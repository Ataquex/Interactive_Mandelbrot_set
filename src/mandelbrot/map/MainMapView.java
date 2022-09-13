package mandelbrot.map;

import set.controllable.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMapView {
    private Dimension windowSize = new Dimension(1920, 1080);
    private javax.swing.Timer updateSet;

    private JFrame mandelbrotMainFrame = new JFrame("Mandelbrot set");
    private JPanel mandelbrotMainPanel = new JPanel(null);
    private MainMapModel mainMapModel = new MainMapModel(windowSize);
    private Controller mainController;

    private Point mousePressedOriginCoordinates = new Point();



    public MainMapView(){
        initSwingTimer();
    }

    public void initMainMapGUI(Controller controller){
        mainController = controller;

        mandelbrotMainFrame.setContentPane(mandelbrotMainPanel);
        mandelbrotMainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mandelbrotMainFrame.setSize(windowSize);
        mandelbrotMainFrame.setResizable(false);
        mandelbrotMainPanel.setBackground(Color.BLACK);

        mandelbrotMainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressedOriginCoordinates.setLocation(e.getX(), e.getY());
            }
        });
        mandelbrotMainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mainMapModel.setCoordinates(mousePressedOriginCoordinates.x - e.getX(), mousePressedOriginCoordinates.y - e.getY(), e.getX(), e.getY());
                updateSet.start();
                mousePressedOriginCoordinates.setLocation(e.getX(), e.getY());
            }
        });
        mandelbrotMainPanel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                mainMapModel.setCoordianteZoom(e.getWheelRotation(), e.getX(), e.getY());
                updateSet.start();
            }
        });

        updateSet.start();
        mandelbrotMainFrame.setVisible(true);
    }

    public void initSwingTimer(){
        updateSet = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.updateSet(mainMapModel);
            }
        });
        updateSet.setRepeats(false);
    }

    public void displayNewSet(){
        mandelbrotMainPanel.add(mainMapModel.getMandelbrotSet().getFractalLabelMandelbrot());
    }
}
