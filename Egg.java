import java.util.Random;

/**
 * this class creates eggs as and assigns them a random color and contents
 * @author Kyle Troyer
 * @version 3/14/21
 */
class Egg {
  Random r = new Random();
  private String eggColor;
  private String eggContents;
  String colorArray[] = { "blue", "pink", "yellow", "green" };
  String contentArray[] = { "Cadbury Egg", "Reese's Egg", "pink Starburst", "yellow Peep", "25 cents", "50 cents",
      "one dollar" };

  /**
   * This this is the constructor method for the egg class, it assigns a random
   * egg color and a random egg contents
   */
  Egg() {
    eggColor = randomColor();
    eggContents = randomContents();
  }

  /**
   * This method generates a random number that it uses as an index to get a color
   * value from the colorArray
   * @return a color as a String
   */
  private String randomColor() {
    int randomIndex = r.nextInt(4);
    return colorArray[randomIndex];
  }

  /**
   * This method generates a random number that it uses as an index to get egg
   * contents from the contentArray
   * @return the Egg contents as a String
   */
  private String randomContents() {
    int randomIndex = r.nextInt(7);
    return contentArray[randomIndex];
  }

  /**
   * This is an accessor method for the egg color variable, it allows users to see
   * the color of each egg
   * @return egg color as string
   */
  String getEggColor() {
    return eggColor;
  }

  /**
   * This is an accessor method for the egg contents variable, it allows users to
   * see the contents of each egg
   * @return egg contents as string
   */
  String getEggContents() {
    return eggContents;
  }

  /**
   * this method prints out attributes about the egg. including the egg color and egg contents
  */
  void printEgg(){
    System.out.println(getEggColor() + " egg contains " + getEggContents()+".");
  }
}