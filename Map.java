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
      while (z == false) {
         Scanner travel = new Scanner(System.in);
         System.out.println("Which direction would you like to travel (n/s/e/w)? ");
         String direct = travel.next();
         direct = direct.toLowerCase();
         if(direct.equals("n") || direct.equals("north")) {
            if (yCoor > 0) {
               yCoor -= 1;
               z = true;
            }
            else {
               System.out.println("There's a massive pit, you cannot travel North.");
            }
         }
         else if (direct.equals("s") || direct.equals("south")) {
            if (yCoor < 10) { //height is 10, so max is ten.
               yCoor += 1;
               z = true;
            }
            else {
               System.out.println("There's a body of water, it's glowing green from radiation. You cannot travel any surther South.");
            }
         }
         else if (direct.equals("e") || direct.equals("east")) {
            if (xCoor < 10) {
               xCoor += 1;
               z = true;
            }
            else {
               System.out.println("There's a cliffside. It's too tall to climb, you cannot travel East.");
            }
         }
         else if (direct.equals("w") || direct.equals("west")) {
            if (xCoor > 0) {
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
   //public NPC getNPC() {
      //return map[xCoor][yCoor].getNPC();
   //}
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
}