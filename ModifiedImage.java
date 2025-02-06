import org.code.theater.*;
import org.code.media.*;
public class ModifiedImage extends ImagePlus{

  /*
   * Calls the superclass constructor to initialize pixels
   */
  public ModifiedImage(String filename) {
    super(filename);
  }

  //makes image more red by subtracting green and blue values
  public void makeRed(int red) {
    Pixel[][] pixel = getPixelsFromImage();
    for (int row=0;row<pixel.length;row++){
      for (int col=0;col<pixel[0].length;col++){
        pixel[row][col].setGreen(pixel[row][col].getGreen()-red);
        pixel[row][col].setBlue(pixel[row][col].getBlue()-red);
      }
    }


    
  }
}