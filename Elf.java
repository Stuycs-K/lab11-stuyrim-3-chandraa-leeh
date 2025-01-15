public class Fairy extends Adventurer{
    int candyCanes, candyCaneMax;
    String preferredGift;

    /*the other constructors ultimately call the constructor
    *with all parameters.*/
    public Fairy(String name, int hp, String gift){
      super(name,hp);
      candyCaneMax = 12;
      candyCanes = candyCaneMax/2;
      preferredGift = gift;
    }

    public Fairy(String name, int hp){
      this(name,hp,"c++");
    }

    public Fairy(String name){
      this(name,30);
    }

    public Fairy(){
      this("Aurora");
    }

    /*The next 8 methods are all required because they are abstract:*/
    public String getSpecialName(){
      return "fairyDust";
    }

    public int getSpecial(){
      return fairyDust;
    }

    public void setSpecial(int n){
      fairyDust = n;
    }

    public int getSpecialMax(){
      return fairyDustMax;
    }

    /*Deal 4-8 damage to opponent, restores 3 HP*/
    public String attack(Adventurer other){
      int damage = (int)(Math.random()*5)+4;
      other.applyDamage(damage);
      setHP(this.HP + 3);
      return this + " spelled "+ other + " and dealt "+ damage +
      " points of damage. They then take a bite of a healing huckleberry.";
    }

    /*Deal 3-12 damage to opponent, only if caffeine is high enough.
    *Reduces caffeine by 8.
    */
    public String specialAttack(Adventurer other){
      if(getSpecial() >= 5){
        setSpecial(getSpecial() - 5);
        other.setSpecial(getSpecial() - 10);
        return this + " used their "+preferredWandType+
        " wand to glitter-bomb "+ other + "." +
        " This blasted "+other+", decreasing their"+ other.getSpecialName() +" by 10.";
      }else{
        return "Not enough fairyDust to power the glitter-bomb. Instead "+attack(other);
      }

    }
    /*Restores 5 special to other*/
    public String support(Adventurer other){
      return "Spells "+other+" with "
      + other.restoreSpecial(5)+" "+other.getSpecialName();
    }
    /*Restores 6 special and 1 hp to self.*/
    public String support(){
      return this+" travels to the Magic Forest to obtain "+restoreSpecial(5)+" "
      + getSpecialName();
    }
  }
