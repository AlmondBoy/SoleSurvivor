import java.util.*;

public class Map {
   Enviro[][] map = new Enviro[10][10];
   int xCoor;
   int yCoor;
   public Map() {
   }
   public void addEnviro(Enviro e, int x, int y) {
      map[x][y] = e;
   }
   public Enviro move() {
      boolean z = false;
      Enviro toGo;
      while (z == false) {
         Scanner travel = new Scanner(System.in);
         System.out.println("Which direction would you like to travel (n/s/e/w)? ");
         String direct = travel.next();
         direct = direct.toLowerCase();
         if(direct.equals("n") || direct.equals("north")) {
            yCoor += 1;
            z = true;
         }
         else if (direct.equals("s") || direct.equals("south")) {
            yCoor -= 1;
            z = true;
         }
         else if (direct.equals("e") || direct.equals("east")) {
            xCoor += 1;
            z = true;
         }
         else if (direct.equals("w") || direct.equals("west")) {
            xCoor -= 1;
            z = true;
         }
         else {
            System.out.println("Invalid, you must type: north, south, east or west (or n, s, e or w).");
         }
      }
      return map[xCoor][yCoor];
   }
}