import java.util.*;

public class GameCharacter {
   String name;
   String gender;
   int health = 100;
   int rads = 0;
   public GameCharacter() {
      Scanner nameInput = new Scanner(System.in);
      System.out.print("What is your name? ");
      name = nameInput.next();
      System.out.print("Boy or girl? ");
      String g = nameInput.next();
      gender = g.toLowerCase();
   }
   public String getName() {
      return name;
   }
   public String getGender() {
      return gender;
   }
   public void takeDamage(int damage) {
      health -= damage;
   }
   public int getHealth() {
      return health;
   }
   public void addRad(int r) {
      rads += r;
   }
   public int attack(Weapon w) {
      return w.getEffect();
   }
   public int getRads() {
      return rads;
   }
   public int addHealth(int h) {
      health+= h;
   }
}