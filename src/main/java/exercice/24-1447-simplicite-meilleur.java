package exercice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> resultat = new ArrayList<>();
        String[] mots = str.split(" ");

        List<String> motsClasses = new ArrayList<>();
        List<String> motsNonClasses = new ArrayList<>();

        for (char c : ordre) {
            for (String mot : mots) {
                if (mot.charAt(0) == c) {
                    motsClasses.add(mot);
                }
            }
        }

        for (String mot : mots) {
            if (!motsClasses.contains(mot)) {
                motsNonClasses.add(mot);
            }
        }

        resultat.addAll(motsClasses);
        resultat.addAll(motsNonClasses);

        return resultat;
    }
}