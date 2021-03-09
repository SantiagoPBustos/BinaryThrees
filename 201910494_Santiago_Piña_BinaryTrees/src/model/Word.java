package model;

public class Word {
	
	private String spanishWord;
	private String translation;
	
	public Word(String spanishWord,String translation) {
		this.spanishWord=spanishWord;
		this.translation=translation;
	}

	public String getSpanishWord() {
		return spanishWord;
	}

	public void setSpanishWord(String spanishWord) {
		this.spanishWord = spanishWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public String toString() {
		return "["+spanishWord+translation+"]";
	}

}
