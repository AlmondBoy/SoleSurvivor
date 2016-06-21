public class Item {
   String name;
   String effect;
   int effectNumber;
   boolean isRadi;
   public Item(String n, String e, int en, boolean isR) {
      name = n;
      effect = e;
      effectNumber = en;
      isRadi = isR;
   }
   public int getEffect() {
      return effectNumber;
   }
   public String getName() {
      return name;
   }
   public String getDescription() {
      String description;
      if (isRadi != true) {
         description = "You find a " + name + " it " + effect + " by " + effectNumber + " points";
      }
      else {
         if (effectNumber < 0) {
            description = "You find " + name + " it removes " + effectNumber + "rads.";
         }
         else {
            description = "You find a " + name + " you are unsure of the effects, but it could add radiation.";
         }
      }
      return description;
   }
   public boolean isRad() {
      return isRadi;
   }
}