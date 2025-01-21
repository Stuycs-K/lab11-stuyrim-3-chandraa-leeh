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
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*3)+3;
    other.applyDamage(damage);
    restoreSpecial(3);
    return this + " attacked " + other.getName() + " and dealt " + damage +
    " points of damage to the opponent. Then, they add fertilizer to their mushroom garden to recieve 3 mushrooms";
  }


  /*uses 5 mushrooms, 3 HP, 12 damage to target opponent
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 5 && getHP() > 3){
      setSpecial(getSpecial()-5);
      int damage = (int) 12;
      setHP(getHP() - 3);
      other.applyDamage(damage);
      return this + " used "+getSpecialName()+
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
    setSpecial(getSpecial() - 3);
    other.setSpecial(other.getSpecial() + 8);
    return "Gives a bag of mushrooms to "+other+" and restores "
    + "5 "+other.getSpecialName();
  }
  /*uses 3 mushrooms to get 8 HP*/
  public String support(){
    setSpecial(getSpecial() - 3);
    setHP(getHP()+8);
    return this+" eats his mushrooms to restore 8 HP";
  }

}
