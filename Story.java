import java.util.*;
public class Story {
   Scanner good;
   Scanner bad;
   Scanner neutral;
   String input;
   GameCharacter player;
   String goodResponse;
   String neutralResponse;
   String badResponse;
   NPC npc;
   public Story(GameCharacter p, NPC np, String i, Scanner g, Scanner b, Scanner n, String goodR, String badR, String neutralR) {
      good = g;
      bad = b;
      neutral = n;
      input = i;
      player = p;      
      goodResponse = goodR;
      neutralResponse = neutralR;
      badResponse = badR;
      npc = np;
   }
   public Scanner progress() {
      Scanner pro = new Scanner(System.in);
      boolean r = false;
      while(r == false) {
         System.out.println(npc.getDescription());
         Scanner s = new Scanner(System.in);
         System.out.println(npc.getName()+ ": " + input);
         System.out.println("Responses:");
         System.out.println("1. " + goodResponse);
         System.out.println("2. " + badResponse);
         System.out.println("3. " + neutralResponse);
         System.out.println("Type: 1, 2 or 3");
         if (s.hasNextInt()) {
            int response = s.nextInt();
            if (response == 1) {
               System.out.println(player.getName() + ": \"" + goodResponse + "\"");
               pro = good;
               r = true;
            }
            else if (response == 2) {
               System.out.println(player.getName() + ": \"" + badResponse + "\"");
               pro = bad;
               r = true;
            }
            else if (response == 3) {
               System.out.println(player.getName() + ": \"" + neutralResponse + "\"");
               pro = neutral;
               r = true;
            }
            else {
               System.out.println("Invalid response.");
            }
         }
         else {
            System.out.println("Invalid response.");
         }
      }
      return pro;
   }
   public String getNPCName() {
      return npc.getName();
   }
}