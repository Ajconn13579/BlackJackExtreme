
import java.io.*;
import java.util.*;

public class ProjectFileIO_v2 {
    //Global Constants
    private static String FILE_NAME = "FileTest-1.txt";
    
    private static String EOF_MARKER             = "-";
    private static String PLAYER_MARKER          = "=";
    private static String GLOBAL_SETTINGS_MARKER = ">";
    private static String COMMENT_MARKER         = "*";
    
    private static String VERSION_NUMBER = ".69";
    
    //Global Variables related to file IO 
    private static FileReader fr;
    private static BufferedReader br;
    
    private static FileWriter  fw;
    private static PrintWriter pw;
    
    //Data related to the Player objects
    private static ArrayList<Player> playerArrayList = new ArrayList<Player>();

    //================================================================================================================

    public static void main(String[] args) throws IOException {
        readFile();   
        writeFile(); 
    }
    
    //================================================================================================================
    
    public static void readFile() throws IOException {
        //System.out.println("Reading File...\n");
        playerArrayList.clear();
        try {
            boolean keepGoing = true;
            
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);
            
            //The Priming Read 
            String entireLine = getLine();
            
            //Loop through the File Header data ------------------------------
            while (entireLine.substring(0,1).equals(COMMENT_MARKER)){ 
                //System.out.println(entireLine);                
                entireLine = getLine();  
            }
            
            //Loop through the Global Settings -------------------------------
            if (entireLine.equals(GLOBAL_SETTINGS_MARKER)){
                keepGoing = true;
                do {
                    readAllGlobalSettings(entireLine);
                    
                    entireLine = getLine();
                    //Look for last line of Global Settings
                    if (entireLine.substring(0,1).equals(GLOBAL_SETTINGS_MARKER)){
                        keepGoing = false;
                    }
                } while (keepGoing);
            }
            
            //Loop through the Player data ------------------------------------
            keepGoing = true;
            do {
                if (entireLine.substring(0,1).equals(PLAYER_MARKER)) {
                    readPlayerData(entireLine);
                }
                
                entireLine = getLine();
                //Look for last line in the file
                if (entireLine.substring(0,1).equals(EOF_MARKER)){
                    keepGoing = false;
                }
            } while (keepGoing);
            
            br.close();       
        }
        catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + " not found. Creating a new one");
            //writeNewPlayer("Guest", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "credits");
                
            writeFile();
            //readFile();
        }
        catch (EOFException e) {
            System.out.println("Unexpected End of File found");
        }
        catch (Exception e) {
            System.out.println("Unexpected Exception found");
        }
    }
    
    //ADJUST AS NECESSARY!
    private static void readAllGlobalSettings(String entireLine) {
        //Add a file IO read of all the global settings for the game. 1 for each line        
    }
    
    //ADJUST AS NECESSARY!
    private static void readPlayerData(String entireLine){
        String name = getLine();  
        String password = getLine();
        String wins = getLine();
        String loses = getLine();
        String bJCount = getLine();
        String rounds = getLine();
        String currentCredits = getLine();
        String creditsEarned = getLine();
        String creditsLost = getLine();
        String highestCredits = getLine();
        String bankRuptcies = getLine();
        String currency = getLine();
    
        writeNewPlayer(name, password, Integer.parseInt(wins), Integer.parseInt(loses), Integer.parseInt(rounds), Integer.parseInt(bJCount),  
                Integer.parseInt(currentCredits), Integer.parseInt(creditsEarned), Integer.parseInt(creditsLost), 
                Integer.parseInt(highestCredits), Integer.parseInt(bankRuptcies), currency);
    }
    
    //ADJUST AS NECESSARY!
    private static void writeNewPlayer(String name, String password, int wins, int loses, int rounds,  
      int bjCount, int credits, int creditsPlus, int creditsMinus, int peakCredit, int bankruptcies, 
      String currency) {
        
     Player playerNew = new Player(name, password, wins, loses, rounds , bjCount, credits, 
          creditsPlus, creditsMinus, peakCredit, bankruptcies, currency);
     
        playerArrayList.add(playerNew);
    }
    
    //----------------------------------------------------------------------------------------------------------------
    
    private static String getLine(){
        String entireLine = "";
        try {
            entireLine = br.readLine();
            //System.out.println(entireLine);  
        }
        catch (FileNotFoundException e) {
            System.out.println(FILE_NAME + " not found. Creating new file.");
        }
        catch (EOFException e) {
            System.out.println("Unexpected End of File found");
        }
         catch (Exception e) {
            System.out.println("Unexpected Exception found");
        }
        return entireLine;        
    }
    
    //====================================WRITING FILE====================================================================
    
    public static void writeFile() throws IOException {
        //System.out.println("\nSaving...");
        
        fw = new FileWriter(FILE_NAME);
        pw = new PrintWriter(fw);
        
        writeHeaderLines();
        writeGlobalSettingsLines();
        writePlayerLines();
        writeEOFline();
        
        pw.close();
        // System.out.println("Save successful");
    }
    
    //ADJUST AS NECESSARY!
    private static void writeHeaderLines(){
        pw.println("***********************************");
        pw.println("* Blackjack Extreme " + getVersionNumber());
        pw.println("* Authors: Luis Gascon & Austin Connick");
        pw.println("***********************************");
        pw.flush();
    }
    
    //ADJUST AS NECESSARY!
    private static void writeGlobalSettingsLines(){
        String settingsMarker = GLOBAL_SETTINGS_MARKER + GLOBAL_SETTINGS_MARKER + GLOBAL_SETTINGS_MARKER;
        pw.println(settingsMarker + " Global Settings " + settingsMarker);
        pw.println("There are no global settings ");
        //pw.println("The 2nd setting would go here...");
        pw.println(settingsMarker + " End of Global Settings " + settingsMarker);
        pw.flush();
    }

    //ADJUST AS NECESSARY!
    private static void writePlayerLines(){
        if (playerArrayList.size() == 0) {
            System.out.println("There is no save file present");
            return;
        }
        
        for (int i = 0; i < playerArrayList.size(); i++){
            String playerMarker = PLAYER_MARKER + PLAYER_MARKER + PLAYER_MARKER + PLAYER_MARKER + PLAYER_MARKER;
            pw.println(playerMarker + " Player#" + i + " " + playerMarker);
            //Unexpected Exception occurs when appending prefixes
            pw.println(playerArrayList.get(i).getName());
            pw.println(playerArrayList.get(i).getPassword());
            pw.println(playerArrayList.get(i).getWins());
            pw.println(playerArrayList.get(i).getLoses());
            pw.println(playerArrayList.get(i).getRounds());
            pw.println(playerArrayList.get(i).getbJCount());
            pw.println(playerArrayList.get(i).getCredits());
            pw.println(playerArrayList.get(i).getCreditsEarned());
            pw.println(playerArrayList.get(i).getCreditsLost());
            pw.println(playerArrayList.get(i).getHighestCredits());
            pw.println(playerArrayList.get(i).getBankRuptcies());
            pw.println(playerArrayList.get(i).getCurrency());
            pw.flush();
        }
    }    
    
    private static void writeEOFline() {
        pw.println(EOF_MARKER + EOF_MARKER + EOF_MARKER + " End of File " + EOF_MARKER + EOF_MARKER + EOF_MARKER);
    }
    
    //==========================================ADDING/MODIFYING THE PLAYER CLASS==============================================================
    
    public static String getVersionNumber() {
        return VERSION_NUMBER;
    }    
    
    public static ArrayList<Player> getPlayerArrayList(){
        return playerArrayList;
    }
    
    public static void setPlayerArrayList(ArrayList<Player> newPlayerArrayList){
        playerArrayList = newPlayerArrayList;
    }
    
    //Returns a Player object
    public static Player getPlayer(String name, String password){
     //Use this method for log in authentication? 
       for (int i = 0; i < playerArrayList.size(); i++){
           if (playerArrayList.get(i).getName().equals(name)
            && playerArrayList.get(i).getPassword().equals(password))
           {
               return playerArrayList.get(i);
           }
       }
       return null; //player was not found
    }
    
    //Finds the specific Player object, deletes it, and adds the new Player object
    public static void updatePlayer(Player newPlayer){
        for (int i = 0; i < playerArrayList.size(); i++){
           if (playerArrayList.get(i).getName().equals(newPlayer.getName())
            && playerArrayList.get(i).getPassword().equals(newPlayer.getPassword()))
           {
               playerArrayList.remove(i);
               playerArrayList.add(newPlayer); 
               return;
           }
       }
        System.out.println("Error in updatePlayer. Player not found.");
        System.exit(-1);
    }    
    
    //Adds the new Player object if there is no duplicate name and password 
    public static boolean addNewPlayer(Player newPlayer){
        for (int i = 0; i < playerArrayList.size(); i++){
           if (playerArrayList.get(i).getName().equals(newPlayer.getName())
            && playerArrayList.get(i).getPassword().equals(newPlayer.getPassword()))
           {
               return false;  //indicates the player could not be added due to a duplicate player name and password. 
           }
       }
        playerArrayList.add(newPlayer); 
        return true; //the player was added successfully. 
    }    
}