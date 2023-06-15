package exercice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();

        for (Character lettre : ordre) {
            map.put(lettre, new ArrayList<>());
        }

        int startIndex = 0;
        int wordLength = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c) || Character.isDigit(c)) {
                if (wordLength == 0) {
                    startIndex = i;
                }
                wordLength++;
            } else {
                if (wordLength > 0) {
                    String word = str.substring(startIndex, startIndex + wordLength);
                    Character firstChar = word.charAt(0);
                    if (map.containsKey(firstChar)) {
                        map.get(firstChar).add(word);
                    } else {
                        map.get(ordre.get(ordre.size() - 1)).add(word);
                    }
                    wordLength = 0;
                }
            }
        }

        if (wordLength > 0) {
            String lastWord = str.substring(startIndex, startIndex + wordLength);
            Character firstChar = lastWord.charAt(0);
            if (map.containsKey(firstChar)) {
                map.get(firstChar).add(lastWord);
            } else {
                map.get(ordre.get(ordre.size() - 1)).add(lastWord);
            }
        }

        for (Character lettre : ordre) {
            result.addAll(map.get(lettre));
        }

        return result;
    }
}