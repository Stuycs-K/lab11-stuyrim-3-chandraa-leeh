public class Fairy extends Adventurer{
    int fairyDust, fairyDustMax;
    String preferredWandType;

    public Fairy(String name, int hp, String wandtype){
      super(name,hp);
      fairyDustMax = 16;
      fairyDust = fairyDustMax/2;
      preferredWandType = wandtype;
    }

    public Fairy(String name, int hp){
      this(name,hp,"dragonstring");
    }

    public Fairy(String name){
      this(name,30);
    }

    public Fairy(){
      this("Aurora");
    }


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


    public String attack(Adventurer other){
      int damage = (int)(Math.random()*5)+4;
      other.applyDamage(damage);
      setHP(this.getHP() + 3);
      return this + " spelled "+ other + " and dealt "+ damage +
      " points of damage. They then take a bite of a healing huckleberry.";
    }


    public String specialAttack(Adventurer other){
      if(getSpecial() >= 5){
        setSpecial(getSpecial() - 5);
        other.setSpecial(getSpecial() - 10);
        return this + " used their "+preferredWandType+
        " wand to glitter-bomb "+ other + "." +
        " This blasted "+other+", decreasing their "+ other.getSpecialName() +" by 10.";
      }else{
        return "Not enough fairyDust to power the glitter-bomb. Instead "+attack(other);
      }

    }

    public String support(Adventurer other){
      return "Spells "+other+" with "
      + other.restoreSpecial(5)+" "+other.getSpecialName();
    }

    public String support(){
      return this+" travels to the Magic Forest to obtain "+restoreSpecial(5)+" "
      + getSpecialName();
    }

  }
