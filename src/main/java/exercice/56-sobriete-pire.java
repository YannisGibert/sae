package exercice;

import java.util.ArrayList;
import java.util.List;

public class exercice {

    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<>();
        List<List<String>> buckets = new ArrayList<>(ordre.size());

        for (int i = 0; i < ordre.size(); i++) {
            buckets.add(new ArrayList<>());
        }

        String[] motsTexte = texte.split(" ");

        for (String mot : motsTexte) {
            char premiereLettre = mot.charAt(0);
            int index = ordre.indexOf(premiereLettre);

            if (index >= 0) {
                List<String> motsListe = buckets.get(index);
                motsListe.add(mot);
                buckets.set(index, motsListe);
            }
        }

        for (List<String> motsListe : buckets) {
            mots.addAll(motsListe);
        }

        return mots;
    }
}






