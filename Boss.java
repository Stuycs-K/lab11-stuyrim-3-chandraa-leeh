import java.util.ArrayList;

public class Boss extends Adventurer{
  int reindeer, reindeerMax;
  String preferredReindeer;

  /*the other constructors ultimately call the constructor
  *with all parameters.*/
  public Boss(String name, int hp, String tool){
    super(name,hp);
    reindeerMax = 200;
    reindeer = 10;
    preferredReindeer = "Dixen";
  }

  public Boss(String name, int hp){
    this(name, hp, "Dixen");
  }

  public Boss(String name){
    this(name, 100);
  }

  public Boss(){
    this("Santa");
  }

  /*The next 8 methods are all required because they are abstract:*/
  public String getSpecialName(){
    return "Dixen";
  }

  public int getSpecial(){
    return reindeer;
  }

  public void setSpecial(int n){
    reindeer = n;
  }

  public int getSpecialMax(){
    return reindeerMax;
  }

  /*attack: deals 1-3 damage on all enemy players, gains 3 mushrooms*/
  public String attack(Adventurer other){
    int damage = 5;
    if (getSpecial() >= 30) {
        setHP(getHP() + 10);
        damage = 5 * (getSpecial() / 10);
        other.applyDamage(damage);
        return this + " attacked" + other.getName() + " and dealt " + damage +
    " points of damage to the opponent. Then, it uses its reindeer's regenerative properties to heal 10 hp.";
    }
    else if (getSpecial() >= 20) {
        damage = 5 * (getSpecial() / 10);
        other.applyDamage(damage);
        return this + " attacked" + other.getName() + " and dealt " + damage +
    " points of damage to the opponent.";
    }
    else {
        other.applyDamage(5);
        return this + " attacked" + other.getName() + " and dealt " + damage;
    }
  }


  /*uses 5 mushrooms, 3 HP, 12 damage to target opponent
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 3){
      setSpecial(getSpecial()-3);
      setHP(getHP() + 10);
      other.applyDamage(5);
      return this + " used its "+ getSpecialName() +
      " to stampede "+ other.getName() +
      ". This caused "+other.getName()+" to fall over, dealing 5 points of damage. " + this + " takes a bite of their carrot to gain 10 HP.";
    }
    else {
      return "Not enough reindeers to sacrifice. Instead" + attack(other);
    }
  }

  /* uses 3 mushrooms to give 5 special to ally*/
  public String support(Adventurer other){
    return "No other adventurer to support. Instead" + support();
  }

  /*uses 3 mushrooms to get 8 HP*/
  public String support(){
    setHP(getHP()+5);
    setSpecial(getSpecial() + 10);
    return this+" eats his mushrooms to restore 8 HP";
  }

}