package lib.exercises;

class ArraysAndStrings {

	// Exercise 1.5
	static boolean isOneOperationOf(String stringOne, String stringTwo) {
		if (stringOne.equals(stringTwo)) return false;

		for (int i = 0; i < stringOne.length(); i++) {
			if (stringOne.charAt(i) != stringTwo.charAt(i)) {
				// Replace
				if (stringOne.substring(i + 1).equals(stringTwo.substring(i + 1)))
					return true;

				// Insert
				if (stringOne.substring(i).equals(stringTwo.substring(i + 1)))
					return true;

				// Remove
				if (stringOne.substring(i + 1).equals(stringTwo.substring(i)))
					return true;

				return false;
			}
		}

		return false;
	}

	// Exercise 1.6
	static String compress(String string) {
		if (string == null || string.length() == 0)
			return string;

		StringBuilder newString = new StringBuilder();

		newString.append(string.charAt(0));
		int numOccurrences = 1;

		for (int i = 1; i < string.length(); i++) {
			if (newString.charAt(newString.length() - 1) == string.charAt(i)) {
				numOccurrences++;
			} else {
				newString.append(numOccurrences);
				newString.append(string.charAt(i));
				numOccurrences = 1;
			}
		}

		newString.append(numOccurrences);

		if (newString.length() < string.length())
			return newString.toString();
		else
			return string;
	}
}
