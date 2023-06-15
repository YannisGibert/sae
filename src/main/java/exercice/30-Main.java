import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        String texte = "Il fait beau aujourd’hui comme Ici"; 
        ArrayList<String> ordre = new ArrayList<>(Arrays.asList("f", "I", "e", "c", "a", "b"));

        System.out.println("Texte : " + texte);
        System.out.println("Ordre : " + ordre.toString());
        System.out.println("Résultat : " + trier(texte, ordre));

    }


    public static ArrayList<String> trier(String texte, ArrayList<String> ordre) {
        String[] tableauMots = texte.split(" ");
        ArrayList<String> mots = new ArrayList<>(Arrays.asList(tableauMots));
        ArrayList<String> mots2 = new ArrayList<>(Arrays.asList(tableauMots));
        for (int i= 0; i <ordre.size(); i++) {
            System.out.println(ordre.get(i));
            for( String mot : mots2) {
                System.out.println(mot);
                String lettre = String.valueOf(mot.charAt(0));
                if( lettre.equals(ordre.get(i))) {
                    System.out.println(i);
                    mots.remove(mot);
                    mots.add(i, mot);
                }
            }
        }
        
        return mots;
    }

}