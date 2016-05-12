public class Enviro {
   String terrain;
   String structure;
   int rads;
   NPC npc;
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
   public String getDescription() {
      if (rads > 0) {
         String description = "You approach a " + terrain + " area with a " + structure + "it ommits " + rads + "rads.";
      }
      else {
         String description = "You approach a " + terrain + " area with a " + structure + ".";
      }
      return description;
   }
}