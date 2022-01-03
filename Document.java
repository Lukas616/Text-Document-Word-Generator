/* 
 * CSC-239 Project 4: Text Document Index Generator
 * Student: 	Lukas Correia
 * Date: 		12/1/2021
 * Description: This program reads a text file and produces a display
 * 				for all distinct words in file, along with the line number,
 * 				and word number values for each location where the word
 * 				appears.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Document {

	// arrayList of Word object.
	private ArrayList<Word> wordArrayList;

	// arrayList of Strings (i.e. the actual lowercase word of the word object in
	// the arrayList).
	private ArrayList<String> wordList;

	// File name variable.
	private File fileName;

	// No args constructor.
	public Document() {
		this.wordArrayList = null;
		this.fileName = null;
		this.wordList = null;
	}

	// Overloaded constructor.
	public Document(File fileName) {
		this.wordArrayList = new ArrayList<>();
		this.fileName = fileName;
		this.wordList = new ArrayList<>();
	}

	public static void main(String[] args) throws FileNotFoundException {

		// Creates new Scanner object.
		Scanner sc = new Scanner(System.in);

		// Prompts user for filename.
		System.out.print("Enter fileName: ");

		// Takes the next user input on the command line.
		String input = sc.nextLine();

		// Creates a new file object with the user input from command line.
		File fileName = new File(input);

		// Create new Scanner object reading in the File fileName as argument.
		Scanner scf = new Scanner(fileName);

		// Creates a new Document object taking the File fileName as argument.
		Document doc = new Document(fileName);

		// Current line number of the file (set at 1).
		int lineNumber = 1;

		// While there's still a line in the file to be processed
		while (scf.hasNextLine()) {
			// Load the line in.
			String line = scf.nextLine();

			// Split up with the given regex into a String array called words.
			String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");

			// For loop to go through the word array.
			for (int i = 0; i < words.length; i++) {

				// Create a new Word object (temporary).
				Word w = new Word(words[i], lineNumber, i + 1);

				// Check the new Word object's word variable,
				// and if it exists in the arrayList wordList,
				// save the index of the existing word within wordList.
				if (doc.wordList.contains(w.getWord())) {
					int index = doc.wordList.indexOf(w.getWord());

					// Go to the Word object of the saved index within the wordArrayList
					// and add to its Occurrence arrayList
					doc.wordArrayList.get(index).addOccurrence(lineNumber, i + 1);
				}

				// If the new Word object's word variable does not exist
				// in the arrayList wordList,
				// add the new Word object's word variable to wordList,
				// and add the new Word object itself to wordArrayList.
				else {
					doc.wordList.add(w.getWord());
					doc.wordArrayList.add(w);
				}
			}
			// Increase lineNumber to track what line we are currently on.
			lineNumber++;
		}

		// Sorts the wordArrayList alphabetically
		doc.wordArrayList.sort(new Comparator<Word>() {
			@Override
			public int compare(Word o1, Word o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});

		// Prints out output
		for (int i = 0; i < doc.wordArrayList.size(); i++) {
			System.out.printf("%s(%d): " + doc.wordArrayList.get(i).getOccList(), doc.wordArrayList.get(i).getWord(),
					doc.wordArrayList.get(i).getOccurrence());
			System.out.println();
		}
	}

}
