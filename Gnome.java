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

  public CodeWarrior(String name, int hp){
    this(name,hp,"trowel");
  }

  public CodeWarrior(String name){
    this(name,30);
  }

  public CodeWarrior(){
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
  public String attack(){
    int damage = (int)(Math.random()*3)+1;
    other.applyDamage(damage);
    restoreSpecial(2);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage. They then take a sip of their coffee.";
  }

  /*Deal 3-12 damage to opponent, only if caffeine is high enough.
  *Reduces caffeine by 8.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 8){
      setSpecial(getSpecial()-8);
      int damage = (int)(Math.random()*5+Math.random()*5)+3;
      other.applyDamage(damage);
      return this + " used their "+preferredLanguage+
      " skills to hack the matrix. "+
      " This glitched out "+other+" dealing "+ damage +" points of damage.";
    }else{
      return "Not enough caffeine to use the ultimate code. Instead "+attack(other);
    }

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
