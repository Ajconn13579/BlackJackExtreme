//Austin
//Luis
import java.io.IOException;
import java.util.Scanner;

public class Game {

 private static Scanner input = new Scanner(System.in);
    
 /*Fields for logging in purposes*/
 private static String username;
 private static String passwd;

 /*Fields for statistics purposes*/
 private static int wins;
 private static int loses;
 private static int rounds;
 private static int bJCount;
 private static int currentCredits;
 private static int creditsEarned;
 private static int creditsLost; 
 private static int highestCredits;
 private static int bankRuptcies;

 /*New players are always defaulted to credits as their starting currency*/
 private static String currency = "credits";

 static Deck playingDeck = new Deck();
 static Deck PlayerHand = new Deck();
 static Deck CompHand = new Deck();

 /*Instantiate a currentPlayer Player object*/
 private static Player currentPlayer = new Player
 (username, passwd, wins, loses, 
 rounds, bJCount, currentCredits,
 creditsEarned, creditsLost, highestCredits,
 bankRuptcies, currency);

 

static void logIn() throws IOException {

  username = IR4.getString("Alias: ");
  currentPlayer.setName(username);
  passwd = IR4.getString("Password: ");
  checkPassword(username, passwd);
  currentPlayer.setPassword(passwd);
 }

 /****************************************************************************
  Checks the password whether it's correct, depending on the user name entered 
  The user can log in as a different user by entering q
  ****************************************************************************/

 static void checkPassword(String user, String pass) throws IOException {
  for(Player x: ProjectFileIO_v2.getPlayerArrayList()) { 
   if(username.equals(x.getName())) {
    while(!passwd.equals(x.getPassword())) {
     System.err.println("Wrong password, try again, or press 'q' to change alias");
     System.out.print("Password: ");
     passwd = input.next();  
     if(passwd.equals("q")) {
      logIn();
      break;
     }
    }
   }
  }
 }

 static void isNewPlayer(String user) throws IOException {

  if(ProjectFileIO_v2.addNewPlayer(currentPlayer)) {
   System.out.println("Welcome to the club " + currentPlayer.getName());
   ProjectFileIO_v2.writeFile();
  }

  else {
   System.out.println("Welcome back " + 
  ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getName() + "!");
  }
 }

 static boolean displayMenu() throws IOException, InterruptedException {  

  boolean quit = false;
  isNewPlayer(username);
  System.out.println(" +----------------------------------------------------------------------------------+\n" +
    " |                                                                                  |\n" +
       " |        __       __                __       __                 __                 |\n" + 
       " |       |  |     |  |              |  |     (__)               |  |                |\n" +
       " |       |  |__   |  |  __ _    ___ |  | __   __   __  _    ___ |  | __             |\n" +
       " |       |  *   \\ |  |/  _` | /  __||  |/ /  |  |/  _ ` | /  __||  |/ /             |\n" +
       " |       |   |_) ||  |  (_| ||  (__ |    <   |  |  (_|  ||  (__ |    <              |\n" +
       " |       |__*__ / |__|\\ __'_| \\ ___||__|\\__\\ |  |\\ __ '_| \\ ___||__|\\__\\            |\n" +
       " |                                        __/   |                                   |\n" +
       " |                                       |_____/                                    |\n" +
       " |                  _______   _____________ ________  ________                      | \n" + 
       " |                 |  ___\\ \\ / /_   _| ___ \\  ___|  \\/  |  ___|                     | \n" + 
       " |                 | |__  \\ V /  | | | |_/ / |__ | .  . | |__                       | \n" + 
       " |                 |  __| /   \\  | | |    /|  __|| |\\/| |  __|                      | \n" + 
       " |                 | |___/ /^\\ \\ | | | |\\ \\| |___| |  | | |___                      | \n" + 
       " |                 \\____/\\/   \\/ \\_/ \\_| \\_\\____/\\_|  |_|____/                      |\n" +
       " +==================================================================================+"); 
   System.out.printf(" %-1s%-59s%10s", "| Signed in as: ", ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getName(), "|\n");  
        System.out.println(" |                                                                                  |\n" + 
                " |                                1. Play                                           |\n" +
    " |                                2. Settings                                       |\n" +
       " |                                3. Statistics                                     |\n" +
    " |                                4. Hall of Fame                                   |\n" +
    " |                                5. Credits                                        |\n" +
    " |                                6. About                                          |\n" +
    " |                                7. Exit                                           |\n" +
       " | Enter 1 - 6 for selection                                                        |\n" +
    " +==================================================================================+");

  switch(IR4.getIntegerBetweenLowAndHigh("", 1, 7, "Invalid input, try again")) {
  case 1:
   //Play menu
   mainGame();
   quit = true;
   break;

  case 2:
   //Settings menu
   displaySetting();
   quit = true;
   break;

  case 3:
   //Player statistics 
   displayStats();
   quit = true;
   break;

  case 4:
   displayHOF();
   quit = true;
   break;

  case 5:
   displayCredits();
   quit = true;
   break;
  
  case 6:
   displayAbout();
   quit = true;
   break;

  case 7:
   //Quits the game
   displayThanks();
   quit = true;
   break;

  }

  return quit;
 }

