import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 * this class ....
 *@author
 *@version 3/15/20
*/
class Main {
/**
 * this is the main method it runs when you press the run button on repple and it starts the easter egg hunt
*/
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int manyPlayers;
    System.out.println("How many players are in this Easter egg hunt? ");
    System.out.println("Enter a positive whole number:");
  /* found the input validation at: 
    https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner 
  */
    do {
        while (!s.hasNextInt()) {
            System.out.println("Enter a positive whole number:");
            s.next();
        }
        manyPlayers = s.nextInt();
        if(manyPlayers <= 0){
              System.out.println("Enter a positive whole number:");
            }
    } while (manyPlayers <= 0);
    
    ArrayList<Player> playerList = new ArrayList<Player>();
    for(int i = 0; i < manyPlayers; i++){
      Player p = new Player();
      playerList.add(p);
    }
    System.out.println("We have added " + manyPlayers + " players to this hunt. Let’s find some eggs!");
    System.out.println();
    hunt(playerList);
    recap(playerList);
    stats(playerList);
  }
  public static void hunt(ArrayList<Player> playerList){
    Random r = new Random();
    for (int i = 0; i < playerList.size();i++){
      int eggNum = r.nextInt(11);
      for(int e = 0; e < eggNum; e++){
      Egg egg = new Egg();
      playerList.get(i).foundEgg(egg);
      }
    }
  }
/**
 * this method ...
 *@param
*/
  public static void recap(ArrayList<Player> playerList){
    int i;
    for (i = 0; i < playerList.size();i++){
      System.out.println("Player " + i + " found " + playerList.get(i).getNumEggs() + " eggs");
      playerList.get(i).printBasket();
      System.out.println();
    }  
  }
/**
 * this method ...
 *@param
*/
  public static void stats(ArrayList<Player> playerList){
        
    //{"blue", "pink", "yellow", "green" }
    int colorArray[] = {0,0,0,0} ;
    //{ "Cadbury Egg", "Reese's Egg", "pink Starburst", "yellow Peep", "25 cents", "50 cents", "one dollar" }
    int contentsArray[] = {0,0,0,0,0,0,0};
    //creates an array the size of how many players are in the user picks
    int ps = playerList.size();
    int eggsFound[] = new int[ps];
    for (int i = 0; i < ps ;i++){
      //adds the number of eggs each player found to the eggsFound array
      eggsFound[i] = playerList.get(i).getNumEggs();

      //created this variable since we use it for a lot of upper bounds in our for loop
      int bs = playerList.get(i).getBasket().size();

      //for each player's basket it looks at every egg and 1 to the contentsArray in the index that coresponds to the egg's contents
      for (int e = 0; e < bs; e++){
        String color = playerList.get(i).getBasket().get(e).getEggColor();
        if(color.equals("blue")){
          colorArray[0] += 1;
        }else if(color.equals("pink")){
          colorArray[1] += 1;
        }else if(color.equals("yellow")){
          colorArray[2] += 1;
        }else{
          colorArray[3] += 1;
        }
      }
      //for each player's basket it looks at every egg and 1 to the contentsArray in the index that coresponds to the egg's contents
      for (int c = 0; c < bs; c++){
        String contents = playerList.get(i).getBasket().get(c).getEggContents();
        if(contents.equals("Cadbury Egg")){
          contentsArray[0] += 1;
        }else if(contents.equals("Reese's Egg")){
          contentsArray[1] += 1;
        }else if(contents.equals("pink Starburst")){
          contentsArray[2] += 1;
        }else if(contents.equals("yellow Peep")){
          contentsArray[3] += 1;
        }else if(contents.equals("25 cents")){
          contentsArray[4] += 1;
        }else if(contents.equals("50 cents")){
          contentsArray[5] += 1;
        }else{
          contentsArray[6] += 1;
        }
      }
    }
    //find the max number from the eggsFound array by comparing the first index to each subsequent one and replacing the comparision number with the higest one.
    int maxEggs = eggsFound[0];
    for(int k = 0; k < eggsFound.length; k++){
      maxEggs = Math.max(maxEggs, eggsFound[k]);
    }
    //creating an ArrayList to track winners. using a for loop and the eggsFound array to save "winner string" for each player who found the higest number of eggs
    ArrayList<String> winnerArray = new ArrayList<String>();
    for(int m = 0; m < eggsFound.length; m++){
      if (eggsFound[m] == maxEggs){
        winnerArray.add(
          "Player " + m + " found the most eggs, with " + eggsFound[m] + " eggs!");
      }
    }

    //sum up the  number of eggs found by summing the values in the colorArray
    int totalEggs = 0;
    for(int x=0; x < colorArray.length; x++) {
    totalEggs += colorArray[x];
    }

    //Winner print out & find ties
    //Extra credit 3 : Additional features
    if(winnerArray.size() > 1){
      System.out.println("There is a Tie!");
      System.out.println("Winners:");
      for (String w : winnerArray) {
	      System.out.println(w);
      }
    }else{
      System.out.println("Winner:");
      for (String w : winnerArray) {
	      System.out.println(w);
      }
    }
    
    
    System.out.println();
    //print out summary statistics for eggcolor
    System.out.println("Total eggs found: " + totalEggs);
    System.out.println("Blue eggs: " + colorArray[0]);
    System.out.println("Pink eggs: " + colorArray[1]);
    System.out.println("Yellow eggs: " + colorArray[2]);
    System.out.println("Green eggs: " + colorArray[3]);
    
    System.out.println();
    //print out summary statistics for EggContents
    System.out.println("Total prizes found: " + totalEggs);
    System.out.println("Cadbury Egg: " + contentsArray[0]);
    System.out.println("Reese's Egg: " + contentsArray[1]);
    System.out.println("pink Starburst: " + contentsArray[2]);
    System.out.println("yellow Peep: " + contentsArray[3]);
    System.out.println("25 cents: " + contentsArray[4]);
    System.out.println("50 cents: " + contentsArray[5]);
    System.out.println("one dollar: " + contentsArray[6]);

  }
}


