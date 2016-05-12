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
      joe.addDescription("You see a tall, raggedy man.");
      System.out.println(joe.getDiscription());
      joe.addDialogue("Why do you cross these parts?");
      joe.addDialogue("Get out of here!");
      System.out.println(joe.getRandomDialogue());
      Item medkit = new Item("medkit", "heals", 20);
      System.out.println(medkit.getDescription());
      Enviro one = new Enviro("grassy", "hill", 2);
      //Weapon shotgun = new Weapon("Shotgun", 20);
   }
}