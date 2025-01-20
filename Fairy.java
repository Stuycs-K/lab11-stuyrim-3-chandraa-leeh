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
      fairyDust = Math.max(0, Math.min(n, fairyDustMax));
    }

    public int getSpecialMax(){
      return fairyDustMax;
    }


    public String attack(Adventurer other){
      int damage = (int)(Math.random()*5)+4;
      other.applyDamage(damage);
      setHP(Math.min(getmaxHP(), this.getHP() + 3));
      return getName() + " spelled "+ other.getName() + " and dealt "+ damage +
      " points of damage. They then take a bite of a healing huckleberry.";
    }


    public String specialAttack(Adventurer other){
      if(getSpecial() >= 5){
        setSpecial(getSpecial() - 5);
        other.setSpecial(other.getSpecial() - 10);
        return getName() + " used their "+preferredWandType+
        " wand to glitter-bomb "+ other.getName() + "." +
        " This blasted "+other.getName()+", decreasing their "+ other.getSpecialName() +" by 10.";
      }else{
        return "Not enough fairyDust to power the glitter-bomb. Instead "+attack(other);
      }

    }

    public String support(Adventurer other){
      int restored = other.restoreSpecial(5);
      return getName() + " spells " + other.getName() + " with " + restored + " " + other.getSpecialName() + ".";
    }

    public String support(){
      int restored = restoreSpecial(5);
      return getName() + " travels to the Magic Forest to obtain " + restored + " " + getSpecialName() + ".";
    }

  }