 //Setting submenu that allows the user to modify their account
 static void displaySetting() throws IOException, InterruptedException {

  System.out.printf("%42s\n", "Settings" );
  System.out.println("1. Change currency \n"+         
                        "2. Change Alias \n" +
                "3. Back");

  switch(IR4.getIntegerBetweenLowAndHigh("", 1, 3, "Invalid input, try again")) {
  
  case 1:
   changeCurrency();
   break;

  case 2:
   changeAlias();
   break;

  case 3:
   displayMenu();
   break;

  }
 }

 //The option to change their in game currency 
 static void changeCurrency() throws IOException, InterruptedException {
  ProjectFileIO_v2.readFile();
  System.out.printf("%31s\n", "Change currency");
  System.out.println("Current currency: " + 
  ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCurrency());
  System.out.println("Enter new currency name or enter 'q' to go back");
  String newCurrency = input.next();
  if(newCurrency.equalsIgnoreCase("q"))
   displaySetting();
  else
  System.out.println();
  ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setCurrency(newCurrency);
  currentPlayer.setCurrency(newCurrency);
  System.out.println("Currency successfully changed");
  ProjectFileIO_v2.writeFile();
  displaySetting();
 }

 //The option to change their log in username. 
 //Duplicate usernames are not allowed to avoid log in conflicts 
 static void changeAlias() throws IOException, InterruptedException {
  ProjectFileIO_v2.readFile();
  String newAlias = "";
  System.out.printf("%31s\n", "Change alias");
  System.out.println("Enter new name");
  newAlias = input.next();
  for(Player x: ProjectFileIO_v2.getPlayerArrayList()) {

   while(newAlias.equals(x.getName())) {
    System.err.println("Alias already taken, choose another one");
    System.out.println("Enter new name");
    newAlias = input.next();

          }
  }

  ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setName(newAlias);
  currentPlayer.setName(newAlias);
  username = newAlias;
  System.out.println("Alias successfully changed");
  ProjectFileIO_v2.writeFile();
  displaySetting();

 }


 static void displayStats() throws IOException, InterruptedException {
  String currencyName = currentPlayer.getCurrency();
  System.out.printf("%20s", "Statistics\n");
  System.out.println("Wins: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getWins() +"\n" + 
       "Loses: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getLoses() + "\n" +
       currentPlayer.getCurrency() + ": " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCredits() + "\n" +
       currencyName + " earned: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCreditsEarned() + "\n" +
       currencyName + " lost: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCreditsLost() + "\n" +
       "Highest " + currencyName + ": " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getHighestCredits() + "\n" +
       "Bankruptcies: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getBankRuptcies() + "\n" 
       );

       if(pressQ().equals("q"))
        displayMenu();

 }

 //High score lists 

 static void displayHOF() throws IOException, InterruptedException {

  System.out.println("<=================== HALL OF FAME ===================>\n");
  System.out.printf("%-20s%33s\n", "Hustler:", "Wins:");
  System.out.printf("%-20s%27c%3s\n", "--------", ' ', "------");

  int playerSize = ProjectFileIO_v2.getPlayerArrayList().size();
  int[] scores = new int[playerSize];
  String [] users = new String[playerSize];
  int count = 0;

  for(Player player: ProjectFileIO_v2.getPlayerArrayList()) {

    scores[count] = player.getWins();
    users[count] = player.getName();
    count++;

   } 

  sortHighScores(scores, users);
  for(int x=0;x<playerSize;x++) {
   System.out.printf("%-25s%27d\n",users[x] , scores[x]);
  }

   if(pressQ().equals("q"))
    displayMenu();
  }

