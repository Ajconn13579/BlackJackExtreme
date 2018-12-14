//Austin 
//Luis
//Final
import java.io.IOException;


 public class Main {

 public static void main(String[] args) 
 throws IOException, InterruptedException {
  ProjectFileIO_v2.readFile();
  System.out.println("Welcome to BlackJack Extreme\nPlease log in :)\n");
  Game.logIn();
  while(!Game.displayMenu());
 }
}
