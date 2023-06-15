package exercice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        // découpe des mots
        List<String> mots = new ArrayList<>(List.of(str.split("\\W+")));  // \W = ni lettre ni chiffre

        // tri des mots
        OrdreComparateur cmp = new OrdreComparateur(ordre);
        mots.sort(cmp);
        
        return mots;
    }

    /**
     * Une classe pour comparer les chaines selon un ordre d'alphabet donné.
     * Les Comparator java comparent deux valeurs x et y et répondent :
     * -1 pour x < y
     * 1 pour x > y
     * 0 pour x == y
     */
    protected static class OrdreComparateur implements Comparator<String> {

        List<Character> ordre;

        public OrdreComparateur(List<Character> ordre) {
            this.ordre = ordre;
        }

        @Override
        public int compare(String chaine1, String chaine2) {
            for (char c : this.ordre) {
                if (chaine1.charAt(0) == c)
                    if (chaine2.charAt(0) == c) return 0;  // égalité
                    else return -1;   // chaine1 vient avant
                else if (chaine2.charAt(0) == c) return 1;   // chaine 2 vient avant
            }
            return 0;  // deux premières lettres inconnues ; toujours égalité
        }
    }
}
