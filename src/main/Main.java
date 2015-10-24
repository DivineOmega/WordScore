package main;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
	private static Random random;
	private static HashMap<Character, Integer> charScoreMap = new HashMap<Character, Integer>();
	
	public static void main(String[] args) 
	{
		random = new Random();
		
		String letters = new String("abcdefghijklmnopqrstuvwxyz");
		
		for (int i = 0; i < letters.length(); i++)
		{
		    Character letter = new Character(letters.charAt(i)); 
		    int score = -50 + random.nextInt(150+1); // score is a random number between -50 and 100
		    
		    charScoreMap.put(letter, score);
		    //System.out.print(letter + "=" + score+", "); // debug output for testing, comment out when playing
		}
		
		System.out.println();
		System.out.println("*** WordScore - By Jordan Hall ***");
		System.out.println();
		
		int minLetters = 2;
		int maxLetters = 15;
		
		Scanner keyboard = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Enter a valid English word (min "+minLetters+" letters, max "+maxLetters+" letters): ");
			
			String word = keyboard.nextLine();
			word = word.toLowerCase();
			
			System.out.println();
			
			if (word.length()>maxLetters)
			{
				System.out.println("I said maximum of "+maxLetters+" letters. That was "+word.length()+" letters.");
				System.out.println();
				continue;
			}
			else if (word.length()<minLetters)
			{
				System.out.println("I said minimum of "+minLetters+" letters. That was "+word.length()+" letters.");
				System.out.println();
				continue;
			}
			
			int score = 0;
			
			boolean invalidCharacters = false;
			
			for (int i = 0; i < word.length(); i++)
			{
				Character letter = new Character(word.charAt(i));
				
				if (!charScoreMap.containsKey(letter))
				{
					invalidCharacters = true;
					break;
				}
				
				score += charScoreMap.get(letter);
			}
			
			if (invalidCharacters) {
				System.out.println("I only want you to enter letters. No numbers or special characters.");
				System.out.println();
				continue;
			}
			
			System.out.println("'"+word+"' scored "+score+" points!");
			
			System.out.println();
			
		}
		
		
	}

}
