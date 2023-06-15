package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> strs = getList(str);
        quickSort(strs, 0, strs.size() - 1, ordre);
        return strs;
    }

    /**
     * Cette méthode prend une chaîne de caractères en entrée et retourne une liste
     * de mots.
     * Les mots sont extraits de la chaîne en considérant les caractères
     * alphabétiques seulement.
     * Les espaces entre les mots sont ignorés.
     *
     * @param str la chaîne de caractères à traiter
     * @return une liste de mots extraits de la chaîne
     */
    public static List<String> getList(String str) {
        List<String> list = new ArrayList<>();
        String element;
        int size, i;

        element = "";
        size = str.length();
        for (i = 0; i < size; i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                element += str.charAt(i);
            } else {
                if (element.replace(" ", "").length() != 0) {
                    list.add(element.replace(" ", ""));
                }
                element = "";
            }
        }
        list.add(element);
        return list;
    }

    /**
     * Compare deux chaînes de caractères en utilisant l'ordre spécifié.
     * Les comparaisons sont basées sur le premier caractère de chaque chaîne.
     * Si les deux caractères sont présents dans la liste d'ordre, la méthode
     * retourne true si l'index du premier caractère est inférieur ou égal à l'index
     * du deuxième caractère dans la liste d'ordre.
     *
     * @param str1  la première chaîne de caractères à comparer
     * @param str2  la deuxième chaîne de caractères à comparer
     * @param ordre la liste d'ordre des caractères
     * @return true si le premier caractère de str1 est inférieur ou égal au premier
     *         caractère de str2 dans l'ordre spécifié, sinon false
     */
    public static boolean compareTo(String str1, String str2, List<Character> ordre) {
        char char1, char2;

        char1 = str1.charAt(0);
        char2 = str2.charAt(0);
        if (ordre.contains(char1) && ordre.contains(char2)) {
            return ordre.indexOf(char1) <= ordre.indexOf(char2);
        }
        return false;
    }

    /**
     * Cette méthode trie une liste de chaînes de caractères en utilisant
     * l'algorithme de tri rapide (quick sort).
     * Les chaînes sont triées dans l'ordre spécifié par la liste "order".
     *
     * @param strs  la liste de chaînes de caractères à trier
     * @param low   l'indice de début du sous-tableau à trier
     * @param high  l'indice de fin du sous-tableau à trier
     * @param order la liste d'ordre des caractères
     */
    public static void quickSort(List<String> strs, int low, int high, List<Character> order) {
        if (low < high) {
            int pivotIndex = partition(strs, low, high, order);

            quickSort(strs, low, pivotIndex - 1, order);
            quickSort(strs, pivotIndex + 1, high, order);
        }
    }

    /**
     * Cette méthode effectue la partition d'un sous-tableau dans le tri rapide.
     * Elle utilise la dernière chaîne de caractères (pivot) comme référence pour la
     * partition.
     *
     * @param strs  la liste de chaînes de caractères à trier
     * @param low   l'indice de début du sous-tableau à trier
     * @param high  l'indice de fin du sous-tableau à trier
     * @param order la liste d'ordre des caractères
     * @return l'indice de pivot après la partition
     */
    public static int partition(List<String> strs, int low, int high, List<Character> order) {
        String pivot = strs.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compareTo(strs.get(j), pivot, order)) {
                i++;
                swap(strs, i, j);
            }
        }
        swap(strs, i + 1, high);
        return i + 1;
    }

    /**
     * Cette méthode échange les positions de deux éléments dans une liste de
     * chaînes de caractères.
     *
     * @param strs la liste de chaînes de caractères
     * @param i    l'indice du premier élément à échanger
     * @param j    l'indice du deuxième élément à échanger
     */
    public static void swap(List<String> strs, int i, int j) {
        String temp = strs.get(i);
        strs.set(i, strs.get(j));
        strs.set(j, temp);
    }
}
