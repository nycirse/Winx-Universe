package Bataille;

import java.util.ArrayList;
import java.util.List;

import protagonistes.Fee;
import protagonistes.Sorciere;

public class Camps {
    private static List<Sorciere> witch= new ArrayList<>(16);
	private static List<Fee> fee= new ArrayList<>(16);

	public void supprimerS(Sorciere w) {
		witch.remove(w);
	}
	public void supprimerF(Fee f) {
		fee.remove(f);
	}

	public static  int nbSorcieres() {
		return witch.size();
	}

	public static int nbFees() {
		return fee.size();
	}
	
	public static  String finPartie(){
        String txt=" ";
        if (nbSorcieres()==0 || nbFees()==0){
            txt+="C'est la fin de la partie";
        }
        else{
            txt+="Passez au tour suivant";
        }
        return txt;
    }
    }
