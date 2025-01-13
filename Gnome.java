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

  /*Deal 2-7 damage to opponent, restores 2 caffeine*/
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*3)+1;
    other.applyDamage(damage);
    restoreSpecial(3);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage. They then take a sip of their coffee.";
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
  /*Restores 5 special to other*/
  public String support(Adventurer other){
    return "Gives a coffee to "+other+" and restores "
    + other.restoreSpecial(5)+" "+other.getSpecialName();
  }
  /*Restores 6 special and 1 hp to self.*/
  public String support(){
    int hp = 1;
    setHP(getHP()+hp);
    return this+" drinks a coffee to restores "+restoreSpecial(6)+" "
    + getSpecialName()+ " and "+hp+" HP";
  }
}
