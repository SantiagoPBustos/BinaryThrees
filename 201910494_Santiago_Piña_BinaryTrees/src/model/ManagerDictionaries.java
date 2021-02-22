package model;

import structures.BinarySearchTree;

public class ManagerDictionaries {
	
	private ComparatorWords comparator;
	private BinarySearchTree<Word> englishDictionary;
	private BinarySearchTree<Word> frenchDictionary;
	
	public ManagerDictionaries() {
		comparator=new ComparatorWords();
		englishDictionary=new BinarySearchTree<Word>(comparator);
		frenchDictionary=new BinarySearchTree<Word>(comparator);
	}
	
	public BinarySearchTree<Word> getEnglishDictionary() {
		return englishDictionary;
	}
	
	public void setEnglishDictionary(BinarySearchTree<Word> englishDictionary) {
		this.englishDictionary = englishDictionary;
	}
	
	public BinarySearchTree<Word> getFrenchDictionary() {
		return frenchDictionary;
	}
	
	public void setFrenchDictionary(BinarySearchTree<Word> frenchDictionary) {
		this.frenchDictionary = frenchDictionary;
	}
	
	public void addWordToEnglishDictionary(Word word) {
		englishDictionary.insert(word);
	}
	
	public String traductionToEnglish(String spanishWord) {
		Word word=new Word(spanishWord, "");
		word=englishDictionary.searchData(word);
		if (word==null) {
			return "";
		}else {
			return word.getTranslation();
		}
	}
	
	public int numbersTraductionsToEnglish() {
		return englishDictionary.size(englishDictionary.getRoot());
	}
	
	public void addWordToFrenchDictionary(Word word) {
		frenchDictionary.insert(word);
	}

	public String traductionToFrench(String spanishWord) {
		Word word=new Word(spanishWord, "");
		word=frenchDictionary.searchData(word);
		if (word==null) {
			return "";
		}else {
			return word.getTranslation();
		}
	}

	public int numbersTraductionsToFrench() {
		return frenchDictionary.size(frenchDictionary.getRoot());
	}
	
	public String showElements(BinarySearchTree<Word> dictionary) {
		return dictionary.show(dictionary.getRoot());
	}

}
