import java.util.*;
import java.io.*;

public class TestCode {
   public static void main(String[] args) throws FileNotFoundException {
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
      while(player.getHealth() > 0 && player.getRad() < 50) {
         System.out.println(map.move());
         if (map.getRad() > 0) {
            player.addRad(map.getRad());
         }
         if (player.getRad() < 50) {
            if (map.hasItem() == true) {
               boolean ir = false;
               while (ir == false) {
                  Scanner itm = new Scanner(System.in);
                  System.out.println("Would you like to use the " + map.getItem().getName() + "? (y/n)");
                  String ia = itm.next();
                  ia = ia.toLowerCase();
                  if (ia.equals("yes") || ia.equals("y")) {
                     if (map.getItem().isRad() == true) {
                        player.addRad(map.getItem().getEffect());
                        if (map.getItem().getEffect() > 0) {
                           System.out.println("The " + map.getItem().getName() + " added " + map.getItem().getEffect() + " rads.");
                           System.out.println("You now have " + player.getRad() + " rads.");
                        }
                        else if (map.getItem().getEffect() < 0) {
                           System.out.println("The " + map.getItem().getName() + " removed " + Math.abs(map.getItem().getEffect()) + " rads.");
                        }
                        else {
                           System.out.println("The " + map.getItem().getName() +" has no effect.");
                        }
                     }
                     else {
                        player.addHealth(map.getItem().getEffect());
                        if (map.getItem().getEffect() > 0) {
                           System.out.println("The " + map.getItem().getName() + " healed you for " + map.getItem().getEffect() + " health.");
                           System.out.println("You now have " + player.getHealth() + " health.");
                        }
                        else if (map.getItem().getEffect() < 0) {
                           System.out.println("The " + map.getItem().getName() + " took away " + Math.abs(map.getItem().getEffect()) + " health.");
                           System.out.println("You now have " + player.getHealth() + " health.");
                        }
                        else {
                           System.out.println("The " + map.getItem().getName() + " has no effect.");
                        }
                     }
                     ir = true;
                  }
                  else if (ia.equals("no") || ia.equals("n")) {
                     ir = true;
                  }
                  else {
                     System.out.println("Invalid response (y/n or yes/no). ");
                  }
               }
            }
            if (map.hasWeapon() && player.getWeaponName() != map.getWeapon().getName()) {
               boolean r = false;
               while(r == false) {
                  Scanner w = new Scanner(System.in);
                  System.out.println(map.getWeapon().getWeaponDescription());
                  System.out.println("Your current weapon: " + player.getWeaponName() + " does " + player.getDamage() + " damage.");
                  System.out.println("Would you like to pick up the " + map.getWeapon().getName() + "? (y/n)");
                  String ans = w.next();
                  ans = ans.toLowerCase();
                  if (ans.equals("yes") || ans.equals("y")) {
                     player.addWeapon(map.getWeapon());
                     System.out.println("You now have a " + player.getWeaponName() + " it does " + player.getDamage() + " damage.");
                     r = true;
                  }
                  else if (ans.equals("no") || ans.equals("n")) {
                     System.out.println("You keep your " + player.getWeaponName());
                     r= true;
                  }
                  else {
                     System.out.println("Invalid response.");
                  }
               }
            }
            if (map.hasNPC()) {
               if (map.getNPC().getHealth() > 0) {
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
                           System.out.println("You did " + player.getDamage() + " damage with your " + player.getWeaponName() + ".");
                           if (map.getNPC().getHealth() > 0) {
                              System.out.println(map.getNPC().getName() + ": \"" +map.getNPC().getRandomDialogue() + "\"");
                              player.takeDamage(map.getNPC().getDamage());
                              System.out.println("You got attacked by " + map.getNPC().getName() + " for " + map.getNPC().getDamage() + " damage.");
                           }
                           if (player.getHealth() > 0) {
                              System.out.println("You now have " + player.getHealth() + " health.");
                           }
                           else {
                              System.out.println("You are DEAD.");
                           }
                           if (map.getNPC().getHealth() <= 0) {
                              System.out.println(map.getNPC().getName() + ": \"" + map.getNPC().getDeathPhrase() + "\"");
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
                  if (map.getNPC().getName() == "TrumpBorg" && map.getNPC().getHealth() <= 0) {
                     System.out.println("Your journey has come to an end, the wasteland");
                     System.out.println("has been saved, all thanks to you. The country");
                     System.out.println("can now start to rebuild. And though your journey");
                     System.out.println("ends and you are free to do what you wish as the ");
                     System.out.println("world lives in peace. Just remember that");
                     System.out.println("War, war never changes.");
                     System.out.println();
                  }
               }
            }
            if (map.hasStory()) {
               Scanner sty = map.getStory().progress();
               System.out.print(map.getStory().getNPCName() + ": ");
               while(sty.hasNextLine()) {
                  System.out.println(sty.nextLine());
               }
            }
         }
      }
      System.out.println("GAME OVER");
   }
   public static Map mapCreate(GameCharacter player) throws FileNotFoundException {
      NPC joe = new NPC("Joe", 60, 7);
      joe.addDialogue("Ow!");
      String inputS = "\"What are you doing in my swamp?\"";
      String story1GoodR = "I want to help the wasteland by stopping the source: Donald Trump";
      String story1BadR = "I'm here to loot the place.";
      String story1NeutralR = "I'm totally lost and don't know where I'm going.";
      Scanner story1Good = new Scanner( new File("Story1Good.txt"));
      Scanner story1Bad = new Scanner(new File("Story1Bad.txt"));
      Scanner story1Neutral = new Scanner(new File("Story1Neutral.txt"));
      Story s1 = new Story(player, joe, inputS, story1Good, story1Bad, story1Neutral, story1GoodR, story1BadR, story1NeutralR);
      joe.addDeathPhrase("You'll burn in hell for this!");
      Item radBegone = new Item ("RadBeGone", "rad", -10, true);
      NPC trumpBorg = new NPC("TrumpBorg", 150, 15);
      trumpBorg.addDescription("You see Donald Trump in a mech suit, he stands in front of his trump tower.");
      trumpBorg.addDialogue("I am huuuuuge!");
      trumpBorg.addDialogue("You've crossed the wall!");
      trumpBorg.addDialogue("You'll never destroy my trump tower!");
      trumpBorg.addDialogue("I should've built a bigger wall!");
      trumpBorg.addDialogue("One of my best qualities is I'm very rich.");
      joe.addDescription("There is a tall, raggedy man.");
      trumpBorg.addDeathPhrase("You'll pay for this, just like the Mexicans did for my wall, " + player.getName() + "!");
      Item medkit = new Item("medkit", "heals", 20, false);
      Enviro home = new Enviro("hilly", "fallout shelter, you grew up here..");
      Enviro one = new Enviro("grassy", "hill");
      Enviro two = new Enviro("sandy", "crater", 2);
      Enviro three = new Enviro("foresty", "cabin");
      Weapon shotgun = new Weapon("Shotgun", 25);
      three.addWeapon(shotgun);
      Enviro four = new Enviro("flatland", "pile of rubble", joe);
      Enviro five = new Enviro("muddy", "river");
      Enviro six = new Enviro("burned", "dead tree", 5);
      Enviro seven = new Enviro("ashfilled", "charred corpse", 4);
      Enviro eight = new Enviro("urban", "broken car");
      Enviro finalTrump = new Enviro("flatland", "trump tower", trumpBorg);
      Enviro cityRemains = new Enviro("abandoned city", "broken down buildings");
      four.addItem(medkit);
      eight.addStory(s1);
      eight.addItem(radBegone);
      Map map = new Map(player.getX(), player.getY());
      map.addEnviro(home, 5, 5);
      map.addEnviro(two, 5, 6);
      map.addEnviro(three, 5, 4);
      map.addEnviro(one, 4, 5);
      map.addEnviro(two, 6, 5);
      map.addEnviro(four, 4, 6);
      map.addEnviro(four, 4, 4);
      map.addEnviro(eight, 6, 4);
      map.addEnviro(two, 6, 6);
      map.addEnviro(three, 5, 7);
      map.addEnviro(six, 5, 3);
      map.addEnviro(five, 4, 3);
      map.addEnviro(six, 4, 7);
      map.addEnviro(five, 6, 3);
      map.addEnviro(two, 5, 8);
      map.addEnviro(six, 6, 7);
      map.addEnviro(six, 5, 8);
      map.addEnviro(seven, 4, 3);
      map.addEnviro(one, 6, 3);
      map.addEnviro(finalTrump, 5, 1);
      map.addEnviro(cityRemains, 5, 2);
      map.addEnviro(cityRemains, 6, 2);
      map.addEnviro(cityRemains, 4, 1);
      map.addEnviro(cityRemains, 6, 1);
      map.addEnviro(cityRemains, 4, 2);
      return map;
   }
}