public class CodeWarrior extends Adventurer{
    int fairyDust, fairyDustMax;
    String preferredWand;

    /*the other constructors ultimately call the constructor
    *with all parameters.*/
    public CodeWarrior(String name, int hp, String wand){
      super(name,hp);
      fairyDustMax = 12;
      fairyDust = fairyDustMax/2;
      preferredWand = wand;
    }

    public CodeWarrior(String name, int hp){
      this(name,hp,"c++");
    }

    public CodeWarrior(String name){
      this(name,30);
    }

    public CodeWarrior(){
      this("Carmack");
    }

    /*The next 8 methods are all required because they are abstract:*/
    public String getSpecialName(){
      return "fairyDust";
    }

    public int getSpecial(){
      return fairyDust;
    }

    public void setSpecial(int n){
      caffeine = n;
    }

    public int getSpecialMax(){
      return caffeineMax;
    }

    /*Deal 4-8 damage to opponent, restores 3 HP*/
    public String attack(Adventurer other){
      int damage = (int)(Math.random()*5)+4;
      other.applyDamage(damage);
      setHP(this.HP + 3);
      return this + " attacked "+ other + " and dealt "+ damage +
      " points of damage. They then take a sip of their coffee.";
    }

    /*Deal 3-12 damage to opponent, only if caffeine is high enough.
    *Reduces caffeine by 8.
    */
    public String specialAttack(Adventurer other){
      if(getSpecial() >= 5){
        setSpecial(getSpecial() - 5);
        other.setSpecial(getSpecial() - 10);
        return this + " used their "+preferredLanguage+
        " skills to hack the matrix. "+
        " This glitched out "+other+" dealing "+ damage +" points of damage.";
      }else{
        return "Not enough fairyDust to use the ultimate code. Instead "+attack(other);
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
