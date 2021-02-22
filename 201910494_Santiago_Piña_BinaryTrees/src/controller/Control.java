package controller;

import model.ManagerDictionaries;
import model.Word;

public class Control {
	
	ManagerDictionaries dictionaries;
	
	public Control() {
		dictionaries=new ManagerDictionaries();
		
		//Añadir palabras con su traduccion al diccionario de ingles
		dictionaries.addWordToEnglishDictionary(new Word("Arbol","Tree"));
		dictionaries.addWordToEnglishDictionary(new Word("Papel","Paper"));
		dictionaries.addWordToEnglishDictionary(new Word("Manzana","Apple"));
		dictionaries.addWordToEnglishDictionary(new Word("Estudiante","Student"));
		
		//Obtener traduccion
		//Si retorna vacio la palabra no esta en el diccionario 
		if (dictionaries.traductionToEnglish("Arbol")=="") {
			System.out.println("No esta registrada la traducion");
		}else {
			System.out.println("Traduccion: "+dictionaries.traductionToEnglish("Arbol"));
		}
		
		//Numero de palabras
		System.out.println(dictionaries.numbersTraductionsToEnglish());
		
		//Añadir palabras con su traduccion al diccionario de frances
		dictionaries.addWordToFrenchDictionary(new Word("Lapiz","Crayon"));
		dictionaries.addWordToFrenchDictionary(new Word("Pasta","coller"));
		dictionaries.addWordToFrenchDictionary(new Word("Amor","Amour"));
		
		//Obtener traduccion
		//Si retorna vacio la palabra no esta en el diccionario 
		if (dictionaries.traductionToFrench("Lapiz")=="") {
			System.out.println("No esta registrada la traducion");
		}else {
			System.out.println("Traduccion: "+dictionaries.traductionToFrench("Lapiz"));
		}
				
		//Numero de palabras
		System.out.println(dictionaries.numbersTraductionsToFrench());
		
		//Mostrar elementos
		System.out.println(dictionaries.showElements(dictionaries.getEnglishDictionary())+"\n");
		System.out.println(dictionaries.showElements(dictionaries.getFrenchDictionary()));
		
		
	}
}