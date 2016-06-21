public class Enviro {
   String terrain;
   String structure;
   int rads;
   NPC npc;
   Item item;
   Weapon weapon;
   Story story;
   public Enviro(String t, String h) {
      terrain = t;
      structure = h;
   }
   public Enviro(String t, String h, int r) {
      terrain = t;
      structure = h;
      rads = r;
   }
   public Enviro(String t, String h, int r, NPC n) {
      terrain = t;
      structure = h;
      rads = r;
      npc = n;
   }
   public Enviro(String t, String h, NPC n) {
      terrain = t;
      structure = h;
      npc = n;
   }
   public void addWeapon(Weapon w) {
      weapon = w;
   }
   public void addStory(Story s) {
      story = s;
   }
   public String getDescription() {
      String description;
      if(rads > 0 && npc != null && item != null) {
         description = "You approach a " + terrain + " area with a " + structure + " it ommits " + rads + " rads. " + npc.getDescription() + " " + item.getDescription();
      }
      else if(rads > 0 && npc != null) {
         description = "You approach a " + terrain + " area with a " + structure + " it ommits " + rads + " rads. " + npc.getDescription();
      }
      else if(npc != null && item != null) {
         description = "You approach a " + terrain + " area with a " + structure + ". " + npc.getDescription() + " " + item.getDescription();
      }
      else if (rads > 0 && item != null) {
         description = "You approach a " + terrain + " area with a " + structure + " it ommits " + rads + " rads. " + item.getDescription();
      }
      else if (rads > 0) {
         description = "You approach a " + terrain + " area with a " + structure + " it ommits " + rads + " rads.";
      }
      else if(npc != null) {
         description = "You approach a " + terrain + " area with a " + structure + ". " + npc.getDescription();
      }
      else {
         description = "You approach a " + terrain + " area with a " + structure + ".";
      }
      return description;
   }
   public int getRad() {
      return rads;
   }
   public NPC getNPC() {
      return npc;
   }
   public void addItem(Item i) {
      item = i;
   }
   public Item getItem() {
      return item;
   }
   public boolean hasItem() {
      if (item == null) {
         return false;
      }
      else {
         return true;
      }
   }
   public boolean hasRad() {
      if (rads < 0) {
         return false;
      }
      else {
         return true;
      }
   }
   public boolean hasNPC() {
      if (npc == null) {
         return false;
      }
      else {
         return true;
      }
   }
   public boolean hasWeapon() {
      if (weapon == null) {
         return false;
      }
      else {
         return true;
      }
   }
   public Weapon getWeapon() {
      return weapon;
   }
   public boolean hasStory() {
      if (story == null) {
         return false;
      }
      else {
         return true;
      }
   }
   public Story getStory() {
      return story;
   }
}