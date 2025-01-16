public class Driver{
  public static void main(String[] args){
    Adventurer p1 = new Fairy("Ivy", 30);
    Adventurer p2 = new Gnome("Poppy", 30);
    System.out.println(p1.attack(p2));
    System.out.println(p1.specialAttack(p2));
    System.out.println(p1.getSpecial());
    System.out.println(p1.support(p2));
    System.out.println(p2.getSpecial());
    System.out.println(p1.support());
    System.out.println(p1.getSpecial());
  }
}
