/*
MIT Open Courseware 6.092 Assignment 5
https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/assignments/MIT6_092IAP10_assn05.pdf

This file uses Java's built-in graphics and containers to create a variety of
animated objects, including shapes, text, and moving boxes. The code to
synthesize these items is located here, in the DrawGraphics file, and the code
that constructs a BouncingBox and the code that executes the drawing are located
in BouncingBox.java and SimpleDraw.java.

Boucing boxes are stored in an arraylist with different starting points and
movement vectors. These are defined in the DrawGraphics method. The arraylist is
iterated through in the draw method. Non-moving animations are added to the
background in the draw method.
*/

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.Object;

public class DrawGraphics {

    ArrayList<Object> bouncingBox_ArrayList = new ArrayList<Object>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {

        BouncingBox box1 = new BouncingBox(200, 50, Color.PINK);
        box1.setMovementVector(5,6);
        bouncingBox_ArrayList.add(box1);

        BouncingBox box2 = new BouncingBox(100, 50, Color.CYAN);
        box2.setMovementVector(-1,2);
        bouncingBox_ArrayList.add(box2);

        BouncingBox box3 = new BouncingBox(100, 50, Color.YELLOW);
        box3.setMovementVector(2,-1);
        bouncingBox_ArrayList.add(box3);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {

        surface.drawRoundRect(50, //x
                              100, //y
                              200, //width
                              100, //height
                              20, //arcWidth
                              10); //arcHeigth
        surface.setColor(Color.BLUE);
        surface.fillRoundRect(50, 100, 200, 100, 20, 10);

        surface.setColor(Color.MAGENTA);

        int[] xpoints1 = new int[]{160, 130, 190};
        int[] ypoints1 = new int[]{100, 200, 200};
        surface.drawPolygon(xpoints1, ypoints1, 3);
        surface.fillPolygon(xpoints1, ypoints1, 3);

        int[] xpoints2 = new int[]{140, 110, 170};
        surface.drawPolygon(xpoints2, ypoints1, 3);
        surface.fillPolygon(xpoints2, ypoints1, 3);

        surface.setColor(Color.RED);
        int[] xpoints3 = new int[]{150, 129, 171};
        int[] ypoints3 = new int[]{131, 200, 200};
        surface.drawPolygon(xpoints3, ypoints3, 3);
        surface.fillPolygon(xpoints3, ypoints3, 3);

        surface.setColor(Color.BLACK);
        surface.drawString("GRAPHICS", 119, 90);

        for (int i = 0; i < bouncingBox_ArrayList.size(); i++){

          BouncingBox drawitem = (BouncingBox) bouncingBox_ArrayList.get(i);
          drawitem.draw(surface);
        }
    }
}
