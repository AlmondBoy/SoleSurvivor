public class Action {
   int attackDamage;
   
   public Action(int ad) {
      attackDamage = ad;
   }
   public int getAttackDamage() {
      Scanner s = new Scanner(System.in);
      System.out.println("What weapon would do you want to attack with?");
      Weapon w = next();
      return w.getEffect();
   }
   
}