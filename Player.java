import java.util.ArrayList;

/**
 * this class keeps track of each player and their basket
 * @author Kyle Troyer, Seth Adleta, Luke Greely, Peter Winter
 * @version 3/15/21
 */
class Player {
  private int numEggs;
  private ArrayList<Egg> basket;
  
  /**
   * this is the constructor method for the player class
   */
  Player(){
    numEggs = 0;
    basket = new ArrayList<Egg>();  
  }
  
  /**
   * this is the acessor method for the numEggs varible.
   * @return the number of eggs in a players basket as an int
   */
  int getNumEggs() {
    return numEggs;
  }

  /**
   * this is the acessor method for the basket arraylist. it gives the eggs in the
   * player's basket
   * @return the player's basket as an ArrayList
   */
  ArrayList<Egg> getBasket() {
    return basket;
  }

  /**
   * this method prints out each egg in the basket
   */
    void printBasket() {
      for (Egg i : basket) {
        i.printEgg();
      }
    }

  /**
   * this method adds an egg to the player's basket and then adds 1 to the number of eggs
   * @param the method asks for an Egg object to be passed through
  */
   void foundEgg(Egg egg) {
    numEggs ++;
    basket.add(egg);
  }
  
}