import java.util.*;
public class Game{
  private static final int WIDTH = 200;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;
  private static int currentRow = 2;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    //Text.clear();
    for (int x = 1; x <= HEIGHT; x++){
        for (int y = 1; y <= WIDTH; y++){
            if (x == 1 || x == HEIGHT || y == 1 || y == WIDTH){
                Text.go(x, y);
                System.out.print(Text.colorize(" ", BORDER_COLOR, BORDER_BACKGROUND));
            }
        }
    }
    Text.reset();
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    if (currentRow >= HEIGHT - 6)
    {
      currentRow = 2;
      Text.clear();
      drawBackground();
    }

    Text.go(currentRow, startCol);

    currentRow = currentRow +1 ;

    System.out.println(s);

    Text.go(currentRow,2);
    Text.showCursor();
    //drawBackground();
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(String classification){
      int randNum = (int)(Math.random() * 3) + 1;
      if (randNum == 1){
        return new Fairy(classification + " Fairy" + (int)(Math.random()*100));
      }
      else{
        if (randNum == 2){
          return new Gnome(classification + " Gnome" + (int)(Math.random()*100));
        }
        else{
          return new Elf(classification + " Elf" + (int)(Math.random()*100));
        }
      }
      //return new CodeWarrior("Bob"+(int)(Math.random()*100));
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startCol){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      for (int i = 0; i < party.size(); i++){
        Text.go(27, startCol + i * 20);
        System.out.print((party.get(i).getName()));
        Text.go(28, startCol + i * 20);
        System.out.print("HP: " + party.get(i).getHP());
        Text.go(29, startCol + i * 20);
        System.out.print(party.get(i).getSpecialName() + ": " + party.get(i).getSpecial());
      }



      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    drawBackground();
    drawParty(party, 20);
    //draw player party
    drawParty(enemies, 120);
    //draw enemy party

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      //Text.go(, );

      //show cursor
      Text.showCursor();

      String input = in.nextLine();

      //clear the text that was written

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int randNum = (int)(Math.random() * 3) + 1;
      if (randNum == 1){
        enemies.add(createRandomAdventurer("Enemy"));
      }
      else{
        if (randNum == 2){
          enemies.add(createRandomAdventurer("Enemy"));
          enemies.add(createRandomAdventurer("Enemy"));
        }
        else{
          enemies.add(createRandomAdventurer("Enemy"));
          enemies.add(createRandomAdventurer("Enemy"));
          enemies.add(createRandomAdventurer("Enemy"));
        }
      }


    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE

    int randNumParty = (int)(Math.random() * 3) + 1;
      if (randNumParty == 1){
        party.add(createRandomAdventurer("Party"));
        party.add(createRandomAdventurer("Party"));
      }
      else{
        if (randNumParty == 2){
          party.add(createRandomAdventurer("Party"));
          party.add(createRandomAdventurer("Party"));
          party.add(createRandomAdventurer("Party"));
        }
        else{
          party.add(createRandomAdventurer("Party"));
          party.add(createRandomAdventurer("Party"));
          party.add(createRandomAdventurer("Party"));
          party.add(createRandomAdventurer("Party"));
        }
      }


    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
    drawText(preprompt, 0, 2);

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      

      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );
      //drawText("input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent, 0, 2);

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          drawText(party.get(whichPlayer).attack(enemies.get(whichOpponent)), 0, 2);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          drawText(party.get(whichPlayer).specialAttack(enemies.get(whichOpponent)), 0, 2);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          String[] userParams = input.split(" ");
          int indexOfPlayer = Integer.parseInt(userParams[1]);
          if (indexOfPlayer == whichPlayer){
            drawText(party.get(whichPlayer).support(), 0, 2);
          }
          else{
            if (indexOfPlayer < party.size()){
              drawText(party.get(whichPlayer).support(party.get(indexOfPlayer)), 0, 2);
            }
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
          drawText(prompt, 0, 2);


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";
          drawText(prompt, 0, 2);

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          int numParty = (int)(Math.random() * party.size()) + 1;
          drawText(enemies.get(whichOpponent).attack(party.get(numParty-1)), 0, 2);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          int numParty = (int)(Math.random() * party.size()) + 1;
          drawText(enemies.get(whichOpponent).specialAttack(party.get(numParty-1)), 0, 2);
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          String[] userParams = input.split(" ");
          int indexOfPlayer = Integer.parseInt(userParams[1]);
          if (indexOfPlayer == whichOpponent){
            drawText(enemies.get(whichOpponent).support(), 0, 2);
          }
          else{
            if (indexOfPlayer < party.size()){
              drawText(enemies.get(whichOpponent).support(enemies.get(indexOfPlayer)), 0, 2);
            }
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        whichOpponent = 0;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
        drawText(prompt,0,2);
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
