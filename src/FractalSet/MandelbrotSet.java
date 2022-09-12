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

        double mapLeft = (-0) / coordinateZoom[0] - coordinateOrigin[0];
        double mapTop = (-0) / coordinateZoom[1] - coordinateOrigin[1];
        double mapRight = (displaySize.width) / coordinateZoom[0] - coordinateOrigin[0];
        double mapBottom = (displaySize.height) / coordinateZoom[1] - coordinateOrigin[1];
        System.out.println("mapLeft: " + mapLeft + "    mapRight: " + mapRight + "    mapTop: " + mapTop + "    mapBottom: " + mapBottom);
        int iterations = 0;

        for (double y = 0; y <= 10; y++){
            if (y >= mapTop && y <= mapBottom) {
                double startX = 0d, startY = y;
                double endX = 10d, endY = y;

                int pixel_startX = (int) ((startX + coordinateOrigin[0]) * coordinateZoom[0]);
                int pixel_startY = (int) ((startY + coordinateOrigin[1]) * coordinateZoom[1]);

                int pixel_endX = (int) ((endX + coordinateOrigin[0]) * coordinateZoom[0]);
                int pixel_endY = (int) ((endY + coordinateOrigin[1]) * coordinateZoom[1]);

                fractal.drawLine(pixel_startX, pixel_startY, pixel_endX, pixel_endY);
                iterations++;
            }
        }
        for (double x = 0; x <= 10; x++){
            if (x >= mapLeft && x <= mapRight) {
                double startX = x, startY = 0d;
                double endX = x, endY = 10d;

                int pixel_startX = (int) ((startX + coordinateOrigin[0]) * coordinateZoom[0]);
                int pixel_startY = (int) ((startY + coordinateOrigin[1]) * coordinateZoom[1]);

                int pixel_endX = (int) ((endX + coordinateOrigin[0]) * coordinateZoom[0]);
                int pixel_endY = (int) ((endY + coordinateOrigin[1]) * coordinateZoom[1]);

                fractal.drawLine(pixel_startX, pixel_startY, pixel_endX, pixel_endY);
                iterations++;
            }
        }
        fractal.drawString(Integer.toString(iterations), 100, 100);

        double mapPerPixelX = (mapRight - mapLeft) / displaySize.width;
        double mapPerPixelY = (mapBottom - mapTop) / displaySize.height;
        int px, py, opx = 0, opy = 0;
        opx = (int)(((mapLeft - mapPerPixelX) + coordinateOrigin[0]) * coordinateZoom[0]);
        opy = (int)(((-0.001 * (mapLeft - mapPerPixelY) * (mapLeft - mapPerPixelY)) + coordinateOrigin[1]) * coordinateZoom[1]);

        for (double x = mapLeft; x < mapRight; x += mapPerPixelX){
            double y = -0.001 * x * x;
            px = (int)((x + coordinateOrigin[0]) * coordinateZoom[0]);
            py = (int)((y + coordinateOrigin[1]) * coordinateZoom[1]);
            fractal.drawLine(opx, opy, px, py);
            opx = px;
            opy = py;
        }
    }



    public JLabel getFractalLabelMandelbrot(){
        fractalLabelMandelbrot.setIcon(new ImageIcon(fractalImageMandelbrot));
        return fractalLabelMandelbrot;
    }

}
