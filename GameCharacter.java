import java.util.*;

public class GameCharacter {
   String name;
   String gender;
   int health = 100;
   int rads = 0;
   int damage = 10;
   int x = 5;
   int y = 5;
   String weaponName = "fists";
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
      if (rads < 50) {
         System.out.println("You now have " + rads + " rads. Be careful, if you get 50, you'll die of radiation poisoning.");
      }
      else {
         System.out.println("You're body has reached it's limit, you're flesh begins to melt. The radiation is too much.");
      }
   }
   public int attack(Weapon w) {
      return w.getDamage();
   }
   public int getRad() {
      return rads;
   }
   public void addHealth(int h) {
      health+= h;
   }
   public void addWeapon(Weapon weapon) {
         damage = weapon.getDamage();
         weaponName = weapon.getName();
   }
   public int getDamage() {
      return damage;
   }
   public int getX() {
      return x;
   }
   public int getY() {
      return y;
   }
   public String getWeaponName() {
      return weaponName;
   }
}