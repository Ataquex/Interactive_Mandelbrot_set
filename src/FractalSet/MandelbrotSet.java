package FractalSet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotSet {
    private BufferedImage fractalImageMandelbrot;
    private JLabel fractalLabelMandelbrot;
    private Graphics2D fractal;
    private Dimension displaySize;

    public MandelbrotSet(Dimension panelDimension){
        displaySize = panelDimension;
        fractalImageMandelbrot = new BufferedImage(displaySize.width, displaySize.height, BufferedImage.TYPE_INT_ARGB);
        fractalLabelMandelbrot = new JLabel();
        fractalLabelMandelbrot.setBounds(0, 0, displaySize.width, displaySize.height);
        fractal = fractalImageMandelbrot.createGraphics();
        fractal.setColor(Color.BLUE);
        fractal.setStroke(new BasicStroke(10));
    }

    public void paintsomeshit(Point coordinateOrigin, double[] coordinateZoom, Point coordinateFocus, Point originalOrigin, double[] coordinatesScaled) {
        fractal.setComposite(AlphaComposite.Clear);
        fractal.fillRect(0, 0, displaySize.width, displaySize.height);
        fractal.setComposite(AlphaComposite.SrcOver);

        fractal.drawLine(0, coordinateOrigin.y, displaySize.width, coordinateOrigin.y);
        fractal.drawLine(coordinateOrigin.x, 0, coordinateOrigin.x, displaySize.height);
        fractal.drawLine(coordinateOrigin.x, coordinateOrigin.y, originalOrigin.x, originalOrigin.y);
        fractal.drawLine(coordinateOrigin.x + coordinateFocus.x, coordinateOrigin.y + coordinateFocus.y, coordinateOrigin.x + coordinateFocus.x, coordinateOrigin.y + coordinateFocus.y);

        double xAxisStep = ((coordinatesScaled[0] - coordinatesScaled[2])/displaySize.width);
        double yAxisStep = coordinatesScaled[0]/displaySize.height;
        double xValueScaled = 0 - coordinatesScaled[0];
        double tempSolution;
        for (int i = 1; i <= displaySize.width; i++) {
            tempSolution = Math.sin(2*xValueScaled);
            System.out.println(tempSolution);
            fractal.drawLine(i, (int)(tempSolution*(540/coordinatesScaled[1]))+(displaySize.height/2), i, (int)(tempSolution*(540/coordinatesScaled[1]))+(displaySize.height/2));
            xValueScaled += xAxisStep;
        }
    }

    public JLabel getFractalLabelMandelbrot(){
        fractalLabelMandelbrot.setIcon(new ImageIcon(fractalImageMandelbrot));
        return fractalLabelMandelbrot;
    }

}
