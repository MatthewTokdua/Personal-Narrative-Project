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

  //method to make images grey
  public void makeGrey(int grey){
    Pixel[][] pixel = getPixelsFromImage();
    for (int row=0;row<pixel.length;row++){
      for (int col=0;col<pixel[0].length;col++){
        pixel[row][col].setRed(pixel[row][col].getRed()-grey);
        pixel[row][col].setGreen(pixel[row][col].getGreen()-grey);
        pixel[row][col].setBlue(pixel[row][col].getBlue()-grey);
      }
    }
  }

  //method to make images blue
  public void makeBlue(int blue){
    Pixel[][] pixel = getPixelsFromImage();
    for (int row=0;row<pixel.length;row++){
      for (int col=0;col<pixel[0].length;col++){
        pixel[row][col].setRed(pixel[row][col].getRed()-blue);
        pixel[row][col].setGreen(pixel[row][col].getGreen()-blue);
      }
    }
  }

  //method to make images more yellow
  public void makeYellow(int yellow){
    Pixel[][] pixel = getPixelsFromImage();
    for (int row=0;row<pixel.length;row++){
      for (int col=0;col<pixel[0].length;col++){
        pixel[row][col].setBlue(pixel[row][col].getRed()-yellow);
      }
    }
  }
  
}