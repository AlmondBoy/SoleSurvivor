import java.util.*;

public class Map {
   Enviro[][] map = new Enviro[10][10]; //10x10 grid map
   int xCoor;
   int yCoor;
   public Map(int xLoc, int yLoc) {
      xCoor = xLoc;
      yCoor = yLoc;
   }
   public void addEnviro(Enviro e, int x, int y) {
      map[x][y] = e;
   }
   public String move() {
      boolean z = false;
      Enviro toGo;
      String descript;
      while (z == false) {
         Scanner travel = new Scanner(System.in);
         System.out.println("Which direction would you like to travel (n/s/e/w)? ");
         String direct = travel.next();
         direct = direct.toLowerCase();
         if(direct.equals("n") || direct.equals("north")) {
            if (map[xCoor][yCoor - 1] != null) {
               yCoor -= 1;
               z = true;
            }
            else {
               System.out.println("There's a massive pit, you cannot travel North.");
            }
         }
         else if (direct.equals("s") || direct.equals("south")) {
            if (map[xCoor][yCoor + 1] != null) { //height is 10, so max is ten.
               yCoor += 1;
               z = true;
            }
            else {
               System.out.println("There's a body of water, it's glowing green from radiation. You cannot travel any further South.");
            }
         }
         else if (direct.equals("e") || direct.equals("east")) {
            if (map[xCoor + 1][yCoor] != null) {
               xCoor += 1;
               z = true;
            }
            else {
               System.out.println("There's a cliffside. It's too tall to climb, you cannot travel East.");
            }
         }
         else if (direct.equals("w") || direct.equals("west")) {
            if (map[xCoor - 1][yCoor] != null) {
               xCoor -= 1;
               z = true;
            }
            else {
               System.out.println("Your geiger counter ticks like crazy. You cannot travel West or you will surely die.");
            }
         }
         else {
            System.out.println("Invalid, you must type: north, south, east or west (or n, s, e or w).");
         }
      }
      return map[xCoor][yCoor].getDescription();
   }
   public String getEnvironment() {
      return map[xCoor][yCoor].getDescription();
   }
   public Item getItem() {
      return map[xCoor][yCoor].getItem();
   }
   public boolean hasRad() {
      if(map[xCoor][yCoor].hasRad() == true) {
         return true;
      }
      else {
         return false;
      }
   }
   public boolean hasNPC() {
      if(map[xCoor][yCoor].hasNPC() == true) {
         return true;
      }
      else {
         return false;
      }
   }
   public boolean hasItem() {
      if(map[xCoor][yCoor].hasItem() == true) {
         return true;
      }
      else {
         return false;
      }
   }
   public int getRad() {
      return map[xCoor][yCoor].getRad();
   }
   public NPC getNPC() {
      return map[xCoor][yCoor].getNPC();
   }
   public boolean hasWeapon() {
      if(map[xCoor][yCoor].hasWeapon() == true) {
         return true;
      }
      else {
         return false;
      }
   }
   public Weapon getWeapon() {
      return map[xCoor][yCoor].getWeapon();
   }
   public boolean hasStory() {
      if(map[xCoor][yCoor].hasStory() == true) {
         return true;
      }
      else {
         return false;
      }
   }
   public Story getStory() {
      return map[xCoor][yCoor].getStory();
   }

}