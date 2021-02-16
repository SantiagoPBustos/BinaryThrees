package model;

import java.util.Comparator;

public class ComparatorWords implements Comparator<Word>{
	
	@Override
	public int compare(Word o1, Word o2) {
		return o1.getSpanishWord().compareTo(o2.getSpanishWord());
	}

}
