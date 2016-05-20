import java.util.*;
import java.io.*;

public class TestCode {
   public static void main(String[] args) throws FileNotFoundException {
      //GameCharacter player;
      intro();
   }
   public static void intro() throws FileNotFoundException { 
      Scanner introText = new Scanner(new File("intro.txt"));
      while(introText.hasNextLine()) {
         System.out.println(introText.nextLine());
      }
      GameCharacter player = new GameCharacter();
      
      System.out.println("Your journey begins now " + player.getName() + "...");
      Scanner introText2 = new Scanner(new File("intro2.txt"));
      while(introText2.hasNextLine()) {
         System.out.println(introText2.nextLine());
      }
      System.out.println();
      System.out.println("You " + player.getName() + " are the sole survivor...");
      Map map = mapCreate(player);
      System.out.println(map.getEnvironment());
      while(player.getHealth() > 0) {
         System.out.println(map.move());
         if (map.getRad() > 0) {
            player.addRad(map.getRad());
         }
         if (map.hasItem()) {
            
         }
         if (map.hasNPC()) {
            boolean b = false;
            while(b == false) {
               Scanner s = new Scanner(System.in);
               System.out.println("Would you like to attack the person?(y/n) ");
               String ans = s.next();
               ans = ans.toLowerCase();
               if (ans.equals("yes") || ans.equals("y")) {
                  boolean r = false;
                  while(player.getHealth() > 0 && map.getNPC().getHealth() > 0 && r == false) {
                     map.getNPC().takeDamage(player.getDamage());
                     System.out.println("You did " + player.getDamage() + " damage.");
                     player.takeDamage(map.getNPC().getDamage());
                     System.out.println("You got attacked by " + map.getNPC().getName() + " for " + map.getNPC().getDamage() + " damage.");
                     if (player.getHealth() > 0) {
                        System.out.println("You now have " + player.getHealth() + " health.");
                     }
                     else {
                        System.out.println("You are DEAD.");
                     }
                     if (map.getNPC().getHealth() <= 0) {
                        System.out.println("You killed " + map.getNPC().getName() + ".");
                     }
                     
                     boolean tf = false;
                     if (player.getHealth() > 0) {
                        while(tf == false && map.getNPC().getHealth() > 0) {
                           Scanner aw = new Scanner(System.in);
                           System.out.println("Would you like to run? (y/n) ");
                           String rn = aw.next();
                           if (rn.equals("yes") || rn.equals("y")) {
                              System.out.println("You escaped.");
                              r = true;
                              tf = true;
                           }
                           else if (rn.equals("no") || rn.equals("n")) {
                              tf = true;
                           }
                           else {
                              System.out.println("Invalid response.");
                           }
                        }
                     }
                  }
                  b = true;
               }
               else if (ans.equals("no") || ans.equals("n")) {
                  b = true;
               }
               else {
                  System.out.println("Invalid response (y/n or yes/no). ");
               }
            }
         }
      }
      System.out.println("GAME OVER");
   }
   public static Map mapCreate(GameCharacter player) {
      NPC joe = new NPC("Joe", 60, 7);
      joe.addDescription("There is a tall, raggedy man.");
      Item medkit = new Item("medkit", "heals", 20);
      Enviro one = new Enviro("grassy", "hill");
      Weapon shotgun = new Weapon("Shotgun", 20);
      Enviro two = new Enviro("sandy", "crater", 2);
      Enviro three = new Enviro("foresty", "cabin");
      Enviro four = new Enviro("flatland", "pile of rubble", joe);
      Enviro five = new Enviro("muddy", "river");
      Enviro six = new Enviro("burned", "dead tree", 5);
      four.addItem(medkit);
      Map map = new Map(player.getX(), player.getY());
      map.addEnviro(one, 5, 5);
      map.addEnviro(two, 5, 6);
      map.addEnviro(three, 5, 4);
      map.addEnviro(one, 4, 5);
      map.addEnviro(two, 6, 5);
      map.addEnviro(four, 4, 6);
      map.addEnviro(four, 4, 4);
      map.addEnviro(one, 6, 4);
      map.addEnviro(two, 6, 6);
      map.addEnviro(three, 5, 7);
      map.addEnviro(six, 5, 3);
      map.addEnviro(five, 4, 3);
      map.addEnviro(six, 4, 7);
      map.addEnviro(five, 6, 3);
      map.addEnviro(two, 5, 8);
      map.addEnviro(six, 6, 7);
      map.addEnviro(six, 5, 8);
      //map.addEnviro();
      //map.addEnviro();
      return map;
   }
}