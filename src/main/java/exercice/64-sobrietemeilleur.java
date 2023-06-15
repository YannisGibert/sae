package exercice;

import java.util.*;

public class sobrietemeilleur {
    public static List<String> solution(String texte, List<Character> ordre) {
        List<String> motsTries = new ArrayList<>();
        StringBuilder mot = new StringBuilder();
        String[] mots = texte.split("\\W+");

        for (String m : mots) {
            if (!m.isEmpty()) {
                motsTries.add(m);
            }
        }

        Comparator<String> comparator = (mot1, mot2) -> {
            int longueur1 = mot1.length();
            int longueur2 = mot2.length();
            int longueurMin = Math.min(longueur1, longueur2);

            for (int i = 0; i < longueurMin; i++) {
                char char1 = mot1.charAt(i);
                char char2 = mot2.charAt(i);
                int index1 = ordre.indexOf(char1);
                int index2 = ordre.indexOf(char2);

                if (index1 != -1 && index2 != -1) {
                    if (index1 != index2) {
                        return Integer.compare(index1, index2);
                    }
                } else if (index1 == -1 && index2 == -1) {
                    continue;
                } else if (index1 == -1) {
                    return 1;
                } else if (index2 == -1) {
                    return -1;
                }
            }

            return Integer.compare(longueur1, longueur2);
        };

        motsTries.sort(comparator);

        return motsTries;
    }
}
