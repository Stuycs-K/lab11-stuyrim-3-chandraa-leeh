import java.util.ArrayList;

public class Gnome extends Adventurer{
  int mushrooms, mushroomMax;
  String gardenTool;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Gnome(String name, int hp, String tool){
    super(name,hp);
    mushroomMax = 20;
    mushrooms = 0;
    gardenTool = tool;
  }

  public Gnome(String name, int hp){
    this(name,hp,"trowel");
  }

  public Gnome(String name){
    this(name,30);
  }

  public Gnome(){
    this("Poppy");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "mushrooms";
  }

  public int getSpecial(){
    return mushrooms;
  }

  public void setSpecial(int n){
    mushrooms = n;
  }

  public int getSpecialMax(){
    return mushroomMax;
  }

  /*attack: deals 1-3 damage on all enemy players, gains 3 mushrooms*/
  public String attack(ArrayList<Adventurer> others){
    int damage = (int)(Math.random()*3)+1;
    for (int i = 0; i < others.size(); i++) {
      others.get(i).applyDamage(damage);
    }
    restoreSpecial(3);
    return this + " attacked the enemy team and dealt "+ damage +
    " points of damage to each opponent. Then, they add fertilizer to their mushroom garden";
  }

  public String attack(Adventurer other){
    return "private method";
  }

  /*uses 5 mushrooms, 3 HP, 12 damage to target opponent
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 5 && getHP() > 3){
      setSpecial(getSpecial()-5);
      int damage = (int) 12;
      other.applyDamage(damage);
      return this + " used "+mushrooms+
      " to make the enemy delirious "+
      " This caused "+other+" to trip over a rock, dealing "+ damage +" points of damage.";
    }
    if (getHP() <= 3) {
      return "You're going to kill yourself you imbecile. Instead" + attack(other);
    }
    if (getSpecial() < 5) {
      return "Not enough mushrooms foraged. Instead "+attack(other);
    }
    return "Not enough mushrooms foraged. Instead "+attack(other);
  }
  /* uses 3 mushrooms to give 5 special to ally*/
  public String support(Adventurer other){
    return "Gives a coffee to "+other+" and restores "
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*uses 3 mushrooms to get 8 HP*/
  public String support(){
    setHP(getHP()+8);
    return this+" eats his mushrooms to restore "+setHP(getHP() + 8)+" "
     +hp+" HP";
  }

  public static void main(String[] args) {
    Gnome a2 = new Gnome( "a2",  20,  "trowel");
    Gnome a1 = new Gnome( "a1",  20,  "trowel2");
    System.out.println(a2.specialAttack(a1));
    System.out.println(a1.getHP());

  }
}
