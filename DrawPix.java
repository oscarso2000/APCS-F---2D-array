import java.awt.*;
import java.awt.image.*;

public class DrawPix
{
    static int p=0;
    final static int YELLOW = 0xFFFF00;
      final static int BLACK  = 0x000000;
      final static  int WHITE =  0xFFFFFF;
   static public void pause(int n) throws Exception
   {
      Thread.sleep( 100 * n );   // pause for 100*n msec
   }
    public static void change(int[][] pixel)
    {
        if (p==0){
        for (int col = 0; col < 1000; col++ ) {
         for (int row = 0; row < 1000; row++ ) {
             if((row%2==0&&col%2==0)||(row%2==1&&col%2==1)){
             pixel[col][row] = BLACK;
            }else if((row%2==1&&col%2==0)||(row%2==0&&col%2==1)){
             pixel[col][row] = WHITE;
            }
            }
        }
        p=1;
    }else if(p==1){
    for (int col = 0; col < 1000; col++ ) {
         for (int row = 0; row < 1000; row++ ) {
             if((row%2==0&&col%2==0)||(row%2==1&&col%2==1)){
             pixel[col][row] = WHITE;
            }else if((row%2==1&&col%2==0)||(row%2==0&&col%2==1)){
             pixel[col][row] = BLACK;
            }
            }
        }
        p=0;
    }
    
    }
   public static void main(String[] args) throws Exception
   {
      

      /* ------------------------------------------------
         Preparing to draw picture...
         ------------------------------------------------ */
      MyCanvas pic = new MyCanvas();        // Make a canvas (2 dim array)
      Frame f = new Frame( "My image" );    // Create a window

      f.add("Center", pic);                 // Put the canvas in the window
      f.setSize(1000,1000);                   // Set size of the window
      f.setVisible(true);                   // Make window visible 

      int[][] a = new int[1000][1000];        // This array hold the picture
      int row, col;

      for (col = 0; col < 1000; col++ ) {
         for (row = 0; row < 1000; row++ ) {
             if((row%2==0&&col%2==0)||(row%2==1&&col%2==1)){
             a[col][row] = BLACK;
            }else if((row%2==1&&col%2==0)||(row%2==0&&col%2==1)){
             a[col][row] = WHITE;
            }
            }
        }
      /* --------------------------------------------------
         Make a vertical yellow line (col coord unchanged)
         -------------------------------------------------- */
      a[100][191] = YELLOW; a[100][192] = YELLOW; a[100][193] = YELLOW;
      a[100][194] = YELLOW; a[100][195] = YELLOW; a[100][196] = YELLOW;
      a[100][197] = YELLOW; a[100][198] = YELLOW; a[100][199] = YELLOW;
      a[100][200] = YELLOW; a[100][201] = YELLOW; a[100][202] = YELLOW;
      a[100][203] = YELLOW; a[100][204] = YELLOW; a[100][205] = YELLOW;
      a[100][206] = YELLOW; a[100][207] = YELLOW; a[100][208] = YELLOW;
      a[100][209] = YELLOW; a[100][210] = YELLOW; a[100][211] = YELLOW;

      /* -----------------------------------------------------
         Make a horizontal yellow line (row coord unchanged)
         ----------------------------------------------------- */
      a[96][201] = YELLOW; a[95][201] = YELLOW; a[94][201] = YELLOW;
      a[99][201] = YELLOW; a[98][201] = YELLOW; a[97][201] = YELLOW;
      a[101][201] = YELLOW; a[102][201] = YELLOW; a[103][201] = YELLOW;
      a[104][201] = YELLOW; a[105][201] = YELLOW; a[106][201] = YELLOW;
      
      for ( int k = 0; k < 220; k++ )
      {
         pic.draw(a);       // Draw the picture in a[][]
         pause(1);
         change(a);
      }
      
      System.exit(0);
   }
}

