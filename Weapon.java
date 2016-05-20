public class Weapon {
   String name;
   int damage;
   public Weapon(String n, int d) {
      name = n;
      damage = d;
   }
   public String getWeaponDescription() {
      String wD = "You find a " + name + "it does " + damage + "damage.";
      return wD;
   }
   public int getDamage() {
      return damage;
   }
   public String getName() {
      return name;
   }
}