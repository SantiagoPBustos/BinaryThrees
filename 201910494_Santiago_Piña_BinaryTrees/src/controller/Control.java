package controller;

import model.ManagerDictionaries;
import model.Word;

public class Control {
	
	ManagerDictionaries dictionaries;
	
	public Control() {
		dictionaries=new ManagerDictionaries();
		
		dictionaries.addWordToEnglishDictionary(new Word("Arbol","Tree"));
		dictionaries.addWordToEnglishDictionary(new Word("Papel","Paper"));
		dictionaries.addWordToEnglishDictionary(new Word("Manzana","Apple"));
		
		if (dictionaries.traductionToEnglish("Arbol")=="") {
			System.out.println("No esta registrada la traducion");
		}else {
			System.out.println("Traduccion: "+dictionaries.traductionToEnglish("Arbol"));
		}
		
	}
	
//	public void menu() {
//		int option=0;
//		while(option!=6) {
//			option=
//		}
//	}
}