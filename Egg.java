import java.util.Random;
// import java.util.ArrayList;
class Egg {
  Random r = new Random();
  private String eggColor;
  private String eggContents;
  String colorArray[] = {"blue", "pink", "yellow", "green"};
  String contentArray[] = {"Cadbury Egg", "Reese's Egg", "pink Starburst", "yellow Peep", "25 cents", "50 cents", "one dollar"};

  Egg(){
    eggColor = randomColor();
    eggContents = randomContents();
  }
  private String randomColor(){
    int randomIndex = r.nextInt(4);
    return colorArray[randomIndex];
    
  }

  private String randomContents(){
    int randomIndex = r.nextInt(7);
    return contentArray[randomIndex];
  }

  String getEggColor(){
    return eggColor;
  }

  String getEggContents(){
    return eggContents;
  }

  void printEgg(){
    System.out.println(getEggColor() + " egg contains " + getEggContents()+".");
  }
}