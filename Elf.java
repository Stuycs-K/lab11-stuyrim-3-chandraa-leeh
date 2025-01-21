public class Elf extends Adventurer{
    int candyCanes, candyCaneMax;
    String toy;

    /*the other constructors ultimately call the constructor
    *with all parameters.*/
    public Elf(String name, int hp, String toy){
      super(name,hp);
      candyCaneMax = 12;
      candyCanes = candyCaneMax/2;
      this.toy = toy;
    }

    public Elf(String name, int hp){
      this(name,hp,"slinky");
    }

    public Elf(String name){
      this(name,30);
    }

    public Elf(){
      this("Ginger");
    }

    /*The next 8 methods are all required because they are abstract:*/
    public String getSpecialName(){
      return "candyCanes";
    }

    public int getSpecial(){
      return candyCanes;
    }

    public void setSpecial(int n){
      candyCanes = n;
    }

    public int getSpecialMax(){
      return candyCaneMax;
    }

    /*Deal 4-8 damage to opponent, restores 3 HP*/
    public String attack(Adventurer other){
      int damage = (int)(Math.random()*5)+2;
      other.setSpecial(other.getSpecial() - damage);
      restoreSpecial(damage);
      return other + " got tripped on "+ this + "'s " + toy + " and got mugged for "
      + damage + " points of " + other.getSpecialName() + ". " + this + " gains " + damage + getSpecialName();
    }

    /*Deal 3-12 damage to opponent, only if caffeine is high enough.
    *Reduces caffeine by 8.
    */
    public String specialAttack(Adventurer other){
      int damage = getSpecial();
      if(getSpecial() >= 0){
        setSpecial(0);
        other.applyDamage(damage);
        return this + "harnessed all of their "+getSpecialName()+
        "into a bomb and threw it at "+ other + ", decreasing " + other + "'s "+ other.getSpecialName() +" by " + damage;
      }else{
        return "Not enough fairyDust to power the glitter-bomb. Instead "+attack(other);
      }

    }
    /*Restores 5 special to other*/
    public String support(Adventurer other){
      if (this.getHP() <= 5) {
        return "Not enough hp! You're going to die. Instead, " + support();
      }
      else {
        other.setHP(other.getHP() + 5);
        setHP(getHP() - 5);
      return this + " gives 5 hp to "+other+". Santa notices " + this + "'s good deed and rewards " + this + " with"
      + restoreSpecial(8)+" "+other.getSpecialName();
      }
    }

    public String support(){
      int heal = getSpecial();
      setHP(getHP() + heal);
      this.setSpecial(0);
      return this.getName() + " makes a sacrifice to Santa and recieves a heal of" + heal + "hp.";
    }
  }
