package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
	public static List<String> solution(String str, List<Character> ordre) {

		if (str.isEmpty()) {
			return List.of();
		}
		if (str.isBlank()) {
			return List.of();
		}

		String copieStr = str;

		char[] tabCharReplace = { '\'', '-', ',', ';', '?', '!', '\"' };

		for (int i = 0; i < tabCharReplace.length; i++) {
			copieStr = copieStr.replace(tabCharReplace[i], ' ');
		}
		String[] strSplit = copieStr.split(" ");

		ArrayList<String> alReponse = new ArrayList<String>();
		for (int i = 0; i < strSplit.length; i++) {
			alReponse.add(strSplit[i]);
		}

		ArrayList<String> nonTriable = new ArrayList<String>();
		ArrayList<Integer> indexASupprimer = new ArrayList<Integer>();

		boolean changement = true;
		for (int i = 0; changement; i = (i + 1) % (strSplit.length)) {
			changement = false;
			for (int j = 0; j < alReponse.size() - 1; j++) {

				int comparateur = compare(alReponse.get(j), alReponse.get(j + 1), ordre);

				switch (comparateur) {
					case 1000:
						nonTriable.add(alReponse.get(j));
						nonTriable.add(alReponse.get(j + 1));
						indexASupprimer.add(j + 1);
						indexASupprimer.add(j);
						j++;
						changement = true;
						break;

					case 999:
						nonTriable.add(alReponse.get(j));
						indexASupprimer.add(j);
						changement = true;
						break;

					case 1001:
						nonTriable.add(alReponse.get(j + 1));
						indexASupprimer.add(j + 1);
						changement = true;
						break;

					case 1:
						String tmp = alReponse.get(j);
						alReponse.set(j, alReponse.get(j + 1));
						alReponse.set(j + 1, tmp);
						changement = true;
						break;
				}

				for (Integer indexSup : indexASupprimer) {
					alReponse.remove(indexSup.intValue());
				}
				indexASupprimer.clear();
			}

		}
		for (int i = alReponse.size() - 1; i >= 0; i--) {
			if (alReponse.get(i).isBlank()) {
				alReponse.remove(i);
			}
		}

		alReponse.addAll(nonTriable);

		return alReponse;
	}

	private static int compare(String str1, String str2, List<Character> ordre) {
		if (str1.isEmpty() & str2.isEmpty()) {
			return 0;
		}

		int rankStr1 = Integer.MAX_VALUE;
		if (!str1.isEmpty()) {
			char firstCharStr1 = str1.charAt(0);
			if (ordre.contains(firstCharStr1)) {
				rankStr1 = ordre.indexOf(firstCharStr1);
			}
		} else {
			return 1;
		}

		int rankStr2 = Integer.MAX_VALUE;
		if (!str2.isEmpty()) {
			char firstCharStr2 = str2.charAt(0);
			if (ordre.contains(firstCharStr2)) {
				rankStr2 = ordre.indexOf(firstCharStr2);
			}
		} else {
			return -1;
		}

		if (rankStr1 == Integer.MAX_VALUE & rankStr2 == Integer.MAX_VALUE) {
			return 1000;
		}
		if (rankStr1 == Integer.MAX_VALUE) {
			return 999;
		}
		if (rankStr2 == Integer.MAX_VALUE) {
			return 1001;
		}

		if (rankStr1 < rankStr2) {
			return -1;
		}
		if (rankStr2 < rankStr1) {
			return 1;
		}
		if (compare(str1.substring(1), str2.substring(1), ordre) > 2) {
			return 0;
		} else {
			return compare(str1.substring(1), str2.substring(1), ordre);
		}
	}
}
