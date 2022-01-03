import java.util.ArrayList;

public class Word {

	// The lowercase word in String form.
	private String word;

	// List of Occurrences of the word within the documents.
	private ArrayList<Occurrence> occList;

	// No args constructor.
	public Word() {
		word = null;
		occList = null;
	}

	// Overloaded constructor.
	public Word(String lowerCase, int lineNum, int wordNum) {
		this.word = lowerCase;
		this.occList = new ArrayList<Occurrence>();
		occList.add(new Occurrence(lineNum, wordNum));
	}

	// Adds an Occurrence object into the arrayList.
	public void addOccurrence(int lineNo, int wordNo) {

		// Adds an Occurrence object to occList.
		occList.add(new Occurrence(lineNo, wordNo));
	}

	// Getter for word.
	public String getWord() {
		return word;
	}

	// Getter for Occurence list size.
	public int getOccurrence() {
		return occList.size();
	}

	// Getter for Occurence list toString.
	public String getOccList() {
		return occList.toString();
	}

	// Setter for word.
	public void setWord(String word) {
		this.word = word;
	}
}