 public static void sortHighScores(int [] arr, String [] arra) {

  int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] < arr[j+1]) 
                { 
                    int temp = arr[j]; 
                    String tempura = arra[j];
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    arra[j] = arra[j+1];
                    arra[j+1] = tempura;
                } 
 }

 static void displayCredits() throws InterruptedException, IOException {
  System.out.println("***********************************");
     System.out.println("Blackjack Extreme " + "v" +ProjectFileIO_v2.getVersionNumber());
     System.out.println("Authors:");
     System.out.println("Luis Gascon"); 
     System.out.println("Austin Connick");
     System.out.println("***********************************");
     Thread.sleep(3000); 
     displayMenu();

 }

 static void displayAbout() throws InterruptedException, IOException {
  System.out.printf("%35s\n%37s\n\n", "About", "*********");
  System.out.println("We consider this game an extreme version of BlackJack because\n" +
         "the winning number varies from each round.\n" +
         "It could be a ridiculously high number,\n" +
         "or it could be a ridiculously low number. \n" +
         "The dealer, or you, could possibly bust at the start of the round.\n" +
         "Also, the value of the ace card is a 3rd of the total value of your hand\n"
         );

   if(pressQ().equals("q"))
    displayMenu();
  
 }

 static void displayThanks() {
  //Displays a thank you message when user quits 
  //Create an ASCII art 
  System.out.println(" ______                 _                          _ \n" +
        "|__  __|               | |                        | |\n" +
        "  |  | |__   __ _ _ __ | | __  _   _  ___  _   _  | |\n" +
        "  |  | '_ \\ / _` | '_ \\| |/ / | | | |/ _ \\| | | | | |\n" +
        "  |  | | | | (_| | | | |   <  | |_| | (_) | |_| | |_|\n" +
        "  |  |_| |_|\\__,_|_| |_|_|\\_\\  \\__, |\\___/ \\__,_| (_)\n" +
        "                                __/ |                \n" +
        "                               |___/                 ");

 }

 static String pressQ() {

  System.out.println("Enter q to quit");
  String q = input.next();

  while(!q.equals("q")) {
   System.out.println("Enter q to quit");
   q = input.next();
  }
  return q;
 }


 /****************** 
     Start of Game logic 
  *******************/

 static void mainGame() throws IOException {

  int bet = 0; //Holds player bet temp
  boolean run = true; // when to quit game loop
  int move = 0; // waht the player wants to do
  int numberDraws = 2; // number of cards the user gets will change with random nuber gen
  int drawFactor = 12; // the number of cards with respect to the hand
  int compHit = 16; // the values that the computer will hit to changes with random number 
  int CARDGAMENUM = 21; // blcakjack changes with random number 
  boolean runTwo = true; // back to main exit
  //Loop sets up the bets for the player and get all the random values need for next loop
  while(runTwo) {
   PlayerHand.reset(playingDeck);
   CompHand.reset(playingDeck);
   ProjectFileIO_v2.writeFile();
   creditsEarned = ProjectFileIO_v2.getPlayer(username, passwd).getCreditsEarned();
   creditsLost = ProjectFileIO_v2.getPlayer(username, passwd).getCreditsLost();
   highestCredits = ProjectFileIO_v2.getPlayer(username, passwd).getHighestCredits();
   bankRuptcies = ProjectFileIO_v2.getPlayer(username, passwd).getBankRuptcies();
   wins =  ProjectFileIO_v2.getPlayer(username, passwd).getWins();
   loses =  ProjectFileIO_v2.getPlayer(username, passwd).getLoses();
   currentCredits = ProjectFileIO_v2.getPlayer(username, passwd).getCredits();


   if(currentCredits <= 0) {
    System.out.println("Thank you for playing! Have 1500 " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCurrency() + " on us");
    currentCredits = 1500;
    updateplayer();

   }

   playingDeck.createDeck();
   playingDeck.shuffle();
   CARDGAMENUM = IR4.getRandomNumber(20, 45);
   compHit = CARDGAMENUM - 6 ;
   System.out.printf(ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCurrency()+" = "+currentCredits+"\n");
   Print.printWiningscore(CARDGAMENUM);

   if(currentCredits > 0) {
    bet = placeBets(currentCredits);
   }
   numberDraws = CARDGAMENUM /drawFactor;
   

   //////////////////////Number of starting cards for player
   for(int i = 0; i<= numberDraws; i++) {
    PlayerHand.draw(playingDeck);
   }

   //////////////////////Number of starting cards for Comp
   for(int i = 1; i< numberDraws; i++) {
    CompHand.draw(playingDeck);
   }
   CompHand.draw(playingDeck);

   if(bet == 0) {
    runTwo = false;
    updateplayer();
   }

   run = true;
   //loop run till the player meets one of the win lose conditions
   while(run && bet != 0) {

    Print.dividers();
    System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");
    screenprint(CARDGAMENUM);

    /************
       Bust
     *************/

    if(PlayerHand.cardValue() > CARDGAMENUM && run != false) {
     bust(bet,CARDGAMENUM);
     run = false;

     updateplayer();
    }

    /******************************** 
        If user gets an instant BlackJack! 
     *********************************/

    if(PlayerHand.cardValue() == CARDGAMENUM && run != false) {
     BlackJack(bet,CARDGAMENUM);
     run = false; 

     bJCount++;
     ProjectFileIO_v2.getPlayer(username, passwd).setbJCount(bJCount);
    }

    ///////////////////////////////////BlackJack comp/////////////////////

    if(CompHand.cardValue() == CARDGAMENUM && run != false) {
     BlackJackdealer(bet,CARDGAMENUM);
     run = false;


    }
    if(run != false) {
     move = getMove();
    }

    ////////////////////User quitting and saving statistics////////////////

    if(move == 3) {
     run = false;
     runTwo = false;
     updateplayer();

    }

    ////////////////////////////Hit////////////////////////////////////////

    if(move == 1 && run != false) {
     PlayerHand.draw(playingDeck);

     //////////////////////////////////////bust/////////////////////////

     if(PlayerHand.cardValue() > CARDGAMENUM) {

      bust(bet,CARDGAMENUM);
      run = false;
      updateplayer();
     }

     ///////////////////////////////////BlackJacks/////////////////////

     if(PlayerHand.cardValue() == CARDGAMENUM) {
      BlackJack(bet,CARDGAMENUM);
      run = false;
      bJCount++;
      ProjectFileIO_v2.getPlayer(username, passwd).setbJCount(bJCount);

     }

     ////////////////////////////////comp Win//////////////////////////

     if(CompHand.cardValue() > CARDGAMENUM) {

      AIBust(bet,CARDGAMENUM);
      run = false;
      updateplayer();
     }

     ///////////////////////////////bank////////////////////////////////////
     if(currentCredits <= 0) {
      runTwo = false;
      run = false;
      bankRuptcies++;
      ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
      ProjectFileIO_v2.writeFile();
      System.out.println();
      System.out.println("Come back when you get some money buddy! \n");
     }


    }
    ////////////////////////Stand///////////////////////////////////////////

    if(move == 2 && run != false) {
     // run = false;

     /////////////////////////AI/////////////////////////////////////////

     while(CompHand.cardValue() <= compHit) {
      CompHand.draw(playingDeck);
     }
     ///////////////////////////////////BlackJack comp/////////////////////

     if(CompHand.cardValue() == CARDGAMENUM) {
      BlackJackdealer(bet,CARDGAMENUM);
      run = false;


     }

     /////////////////Player wins///////////////////////////////////////

     else if(CompHand.cardValue() < PlayerHand.cardValue()&& PlayerHand.cardValue() <= CARDGAMENUM) {

      win(bet,CARDGAMENUM);
      run = false;

     }

     ////////////////////////////AI wins////////////////////////////////

     else if(CompHand.cardValue() > PlayerHand.cardValue() && CompHand.cardValue() <= CARDGAMENUM) {
      AIWins(bet,CARDGAMENUM);
      run = false;
      updateplayer();

     }

     ////////////////////////////AI Bust///////////////////////////////////

     else if(CompHand.cardValue() >  CARDGAMENUM && run != false) {
      AIBust(bet,CARDGAMENUM);
      run = false;

     }
     /////////////////////////////////////draw/////////////////////////////

     else if(CompHand.cardValue() == PlayerHand.cardValue() && CompHand.cardValue() <= CARDGAMENUM && PlayerHand.cardValue() <= CARDGAMENUM ) {
      Draw(CARDGAMENUM);
      run = false;

     }
     ///////////////////////////////bank////////////////////////////////////
     if(currentCredits <= 0) {
      runTwo = false;
      run = false;
      bankRuptcies++;
      ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
      ProjectFileIO_v2.writeFile();
      System.out.println();
      System.out.println("Come back when you get some money buddy\n");
     }
    }   
   }

  }
  try {
   displayMenu();
  } catch (IOException e) {
   e.printStackTrace();
  } catch (InterruptedException e) {
   e.printStackTrace();
  }

 }

 private static void BlackJackdealer(int bet,int CARDGAMENUM) throws IOException {
  Print.dividers();
  System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

  screenprint(CARDGAMENUM);
  Print.dividers();
  Print.printDealerwin();
  PlayerHand.reset(playingDeck);
  CompHand.reset(playingDeck);
  loses++;
  creditsLost += bet;

  currentCredits = (currentCredits - bet);
  updateplayer();

 }

 private static void Draw(int CARDGAMENUM) {
  screenprint(CARDGAMENUM);
  Print.Draw();
  Print.dividers();
  PlayerHand.reset(playingDeck);
  CompHand.reset(playingDeck);

 }

 private static void AIWins(int bet, int CARDGAMENUM) throws IOException {
  Print.dividers();
  System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

  screenprint(CARDGAMENUM);
  Print.printDealerwin();
  PlayerHand.reset(playingDeck);
  CompHand.reset(playingDeck);
  Print.dividers();
  loses++;
  creditsLost += bet;

  currentCredits = (currentCredits - bet);
  System.out.println(creditsEarned);
  updateplayer();
 }

 private static void AIBust(int bet, int CARDGAMENUM) throws IOException {
  Print.dividers();
  System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

  screenprint(CARDGAMENUM);
  Print.dealerBust();
  Print.dividers();
  Print.WinningPrints();
  PlayerHand.reset(playingDeck);
  CompHand.reset(playingDeck);
  Print.dividers();
  wins++;
  creditsEarned += bet;

  currentCredits = (currentCredits + bet);

  updateplayer();

 }

 private static void win(int bet, int CARDGAMENUM) throws IOException {
  Print.dividers();
  System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");
  screenprint(CARDGAMENUM);
  Print.WinningPrints();
  PlayerHand.reset(playingDeck);
  CompHand.reset(playingDeck);
  Print.dividers();
  wins++;
  creditsEarned += bet;

  currentCredits = (currentCredits + bet);
  updateplayer();

 }



 private static void BlackJack(int bet,int CARDGAMENUM ) throws IOException {
  Print.dividers();
  System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

  screenprint(CARDGAMENUM);
  Print.dividers();
  Print.WinningPrints();
  PlayerHand.reset(playingDeck);
  CompHand.reset(playingDeck);
  wins++;
  creditsEarned += bet;

  currentCredits = (currentCredits + bet);
  updateplayer();

 }

 private static void bust(int bet, int CARDGAMENUM) {
  Print.dividers();
  System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

  screenprint(CARDGAMENUM);
  Print.dividers();
  Print.bustprint();
  Print.dividers();
  loses++;
  creditsLost += bet;

  currentCredits = (currentCredits - bet);
  PlayerHand.reset(playingDeck);
  CompHand.reset(playingDeck);

 }

 private static void updateplayer() throws IOException {
  peakCredit(currentCredits);
  ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setWins(wins);
  ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setLoses(loses);
  ProjectFileIO_v2.getPlayer(username, passwd).setCreditsEarned(creditsEarned);
  ProjectFileIO_v2.getPlayer(username, passwd).setCreditsLost(creditsLost);
  ProjectFileIO_v2.getPlayer(username, passwd).setCredits(currentCredits);
  ProjectFileIO_v2.writeFile();
  
 }

 private static void screenprint(int CARDGAMENUM) {

  Print.dividers();
  Print.printdealerHand();
  Print.dividers();
  System.out.println(CompHand.toString());
  Print.dividers();
  Print.printHand();
  System.out.printf(PlayerHand.toString());
  Print.dividers();
  Print.printSum();
  Print.dividers();
  System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinning Number: "+ CARDGAMENUM +"\n");
  Print.dividers();

 }

 private static int getMove() {
  int move;
  boolean run = true;
  do{
   System.out.printf("1. Hit\n");

   move = IR4.getInteger("2. Stand\n");
   if(move != 1 && move != 2) {
    System.out.printf("Invald input\n");
    run = true;
   }

  }while(!run);
  return move;
 }

 private static int placeBets(int score) throws IOException {

  int temp = IR4.getInteger("Places Bets or 0 to give up");
  boolean run = true;
  while(run) {
   if(temp <= score && temp > 0) {
    run = false;
    return temp;
   }
   if(temp == 0) {
    run = false;
    return temp;

   }
   else {
    System.out.printf("Invald input\n");
    temp = IR4.getInteger("Places Bets");
    run = true;
   }
  }
  return temp;
 }
 public static int peakCredit(int credits) {
        if(highestCredits < credits) {
            highestCredits = credits;
            ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setHighestCredits(highestCredits);
        }
    return highestCredits;
   }

}




