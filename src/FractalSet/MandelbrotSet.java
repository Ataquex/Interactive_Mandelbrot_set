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
        fractalImageMandelbrot = new BufferedImage(displaySize.width, displaySize.height, BufferedImage.TYPE_INT_RGB);
        fractalLabelMandelbrot = new JLabel();
        fractalLabelMandelbrot.setBounds(0, 0, displaySize.width, displaySize.height);
        fractal = fractalImageMandelbrot.createGraphics();
        fractal.setColor(Color.BLUE);
        fractal.setStroke(new BasicStroke(1));
    }

    public void paintFractal(double[] coordinateOrigin, double[] coordinateZoom, int iterations) {
        double mapLeft = ((-0) / coordinateZoom[0] - coordinateOrigin[0]);
        double mapTop = ((-0) / coordinateZoom[1] - coordinateOrigin[1]);
        double mapRight = ((displaySize.width) / coordinateZoom[0] - coordinateOrigin[0]);
        double mapBottom = ((displaySize.height) / coordinateZoom[1] - coordinateOrigin[1]);

        double mapPerPixelX = (mapRight - mapLeft) / (displaySize.width);
        double mapPerPixelY = (mapBottom - mapTop) / (displaySize.height);

        double countIterations, realComponent, imaginaryComponent, savePointX, savePointY, transferX, transferY, tempRGB;

        for (double x = mapLeft; x < mapRight; x += mapPerPixelX){
            for (double y = mapTop; y < mapBottom; y += mapPerPixelY) {

                savePointX = x;
                savePointY = y;
                transferX = x;
                transferY = y;

                for (countIterations = 0; countIterations < iterations; countIterations++){
                    realComponent = transferX * transferX - transferY * transferY;
                    imaginaryComponent = 2 * transferX * transferY;

                    transferX = realComponent + savePointX;
                    transferY = imaginaryComponent + savePointY;

                    if ((transferX * transferX + transferY * transferY) > 4){
                        break;
                    }
                }
                tempRGB = ((countIterations) / iterations);
                if (tempRGB == 1) {
                    tempRGB = 0;
                }
                Color gradient = new Color((int) (tempRGB * 255), (int) (tempRGB * 64), (int) (tempRGB * 128));
                fractal.setColor(gradient);
                fractal.drawLine((int)((x + coordinateOrigin[0]) * coordinateZoom[0]), (int)((y + coordinateOrigin[1]) * coordinateZoom[1]), (int)((x + coordinateOrigin[0]) * coordinateZoom[0]), (int)((y + coordinateOrigin[1]) * coordinateZoom[1]));
            }
        }
    }



    public JLabel getFractalLabelMandelbrot(){
        fractalLabelMandelbrot.setIcon(new ImageIcon(fractalImageMandelbrot));
        return fractalLabelMandelbrot;
    }

}
