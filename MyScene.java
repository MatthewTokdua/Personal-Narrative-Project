import org.code.theater.*;
import org.code.media.*;

//class to hold methods
public class MyScene extends Scene{

  //variable for card rolls
  private String[][] cardRolls = {
    {"6 10", "5 9", "14 26", "8 12", "3 8", "8 15", "20 39",  "28 42", "1 4", "14 23", "20 39", "29 35"}, 
    {"0", "0", "0", "0", "0", "0", "0",  "0", "0", "0", "0", "0"} };

  //variable for card names
  private String[] cardNames = {"Upstanding Slash", "Level Slash", "Onrush", "Focus Spirit", "Spear", "Manifest E.G.O", "Greater Split: Vertical", "Great Split: Horizontal", "Boundry of Death", "To Claim Their Bones", "Furioso", "Beatdown"};
  

  //variable for card images
  private String[] cardImages = {"RedMist3.jpg", "RedMist5.jpg", "RedMist7.jpg", "RedMist6.jpg", "RedMist4.jpg", "RedMist1.jpg", "RedMist2.jpg", "RedMist1.jpg", "Shi1.jpg", "sword6.jpg", "Roland10.jpg", "Tanya4.jpg"};

  //constructor method to give values to variables
  public MyScene(){
    //cardRolls =;
    //cardRolls[0] = FileReader.toStringArray("cardRolls.txt");
    //cardNames = {"", ""};
  }

  //main method to draw scene
  public MyScene drawScene(){
    MyScene scene = new MyScene();
    cleanData(cardRolls[0]);
    scene.drawCards(scene);
    scene.drawNames(scene);
    scene.drawRolls(scene);

    return scene;
  }

  //method to seperate min and max rolls
  public void cleanData(String[] data){
    String[][] temp = new String[2][data.length];
    for (int i=0;i<data.length;i++){
      String[] temp2 = data[i].split(" ");
      temp[0][i] = temp2[0];
      temp[1][i] = temp2[1];
    }
    cardRolls = temp;
  }
 
  //
  public void drawCards(MyScene scene){
    int x = 0;
    for (int i=0;i<cardImages.length/2;i++){
      scene.drawImage(cardImages[i],x,50,65);
      scene.pause(0.2);
      x += 68;
    }
    x = 0;
    for (int i=6;i<cardImages.length;i++){
      scene.drawImage(cardImages[i],x,210,65);
      scene.pause(0.2);
      x += 68;
    }
  }

  public void drawNames(MyScene scene){
    scene.setTextHeight(7);
    int x = 0;
    for (int i=0;i<cardNames.length/2;i++){
      scene.drawText(cardNames[i],x,30);
      scene.pause(0.2);
      x += 70;
    }
    x = 0;
    scene.setTextHeight(6);
    for (int i=6;i<cardNames.length;i++){
      scene.drawText(cardNames[i],x,190);
      scene.pause(0.2);
      x += 70;
    }
  }

  public void drawRolls(MyScene scene){
    scene.setTextHeight(15);
    int x = 0;
    for (int i=0;i<cardRolls.length/2;i++){
      scene.drawText(calcRolls(i),x,30);
      scene.pause(0.2);
      x += 70;
    }
    x = 0;
    for (int i=6;i<cardRolls.length;i++){
      scene.drawText(calcRolls(i),x,190);
      scene.pause(0.2);
      x += 70;
    } 
  }

  public String calcRolls(int col){
    int roll = 0;
    int temp = Integer.parseInt(cardRolls[1][col]) - Integer.parseInt(cardRolls[0][col]);
    int temp2 = (int) (Math.random() * 10);
    roll = Integer.parseInt(cardRolls[0][col]) + (temp - temp2);
    String temp3 = String.valueOf(roll);
    return temp3;
  }

  
  
}