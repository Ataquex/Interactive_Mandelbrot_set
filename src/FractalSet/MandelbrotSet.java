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
        fractal.setStroke(new BasicStroke(1));
    }

    public void paintsomeshit(double[] coordinateOrigin, double[] coordinateZoom) {
        fractal.setComposite(AlphaComposite.Clear);
        fractal.fillRect(0, 0, displaySize.width, displaySize.height);
        fractal.setComposite(AlphaComposite.SrcOver);

        double mapLeft = (-0) / coordinateZoom[0] - coordinateOrigin[0];
        double mapTop = (-0) / coordinateZoom[1] - coordinateOrigin[1];
        double mapRight = (displaySize.width) / coordinateZoom[0] - coordinateOrigin[0];
        double mapBottom = (displaySize.height) / coordinateZoom[1] - coordinateOrigin[1];

        double mapPerPixelX = (mapRight - mapLeft) / (displaySize.width);
        double mapPerPixelY = (mapBottom - mapTop) / (displaySize.height);

        for (double x = mapLeft; x < mapRight; x += mapPerPixelX){
            for (double y = mapTop; y < mapBottom; y += mapPerPixelY) {

                double ca = x;
                double cb = y;
                double iterations;
                double xa = x, ya = y;

                for (iterations = 0; iterations < 100; iterations++){
                    double xx = xa * xa - ya * ya;
                    double yy = 2 * xa * ya;
                    xa = xx + ca;
                    ya = yy + cb;
                    if (xa + ya > 2){
                        break;
                    }
                }
                double color = ((iterations) / 100) * 255;
                fractal.setColor(Color.decode("0x" + Integer.toHexString((int) color) + Integer.toHexString((int) color) + Integer.toHexString((int) color)));
                fractal.drawLine((int)((x + coordinateOrigin[0]) * coordinateZoom[0]), (int)((y + coordinateOrigin[1]) * coordinateZoom[1]), (int)((x + coordinateOrigin[0]) * coordinateZoom[0]), (int)((y + coordinateOrigin[1]) * coordinateZoom[1]));
            }
        }
    }



    public JLabel getFractalLabelMandelbrot(){
        fractalLabelMandelbrot.setIcon(new ImageIcon(fractalImageMandelbrot));
        return fractalLabelMandelbrot;
    }

}
