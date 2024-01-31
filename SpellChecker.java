
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		//System.out.println(levenshtein(word1, Word2));
	}

	public static String tail(String str) {
		// Your code goes here
		String tail = str.substring(1);
		return tail;
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if (word1.isEmpty()) {
			return word2.length();
		} 
		if (word2.isEmpty()) {
			return word1.length();
		}

		char head1 = word1.charAt(0);
		char head2 = word2.charAt(0);

		 if (head1 == head2){
			return levenshtein(tail(word1), tail(word2));
		}
		return  1 + (Math.min(levenshtein(tail(word1), word2), Math.min(levenshtein(word1, tail(word2)), levenshtein(tail(word1), tail(word2)))));

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here

		for (int i = 0; i < 3000; i++){
			dictionary[i] = in.readLine();
		}


		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int min = threshold;
		String minWord = "";
		for (int i = 0; i < dictionary.length; i++){
			if (levenshtein(word, dictionary[i]) < min ){
				minWord = dictionary[i];
				min = levenshtein(word, dictionary[i]);
			}
		}

		return minWord;
	}
	

}
