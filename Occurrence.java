public class Occurrence {

	// Stores the line it was on.
	private int lineNum;

	// Stores place/index on the line it was on.
	private int wordNum;

	// No arg constructor.
	public Occurrence() {
		lineNum = 0;
		wordNum = 0;
	}

	// Overloaded constructor.
	public Occurrence(int lineNum, int wordNum) {
		this.lineNum = lineNum;
		this.wordNum = wordNum;
	}

	// Getter for lineNum.
	public int getLineNum() {
		return lineNum;
	}

	// Setter for lineNum.
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	// Getter for wordNum.
	public int getWordNum() {
		return wordNum;
	}

	// Setter for wordNum.
	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}

	// toString method to output idex position in correct format.
	public String toString() {
		return "(" + lineNum + ", " + wordNum + ")";
	}
}
