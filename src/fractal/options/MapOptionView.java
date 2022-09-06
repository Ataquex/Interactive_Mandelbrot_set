package fractal.options;

import set.controllable.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MapOptionView {
    private Dimension windowSize = new Dimension(300, 550);

    private JPanel fractalOptionPanel = new JPanel(new GridBagLayout());
    private JSlider setIterations = new JSlider(1, 64000, 1);
    private JLabel setIterationsLabel = new JLabel("Iterations: 1");
    private JSeparator setIterationsSeparate = new JSeparator(SwingConstants.HORIZONTAL);
    private JCheckBox checkJuliaSet = new JCheckBox("Julia set", false);
    private JLabel checkJuliaSetLabel = new JLabel("Activate Julia set: ");
    private JPanel colorOptionPanel = new JPanel(new GridBagLayout());

    private JFrame mandelbrotOptionFrame = new JFrame("Options");
    private JPanel mandelbrotOptionPanel = new JPanel(new GridBagLayout());
    private GridBagConstraints componentConstraints = new GridBagConstraints();
    private MapOptionModel mapOptionModel = new MapOptionModel();
    private Controller mainController;



    public MapOptionView() {
        setIterations.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setIterationsLabel.setText("Iterations: " + setIterations.getValue());
            }
        });
    }

    public void initOptionGUI(Controller controller){
        mainController = controller;

        mandelbrotOptionFrame.setContentPane(mandelbrotOptionPanel);
        mandelbrotOptionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mandelbrotOptionFrame.setSize(windowSize);
        mandelbrotOptionFrame.setResizable(false);
        mandelbrotOptionPanel.setBackground(Color.MAGENTA);

        componentConstraints.fill = GridBagConstraints.BOTH;
        componentConstraints.gridy = 0;
        componentConstraints.gridx = 0;
        componentConstraints.weighty = 0.1;
        componentConstraints.weightx = 0.5;
        fractalOptionPanel.setBackground(Color.BLUE);
        mandelbrotOptionPanel.add(fractalOptionPanel, componentConstraints);

        componentConstraints.gridy = 1;
        componentConstraints.weighty = 0.9;
        colorOptionPanel.setBackground(Color.GREEN);
        mandelbrotOptionPanel.add(colorOptionPanel, componentConstraints);

        componentConstraints.gridy = 0;
        componentConstraints.weightx = 0.5;
        componentConstraints.weighty = 0.5;
        componentConstraints.insets = new Insets(10, 10, -5, 0);
        componentConstraints.anchor = GridBagConstraints.LINE_START;
        setIterationsLabel.setForeground(Color.decode("0xe3e3e3"));
        fractalOptionPanel.add(setIterationsLabel, componentConstraints);

        componentConstraints.gridy = 1;
        componentConstraints.gridwidth = 2;
        componentConstraints.anchor = GridBagConstraints.CENTER;
        componentConstraints.insets = new Insets(-3, 4, 10, 4);
        setIterations.setBackground(null);
        fractalOptionPanel.add(setIterations, componentConstraints);

        componentConstraints.gridy = 2;
        componentConstraints.insets = new Insets(0, 15, 0, 15);
        setIterationsSeparate.setBackground(Color.green);
        fractalOptionPanel.add(setIterationsSeparate, componentConstraints);

        componentConstraints.gridy = 3;
        componentConstraints.gridwidth = 1;
        componentConstraints.anchor = GridBagConstraints.LINE_START;
        componentConstraints.insets = new Insets(0, 10, 0, 0);
        checkJuliaSetLabel.setForeground(Color.decode("0xe3e3e3"));
        fractalOptionPanel.add(checkJuliaSetLabel, componentConstraints);

        componentConstraints.gridx = 1;
        componentConstraints.insets = new Insets(0, 0, 0, 0);
        checkJuliaSet.setForeground(Color.decode("0xe3e3e3"));
        checkJuliaSet.setBackground(null);
        fractalOptionPanel.add(checkJuliaSet, componentConstraints);

        mandelbrotOptionFrame.setVisible(true);
    }
}
