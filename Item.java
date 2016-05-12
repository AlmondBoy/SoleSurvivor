public class Item {
   String name;
   String effect;
   int effectNumber;
   public Item(String n, String e, int en) {
      name = n;
      effect = e;
      effectNumber = en;
   }
   public int getEffect() {
      return effectNumber;
   }
   public String getDescription() {
      String description = "You find a " + name + " it " + effect + " by " + effectNumber + " points";
      return description;
   }
}