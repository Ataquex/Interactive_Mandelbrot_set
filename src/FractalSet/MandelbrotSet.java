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
        fractal.setStroke(new BasicStroke(2));
    }

    public void paintsomeshit(double[] coordinateOrigin, double[] coordinateZoom, double[] coordinateFocus, double[] originalOrigin, double[] coordinatesScaled) {
        fractal.setComposite(AlphaComposite.Clear);
        fractal.fillRect(0, 0, displaySize.width, displaySize.height);
        fractal.setComposite(AlphaComposite.SrcOver);

        fractal.drawLine(0, (int) (coordinateOrigin[1] * coordinateZoom[1]), displaySize.width, (int) (coordinateOrigin[1] * coordinateZoom[1]));
        fractal.drawLine((int) (coordinateOrigin[0] * coordinateZoom[0]), 0, (int) (coordinateOrigin[0] * coordinateZoom[0]), displaySize.height);

        for (double y = 0; y <= 10; y++){
            double startX = 0d, startY = y;
            double endX = 10d, endY = y;

            int pixel_startX = (int) ((startX + coordinateOrigin[0]) * coordinateZoom[0]);
            int pixel_startY = (int) ((startY + coordinateOrigin[1]) * coordinateZoom[1]);

            int pixel_endX = (int) ((endX + coordinateOrigin[0]) * coordinateZoom[0]);
            int pixel_endY = (int) ((endY + coordinateOrigin[1]) * coordinateZoom[1]);

            fractal.drawLine(pixel_startX, pixel_startY, pixel_endX, pixel_endY);
        }
        for (double x = 0; x <= 10; x++){
            double startX = x, startY = 0d;
            double endX = x, endY = 10d;

            int pixel_startX = (int) ((startX + coordinateOrigin[0]) * coordinateZoom[0]);
            int pixel_startY = (int) ((startY + coordinateOrigin[1]) * coordinateZoom[1]);

            int pixel_endX = (int) ((endX + coordinateOrigin[0]) * coordinateZoom[0]);
            int pixel_endY = (int) ((endY + coordinateOrigin[1]) * coordinateZoom[1]);

            fractal.drawLine(pixel_startX, pixel_startY, pixel_endX, pixel_endY);
        }
    }



    public JLabel getFractalLabelMandelbrot(){
        fractalLabelMandelbrot.setIcon(new ImageIcon(fractalImageMandelbrot));
        return fractalLabelMandelbrot;
    }

}
