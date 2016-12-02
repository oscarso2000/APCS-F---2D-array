import java.awt.*;
import java.awt.image.*;

/* ========================================================
   Coordinate system of a Canvas:

           0    1       col#
           +----+--------+----------+  
           |                        |  ^
         1 |                        |  |
           |                        |  |
           |                        |  |  height
      row# |        (col#,row#)     |  |
           |                        |  |
           |                        |  |
           +------------------------+  v
            <---------------------->
                    width

     Coordinate = (col#, row#)
   ======================================================== */


public class MyCanvas extends Canvas
{
    static int MAX_WIDTH = 1000;
    static int MAX_HEIGHT = 1000;      // Dimensions of the 2-dim canvas

    /* ----------------------------------------------------
       The variable "Image" is 2-dim. array of pixels 
        (= image) used for the drawing

       The dimensions of the array created will be:

              MAX_WIDTH  columns
          and MAX_HEIGHT rows
       ---------------------------------------------------- */
    static BufferedImage Image 
        = new BufferedImage(MAX_WIDTH, MAX_HEIGHT, BufferedImage.TYPE_INT_RGB);


    /* ===========================================================
       The "draw" method copies the "image" stored in
       the variable "pixel" onto the "Image" variable

       This make drawing pictures easier: 
           you set up the image inside the variable "pixel" 
           and then call the "draw" method to copy the image 
           on to the screen
       =========================================================== */
    public void draw(int[][] pixel)
    {
       for ( int col = 0; col < MAX_WIDTH; col++ )
          for ( int row = 0; row < MAX_HEIGHT; row++ )
              Image.setRGB( col, row, pixel[col][row] );

       repaint();
    }


    /* -----------------------------------------
       repaint will invoke paint() 
       and will use "Image"
       ----------------------------------------- */
    public void paint(Graphics g)
    {
        g.drawImage(Image, 0, 0, Color.white, null);
    }

    /* -----------------------------------------
       Redefine update() will eliminate flicker
       ----------------------------------------- */
    public void update(Graphics g)
    {
       paint(g);
    }
}

