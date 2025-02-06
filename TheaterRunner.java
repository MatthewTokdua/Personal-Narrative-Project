import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    //instantiates a new scene
    MyScene myScene = new MyScene();

    //plays the scene
    Theater.playScenes(myScene.drawScene());
    
    
  }
}