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

    public void testpaint(Point coordinateOrigin){
        fractal.setComposite(AlphaComposite.Clear);
        fractal.fillRect(0, 0, displaySize.width, displaySize.height);
        fractal.setComposite(AlphaComposite.SrcOver);

        fractal.drawLine(coordinateOrigin.x - displaySize.width, coordinateOrigin.y, coordinateOrigin.x + displaySize.width, coordinateOrigin.y);
        fractal.drawLine(coordinateOrigin.x, coordinateOrigin.y - displaySize.height, coordinateOrigin.x, coordinateOrigin.y + displaySize.height);
        fractal.drawLine(coordinateOrigin.x - 400, coordinateOrigin.y + 200, coordinateOrigin.x - 100, coordinateOrigin.y + 50);
    }

    public JLabel getFractalLabelMandelbrot(){
        fractalLabelMandelbrot.setIcon(new ImageIcon(fractalImageMandelbrot));
        return fractalLabelMandelbrot;
    }

}
