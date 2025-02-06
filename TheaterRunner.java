import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    //instantiates a new scene
    MyScene myScene = new MyScene();

    //instantiates a new image
    ModifiedImage image = new ModifiedImage("cokestudio.jpg");

    //main draw scene call
    //myScene.drawScene();

    //plays the scene
    Theater.playScenes(myScene.drawScene());
    
    
  }
}