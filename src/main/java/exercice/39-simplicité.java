package exercice;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercice {
    public static List<String> solution(String phrase, List<Character> ordre) {
        
        List<String> mots = new ArrayList<>();
        List<String> motsHorsListe = new ArrayList<>();
        List<String> chiffres = new ArrayList<>();


        Pattern pattern = Pattern.compile("[a-zA-Z0-9']+");
        Matcher matche = pattern.matcher(phrase);



        while (matche.find()) {
            String mot = matche.group();

            if (Character.isDigit(mot.charAt(0))) {
                chiffres.add(mot);

            } else if (ordre.contains(Character.toLowerCase(mot.charAt(0)))) {
                mots.add(mot);

            } else {
                motsHorsListe.add(mot);
                
            }
        }


        mots.sort(new LettreComparator(ordre));

        List<String> phraseDansLOrdre = new ArrayList<>();
        phraseDansLOrdre.addAll(chiffres);
        phraseDansLOrdre.addAll(mots);
        phraseDansLOrdre.addAll(motsHorsListe);

        return phraseDansLOrdre;
    }



    static class LettreComparator implements Comparator<String> {
        private List<Character> lettres;

        public LettreComparator(List<Character> ordre) {
            this.lettres = ordre;
        }

        @Override
        public int compare(String mot1, String mot2) {

            int minLength = Math.min(mot1.length(), mot2.length());


            for (int i = 0; i < minLength; i++) {
                char lettre1 = Character.toLowerCase(mot1.charAt(i));
                char lettre2 = Character.toLowerCase(mot2.charAt(i));

                int index1 = lettres.indexOf(lettre1);
                int index2 = lettres.indexOf(lettre2);


                if (index1 != index2) {
                    return Integer.compare(index1, index2);
                }

            }

            return Integer.compare(mot1.length(), mot2.length());
        }

    }
}