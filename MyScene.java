import org.code.theater.*;
import org.code.media.*;

//class to hold methods
public class MyScene extends Scene{

  //variable for card rolls
  private String[][] cardRolls = {
    {"6 10", "5 9", "14 26", "8 12", "3 8", "20 39",  "28 42", "30 40", "1 4", "14 23", "20 39", "29 35"}, 
    {"0", "0", "0", "0", "0", "0", "0",  "0", "0", "0", "0", "0"} };

  //variable for card names
  private String[] cardNames = {"Upstanding Slash", "Level Slash", "Onrush", "Focus Spirit", "Spear", "Greater Split: Vertical", "Great Split: Horizontal", "Grand Finale", "Boundry of Death", "To Claim Their Bones", "Furioso", "Beatdown"};
  

  //variable for card images
  private String[] cardImages = {"RedMist3.jpg", "RedMist5.jpg", "RedMist7.jpg", "RedMist6.jpg", "RedMist4.jpg", "RedMist2.jpg", "RedMist1.jpg", "ArgaliaFinal.jpg", "Shi1.jpg", "sword6.jpg", "Roland10.jpg", "Tanya4.jpg"};

  //constructor method to give values to variables
  public MyScene(){
    cleanData(cardRolls[0]);
    //cardRolls =;
    //cardRolls[0] = FileReader.toStringArray("cardRolls.txt");
    //cardNames = {"", ""};
  }

  //main method to draw scene
  public MyScene drawScene(){
    MyScene scene = new MyScene();
    scene.setFillColor("red");
    scene.drawRectangle(0,0,400,400);
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
 
  //method to draw cards
  public void drawCards(MyScene scene){
    int x = 0;
    for (int i=0;i<cardImages.length/2;i++){
      ModifiedImage red = new ModifiedImage(cardImages[i]);
      red.makeRed(50);
      scene.drawImage(red,x,50,65);
      scene.pause(0.4);
      scene.playSound("Library-of-Ruina-SFX---Click--Dice-Roll--Finger-Snap---ezmp3.cc--.wav");
      x += 68;
    }
    x = 0;
    for (int i=6;i<cardImages.length;i++){
      if (i == 6){
        ModifiedImage red = new ModifiedImage(cardImages[i]);
        red.makeRed(50);
        scene.drawImage(red,x,210,65);
        scene.pause(0.4);
        scene.playSound("Library-of-Ruina-SFX---Click--Dice-Roll--Finger-Snap---ezmp3.cc--.wav");
        x += 68;
      }else if (i == 8 || i == 10){
        ModifiedImage black = new ModifiedImage(cardImages[i]);
        black.makeGrey(50);
        scene.drawImage(black,x,210,65);
        scene.pause(0.4);
        scene.playSound("Library-of-Ruina-SFX---Click--Dice-Roll--Finger-Snap---ezmp3.cc--.wav");
        x += 68;
      }else if (i == 9 || i == 7){
        ModifiedImage blue = new ModifiedImage(cardImages[i]);
        blue.makeBlue(60);
        scene.drawImage(blue,x,210,65);
        scene.pause(0.4);
        scene.playSound("Library-of-Ruina-SFX---Click--Dice-Roll--Finger-Snap---ezmp3.cc--.wav");
        x += 68;
      }else if (i == 11){
        ModifiedImage yellow = new ModifiedImage(cardImages[i]);
        yellow.makeYellow(100);
        scene.drawImage(yellow,x,210,65);
        scene.pause(0.4);
        scene.playSound("Library-of-Ruina-SFX---Click--Dice-Roll--Finger-Snap---ezmp3.cc--.wav");
        x += 68;
      }
    }
  }

  //method to draw names
  public void drawNames(MyScene scene){
    scene.setTextHeight(7);
    int x = 0;
    for (int i=0;i<cardNames.length/2;i++){
      scene.drawText(cardNames[i],x,40);
      scene.pause(0.2);
      x += 66;
    }
    x = 0;
    scene.setTextHeight(6);
    for (int i=6;i<cardNames.length;i++){
      scene.drawText(cardNames[i],x,200);
      scene.pause(0.2);
      x += 70;
    }
  }

  //method to draw rolls
  public void drawRolls(MyScene scene){
    scene.setTextHeight(15);
    int x = 20;
    for (int i=0;i<cardRolls[0].length/2;i++){
      scene.drawText(calcRolls(i),x,130);
      scene.pause(0.4);
      scene.playSound("Library-of-Ruina-SFX---Click--Dice-Roll--Finger-Snap---ezmp3.cc--.wav");
      x += 70;
    }
    x = 0;
    for (int i=6;i<cardRolls[0].length;i++){
      scene.drawText(calcRolls(i),x,290);
      scene.pause(0.4);
      scene.playSound("Library-of-Ruina-SFX---Click--Dice-Roll--Finger-Snap---ezmp3.cc--.wav");
      x += 70;
    } 
  }

  //method to calculate rolls
  public String calcRolls(int col){
    int diff = Integer.parseInt(cardRolls[1][col]) - Integer.parseInt(cardRolls[0][col]);
    int rand = (int) (Math.random() * (diff));
    int roll = Integer.parseInt(cardRolls[0][col]) + (diff - rand);
    String result = String.valueOf(roll);
    return result;
  }

  
  
}