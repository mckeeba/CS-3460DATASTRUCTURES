

import java.util.Scanner;
import java.io.*;

public class SpellChecker
{
	private static final String DICT_FILE = "dictionary.txt";
	public static void main(String[] args)
	{
		File f = new File(DICT_FILE);
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(f);
			StringSet set = new StringSet();

			while (scanner.hasNext())
			{
				
				String word = scanner.next();
				//inserting the word into our hashtable
				set.insert(word);
			}

			scanner.close();
			System.out.println("Loaded " + DICT_FILE);

			scanner = new Scanner(System.in);
			while (scanner.hasNext())
			{
				String word = scanner.next();
				if (set.find(word))
					System.out.println(word + " is a valid word.");
				else
				{
					System.out.println("Could not find " + word);
					System.out.println("Consider the following alternatives...");
					// TODO: Suggest alternatives by looking in the set for all words with only one character difference.

					//this loop iterates through my word
					for(int i = 0; i < word.length(); i++)
					{
						//This loop will iterate from a to z and check if that char c is a valid character to a word 
						//that we have in our table if it is we will then print out the valid words from our table
						for(char c = 'a'; c <= 'z'; c++)
						{
							String copyWord = word;
						   //use StringBuilder, makes a my Word variable of type StringBuilder and passes in the word
						   //Does this copy the word so that we can make sure for each iteration through our word will set it back after the fact.??
						   StringBuilder myWord = new StringBuilder(copyWord);

						   //this will set our character at the current index of our word to a new character,
						   // i: iterate index, c: iterated char from a-z 
						    myWord.setCharAt(i,c);

							
							
							//if  we find a word in our table that matches the word we have made from cycling through characters print the word 
							if(set.find(myWord.toString()))
						   {
							 
							System.out.println(myWord.toString());
						   }
						}
					}

				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open file " + DICT_FILE);
			e.printStackTrace();
		}
	}
}