import java.util.*;
import java.io.*;
public class gameCenter {
   //GameCharacter player;
   public static void main(String[] args) throws FileNotFoundException {
      intro();
      //start();
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

      NPC joe = new NPC("Joe", 70, 15);
      joe.addDescription("There is a tall, raggedy man.");
      //System.out.println(joe.getDiscription());
      //joe.addDialogue("Why do you cross these parts?");
      //joe.addDialogue("Get out of here!");
      //System.out.println(joe.getRandomDialogue());
      Item medkit = new Item("medkit", "heals", 20);
      //System.out.println(medkit.getDescription());
      Enviro one = new Enviro("grassy", "hill");
      Weapon shotgun = new Weapon("Shotgun", 20);
      Enviro two = new Enviro("sandy", "crater", 2);
      Enviro three = new Enviro("foresty", "cabin");
      Enviro four = new Enviro("Flatland", "pile of rubble", joe);
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
      
      System.out.println(map.getEnvironment());
      System.out.println(map.move());
      //map.getNPC();
      System.out.println();
      System.out.println(map.move());
      //System.out.println(map.getNPC().getDiscription());
      System.out.println(map.move());
   }
}