import java.util.*;

public class NPC {
   String name;
   String description;
   int health;
   int attackDamage;
   ArrayList<String> dialogue;
   public NPC(String n, int h, int ad) {
      name = n;
      health = h;
      attackDamage = ad;
      dialogue = new ArrayList<String>();
   }
   public void addDialogue(String d) {
      dialogue.add(d);
   }
   public String getRandomDialogue() {
      int r = (int)(Math.random() * dialogue.size());
      return dialogue.get(r);
   }
   public void addDescription(String d) {
      description = d;
   }
   public String getDiscription() {
      return description;
   }
   public void takeDamage(int damage) {
      health -= damage;
   }
   public int getHealth() {
      return health;
   }
}