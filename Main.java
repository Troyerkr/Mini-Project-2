import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
*
*/
class Main {
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
    } while (manyPlayers <= 0);
    
    ArrayList<Player> playerList = new ArrayList<Player>();
    int i;
    for(i = 0; i < manyPlayers; i++){
      Player p = new Player();
      playerList.add(p);
    }
    System.out.println("We have added " + manyPlayers + " players to this hunt. Let’s find some eggs!");
    hunt(playerList);
  }
public static void hunt(ArrayList playerList){
  Random r = new Random();
  int i;
  int e;
  for (i = 0; i < playerList.size();i++){
    int eggNum = r.nextInt(11);
    for(e = 0; e < eggNum; e++){
     Egg egg = new Egg();
     playerList.get(i).foundEgg(egg); 
    }
  }
}
}
