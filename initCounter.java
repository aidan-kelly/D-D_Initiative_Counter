//Programmed by Aidan Kelly
//This program takes in a file containing the names and initiative rolls of
//Dungeons and Dragons characters. (The roll is randomized by the player because rolling dice
//is fun). It then sorts these rolls and displays the initiative order of the characters
//via GUI.

package initCounter;
import	java.util.*;
import	java.io.*;

public class initCounter {

	public static void main(String[] args) {
		
		//creates variables to be used later on.
		Random rand = new Random();
		ArrayList<Tuple> listChar = new ArrayList<Tuple>();
		File charFile = new File("charFile.txt");
		File monFile = new File("monFile.txt");
		BufferedReader reader = null;
		
		//reads from the character file and puts entries into map
		try{
			
			//sets up reader and variables
			reader = new BufferedReader(new FileReader(charFile));
			String line = null;
			String[] charArgs = null;
			
			//loops through the file
			while((line = reader.readLine()) != null){
				
				//splits into name of character and their roll.
				charArgs = line.split(" ");
				
				//places into the map
				Tuple t = new Tuple(Integer.parseInt(charArgs[1]), charArgs[0]);
				listChar.add(t);				
			}
			
		//exception handling
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		//reads the monsters from the file
		try{
			
			//sets up reader and variables
			reader = new BufferedReader(new FileReader(monFile));
			String line = null;
			String[] monArgs = null;
			
			//reads through the monster file line by line
			while((line = reader.readLine()) != null){
				
				//splits line into name and dex mod
				monArgs = line.split(" ");
				
				//generates random dice roll and adds the dex mod.
				Integer key = (rand.nextInt(20)+1)+Integer.parseInt(monArgs[1]);
				

				Tuple t = new Tuple(key, monArgs[0]);
				listChar.add(t);					
			}
		
		//exception handling
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		//sorts the list
        Collections.sort(listChar);
        
        //prints out the sorted list
		for(Tuple t : listChar){
			System.out.println(t.toString());
		}
		
	}

}
